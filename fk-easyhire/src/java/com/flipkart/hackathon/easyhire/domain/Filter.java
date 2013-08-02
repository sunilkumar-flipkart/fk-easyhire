package com.flipkart.hackathon.easyhire.domain;

/**
 * Created with IntelliJ IDEA.
 * User: rishabh.goyal
 * Date: 02/08/13
 * Time: 6:17 AM
 * To change this template use File | Settings | File Templates.
 */
public class Filter {
    private String property;
    private String propertyType;
    private String operator;
    private Object value;

    public Filter(String property, String propertyType, String operator, Object value) {
        this.property = property;
        this.propertyType = propertyType;
        this.operator = operator;
        this.value = value;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public String getProperty() {
        return property;
    }

    public String getOperator() {
        return operator;
    }

    public Object getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Filter{" +
                "property='" + property + '\'' +
                ", propertyType='" + propertyType + '\'' +
                ", operator='" + operator + '\'' +
                ", value=" + value +
                '}';
    }
}
