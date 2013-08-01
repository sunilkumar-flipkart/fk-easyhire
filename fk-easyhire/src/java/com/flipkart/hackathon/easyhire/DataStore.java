package com.flipkart.hackathon.easyhire;

import com.mongodb.*;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * String: rishabh.goyal
 * Date: 02/08/13
 * Time: 1:34 AM
 * To change this template use File | Settings | File Templates.
 */
public class DataStore {
    public MongoClient mongoClient;

    public DataStore(String host) throws UnknownHostException {
        if ( mongoClient == null ){
            mongoClient = new MongoClient(host);
        }
    }

    public void create(String dbName, String collectionName, DBObject object ){
        mongoClient.getDB(dbName).getCollection(collectionName).insert(object);
    }

    public DBObject read(String dbName, String collectionName, String id){
        DBObject queryObject = new QueryBuilder().put("_id").is(id).get();
        return mongoClient.getDB(dbName).getCollection(collectionName).findOne(queryObject);
    }

    public List<DBObject> readAll(String dbName, String collectionName, DBObject queryObject){
        List<DBObject> objects = new ArrayList<DBObject>();
        DBCursor cursor = mongoClient.getDB(dbName).getCollection(collectionName).find(queryObject);
        while (cursor.hasNext()){
            objects.add(cursor.next());
        }
        return objects;
    }

    public void update(String dbName, String collectionName, DBObject object){
        DBObject queryObject = new QueryBuilder().put("_id").is(object.get("_id")).get();
        mongoClient.getDB(dbName).getCollection(collectionName).update(queryObject, object, true, false);
    }

    public void delete(String dbName, String collectionName, String id){
        DBObject object = new BasicDBObject();
        object.put("_id", id);
        mongoClient.getDB(dbName).getCollection(collectionName).remove(object);
    }



}
