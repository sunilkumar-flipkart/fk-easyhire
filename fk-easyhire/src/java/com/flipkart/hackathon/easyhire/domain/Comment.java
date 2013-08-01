package com.flipkart.hackathon.easyhire.domain;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * String: rishabh.goyal
 * Date: 01/08/13
 * Time: 11:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class Comment {
    private String id;
    private String questionId;
    private String commentedBy;
    private String comment;
    private Date commentedOn;

    public Comment(String questionId, String commentedBy, String comment, Date commentedOn) {
        this.questionId = questionId;
        this.commentedBy = commentedBy;
        this.comment = comment;
        this.commentedOn = commentedOn;
    }

    public Comment(String id, String questionId, String commentedBy, String comment, Date commentedOn) {
        this.id = id;
        this.questionId = questionId;
        this.commentedBy = commentedBy;
        this.comment = comment;
        this.commentedOn = commentedOn;
    }

    public String getId() {
        return id;
    }

    public String getQuestionId() {
        return questionId;
    }

    public String getCommentedBy() {
        return commentedBy;
    }

    public String getComment() {
        return comment;
    }

    public Date getCommentedOn() {
        return commentedOn;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id='" + id + '\'' +
                ", questionId='" + questionId + '\'' +
                ", commentedBy='" + commentedBy + '\'' +
                ", comment='" + comment + '\'' +
                ", commentedOn=" + commentedOn +
                '}';
    }
}
