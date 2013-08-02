package com.flipkart.hackathon.easyhire;

import com.flipkart.hackathon.easyhire.domain.Filter;
import com.mongodb.BasicDBList;
import com.mongodb.DBObject;
import com.mongodb.QueryBuilder;

import java.util.*;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: rishabh.goyal
 * Date: 02/08/13
 * Time: 6:02 AM
 * To change this template use File | Settings | File Templates.
 */
public class FilterUtils {

    public static HashMap<String, HashSet<String>> typeOperationMapping;
    public static HashMap<String, String> keyToTypeMapping;

    static {

        typeOperationMapping = new HashMap<String, HashSet<String>>();
        keyToTypeMapping = new HashMap<String, String>();

        String type = Integer.class.getSimpleName();
        HashSet<String> operations = new HashSet<String>();
        operations.add(FilterOperation.EQUAL.name());
        operations.add(FilterOperation.NOT_EQUAL.name());
        operations.add(FilterOperation.LESS_THAN.name());
        operations.add(FilterOperation.GREATER_THAN.name());
        operations.add(FilterOperation.LESS_THAN_EQUALS.name());
        operations.add(FilterOperation.GREATER_THAN_EQUALS.name());
        operations.add(FilterOperation.BETWEEN.name());
        typeOperationMapping.put(type, operations);

        type = String.class.getSimpleName();
        operations = new HashSet<String>();
        operations.add(FilterOperation.EQUAL.name());
        operations.add(FilterOperation.NOT_EQUAL.name());
        typeOperationMapping.put(type, operations);

        type = List.class.getSimpleName();
        operations = new HashSet<String>();
        operations.add(FilterOperation.CONTAINS.name());
        operations.add(FilterOperation.NOT_CONTAINS.name());
        typeOperationMapping.put(type, operations);

        type = Date.class.getSimpleName();
        operations = new HashSet<String>();
        operations.add(FilterOperation.GREATER_THAN.name());
        operations.add(FilterOperation.GREATER_THAN_EQUALS.name());
        operations.add(FilterOperation.LESS_THAN.name());
        operations.add(FilterOperation.LESS_THAN_EQUALS.name());
        operations.add(FilterOperation.BETWEEN.name());
        typeOperationMapping.put(type, operations);

        String key = "createdOn";
        keyToTypeMapping.put(key, Date.class.getSimpleName());

        key = "title";
        keyToTypeMapping.put(key, String.class.getSimpleName());

        key = "creatorId";
        keyToTypeMapping.put(key, String.class.getSimpleName());

        key = "tags";
        keyToTypeMapping.put(key, List.class.getSimpleName());

        key = "numberOfVotes";
        keyToTypeMapping.put(key, Integer.class.getSimpleName());

    }

    public static Set<String> getValidOperationForKey(String key){
        return typeOperationMapping.get(keyToTypeMapping.get(key));
    }

    public static List<Filter> createFilterFromQueryParams(List<String> property, List<String> operators, List<String> values){
        List<Filter> filters = new ArrayList<Filter>();
        for( int i = 0 ; i < property.size(); i++ ){
            Filter filter = getFilterAccordingToOperation(property.get(i), keyToTypeMapping.get(property.get(i)), FilterOperation.valueOf(operators.get(i).toUpperCase()), values.get(i));
            filters.add(filter);
        }
        return filters;
    }

    public static DBObject getQueryObject(List<Filter> filters){
        QueryBuilder qb = new QueryBuilder();
        for ( Filter filter : filters ){
            qb.or(getPropertyQueryObject(filter));
        }
        return qb.get();
    }

    public static DBObject getPropertyQueryObject(Filter filter) {
        String property = filter.getProperty();
        String propertyType = filter.getPropertyType();
        FilterOperation operator = FilterOperation.valueOf(filter.getOperator());
        Object value = filter.getValue();

        if (operator.equals(FilterOperation.EQUAL)) {
            return new QueryBuilder().put(property).is(value).get();
        } else if (operator.equals(FilterOperation.NOT_EQUAL)) {
            return new QueryBuilder().put(property).notEquals(value).get();
        } else if (operator.equals(FilterOperation.SET)) {
            return new QueryBuilder().put(property).exists(true).get();
        } else if (operator.equals(FilterOperation.NOT_SET)) {
            return new QueryBuilder().put(property).is(null).get();
        } else if (operator.equals(FilterOperation.CONTAINS)) {
            if (propertyType.equalsIgnoreCase(String.class.getSimpleName())) {
                return new QueryBuilder().put(property).regex(Pattern.compile(".*" + value.toString() + ".*")).get();
            } else if (propertyType.equalsIgnoreCase(BasicDBList.class.getSimpleName())) {
                List<Object> values = (List<Object>) value;
                return new QueryBuilder().put(property).all(values).get();
            }
        } else if (operator.equals(FilterOperation.NOT_CONTAINS)) {
            return new QueryBuilder().put(property).not().regex(Pattern.compile(".*" + value.toString() + ".*")).get();
        } else if (operator.equals(FilterOperation.LESS_THAN)) {
            return new QueryBuilder().put(property).lessThan(value).get();
        } else if (operator.equals(FilterOperation.LESS_THAN_EQUALS)) {
            return new QueryBuilder().put(property).lessThanEquals(value).get();
        } else if (operator.equals(FilterOperation.GREATER_THAN)) {
            return new QueryBuilder().put(property).greaterThan(value).get();
        } else if (operator.equals(FilterOperation.GREATER_THAN_EQUALS)) {
            return new QueryBuilder().put(property).greaterThanEquals(value).get();
        } else if (operator.equals(FilterOperation.BETWEEN)) {
            List<Object> values = (List<Object>) value;
            if (values.size() == 2) {
                return new QueryBuilder().put(property).greaterThanEquals(values.get(0)).lessThanEquals(values.get(1)).get();
            }
        } else {
            return null;
        }
        return null;
    }

    public static Object getValueAccordingToType(String propertyType, String value) {
        if (propertyType == null) {
            return null;
        }

        try {
            if (propertyType.equalsIgnoreCase(String.class.getSimpleName()) || propertyType.equalsIgnoreCase(List.class.getSimpleName())) {
                return value;
            } else if (propertyType.equalsIgnoreCase(Integer.class.getSimpleName())) {
                return Integer.parseInt(value);
            } else if(propertyType.equalsIgnoreCase(Date.class.getSimpleName())){
                return Date.parse(value);
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    public static Filter getFilterAccordingToOperation(String property, String propertyType, FilterOperation operator, String value) {
        try {
            if (operator.equals(FilterOperation.SET) || operator.equals(FilterOperation.NOT_SET)) {
                return new Filter(property, propertyType, operator.name(), null);
            } else if (operator.equals(FilterOperation.BETWEEN)) {
                String[] array = value.split(":");
                List<Object> val = new ArrayList<Object>();
                boolean check = true;
                for (String tempValue : array) {
                    Object tempVal = getValueAccordingToType(propertyType, tempValue);
                    if (tempVal == null) {
                        check = false;
                        break;
                    }
                    val.add(tempVal);
                }
                if (check) {
                    return new Filter(property, propertyType, operator.name(), val);
                }
            } else if (operator.equals(FilterOperation.CONTAINS) || operator.equals(FilterOperation.NOT_CONTAINS)) {
                if (propertyType.equalsIgnoreCase(List.class.getSimpleName())) {
                    String[] array = value.split(":");
                    List<Object> val = new ArrayList<Object>();
                    boolean check = true;
                    for (String tempValue : array) {
                        Object tempVal = getValueAccordingToType(propertyType, tempValue);
                        if (tempVal == null) {
                            check = false;
                            break;
                        }
                        val.add(tempVal);
                    }
                    if (check) {
                        return new Filter(property, propertyType, operator.name(), val);
                    }
                } else if (propertyType.equalsIgnoreCase(String.class.getSimpleName())) {
                    return new Filter(property, propertyType, operator.name(), value);
                }
            } else {
                Object val = getValueAccordingToType(propertyType, value);
                if (val != null) {
                    return new Filter(property, propertyType, operator.name(), val);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
