package com.flipkart.hackathon.easyhire.service.mongoImpl;

import com.flipkart.hackathon.easyhire.domain.Comment;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: rishabh.goyal
 * Date: 02/08/13
 * Time: 3:04 AM
 * To change this template use File | Settings | File Templates.
 */
public class CommentServiceImplTest {

    CommentServiceImpl commentService;
    Comment comment;

    @Before
    public void setUp() throws Exception {
        commentService = new CommentServiceImpl();
        String questionId = "51fac7c130046346821f4065";
        String commentedBy = "priya";
        String commentText = "Awesome Question";
        Date commentedOn = new Date();
        comment = new Comment(questionId, commentedBy, commentText, commentedOn);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testCreate() throws Exception {
        commentService.create(comment);
    }

    @Test
    public void testRead() throws Exception {
        List<Comment> comments = commentService.read("51fac7c130046346821f4065");
        System.out.println(comments);
    }

    @Test
    public void testUpdate() throws Exception {
        String id = "51fad61e3004ae6a6d024add";
        String questionId = "51fac7c130046346821f4065";
        String commentedBy = "priya";
        String commentText = "Hello";
        Date commentedOn = new Date();
        commentService.update(new Comment(id, questionId, commentedBy, commentText, commentedOn));
    }

    @Test
    public void testDelete() throws Exception {
        String id = "51fad61e3004ae6a6d024add";
        commentService.delete(id);
    }
}
