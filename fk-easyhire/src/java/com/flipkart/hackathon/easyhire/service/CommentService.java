package com.flipkart.hackathon.easyhire.service;

import com.flipkart.hackathon.easyhire.domain.Comment;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: rishabh.goyal
 * Date: 02/08/13
 * Time: 12:23 AM
 * To change this template use File | Settings | File Templates.
 */
public interface CommentService {
    public void create(Comment comment);
    public List<Comment> read(String questionId);
    public void update(Comment comment);
    public void delete(String commentId);
}
