package com.flipkart.hackathon.easyhire.service.mongoImpl;

import com.flipkart.hackathon.easyhire.DataStore;
import com.flipkart.hackathon.easyhire.domain.Comment;
import com.flipkart.hackathon.easyhire.service.CommentService;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.QueryBuilder;
import org.bson.types.ObjectId;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * String: rishabh.goyal
 * Date: 02/08/13
 * Time: 1:10 AM
 * To change this template use File | Settings | File Templates.
 */
public class CommentServiceImpl implements CommentService {

    DataStore store;

    public CommentServiceImpl() throws UnknownHostException {
        store = new DataStore("localhost");
    }

    @Override
    public void create(Comment comment) {
        String id = new ObjectId().toString();
        DBObject object = new BasicDBObject();
        object.put("_id", id);
        object.put("id", id);
        object.put("questionId",comment.getQuestionId());
        object.put("commentedBy",comment.getCommentedBy());
        object.put("comment",comment.getComment());
        object.put("commentedOn",comment.getCommentedOn());
        store.create("fk-easyhire","comments",object);
    }

    @Override
    public List<Comment> read(String questionId) {
        DBObject queryObject = new QueryBuilder().put("questionId").is(questionId).get();
        List<DBObject> objects = store.readAll("fk-easyhire", "comments", queryObject);
        List<Comment> comments = new ArrayList<Comment>();
        for( DBObject object : objects) {
            String id = (String) object.get("_id");
            String commentedBy = (String) object.get("commentedBy");
            String comment = (String) object.get("comment");
            Date commentedOn = (Date) object.get("commentedOn");
            comments.add(new Comment(id, questionId,commentedBy,comment,commentedOn));
        }
        return comments;
    }

    @Override
    public void update(Comment comment) {
        DBObject object = new BasicDBObject();
        object.put("_id", comment.getId());
        object.put("id", comment.getId());
        object.put("questionId", comment.getQuestionId());
        object.put("commentedBy", comment.getCommentedBy());
        object.put("commentedOn", comment.getCommentedOn());
        object.put("comment", comment.getComment());
        store.update("fk-easyhire", "comments", object);
    }

    @Override
    public void delete(String commentId) {
        store.delete("fk-easyhire", "comments", commentId);
    }
}
