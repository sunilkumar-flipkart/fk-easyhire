package com.flipkart.hackathon.easyhire;

import com.flipkart.hackathon.easyhire.domain.Filter;
import com.mongodb.DBObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: rishabh.goyal
 * Date: 02/08/13
 * Time: 7:12 AM
 * To change this template use File | Settings | File Templates.
 */
public class FilterUtilsTest {

    Filter filter;

    @Before
    public void setUp() throws Exception {
        String property = "numberOfVotes";
        String propertyType ="Integer";
        String operator ="EQUAL";
        Object object = new Integer(2);
        filter = new Filter(property,propertyType,operator,object);

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testGetValidOperationForKey() throws Exception {

    }

    @Test
    public void testCreateFilterFromQueryParams() throws Exception {

    }

    @Test
    public void testGetQueryObject() throws Exception {

    }

    @Test
    public void testGetPropertyQueryObject() throws Exception {
        DBObject dbObject= FilterUtils.getPropertyQueryObject(filter);
        System.out.println((String) dbObject.get("value"));
    }

    @Test
    public void testGetValueAccordingToType() throws Exception {

    }

    @Test
    public void testGetFilterAccordingToOperation() throws Exception {

    }
}
