package com.flipkart.hackathon.easyhire.domain;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * String: rishabh.goyal
 * Date: 01/08/13
 * Time: 11:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class Vote {
    String id;
    String questionId;
    String voterId;
    VoteOption vote;
    Date votedOn;

    public Vote(String questionId, String voterId, VoteOption vote, Date votedOn) {
        this.questionId = questionId;
        this.voterId = voterId;
        this.vote = vote;
        this.votedOn = votedOn;
    }

    public Vote(String id, String questionId, String voterId, VoteOption vote, Date votedOn) {
        this.id = id;
        this.questionId = questionId;
        this.voterId = voterId;
        this.vote = vote;
        this.votedOn = votedOn;
    }

    public String getId() {
        return id;
    }

    public String getQuestionId() {
        return questionId;
    }

    public String getVoterId() {
        return voterId;
    }

    public VoteOption getVote() {
        return vote;
    }

    public Date getVotedOn() {
        return votedOn;
    }

    @Override
    public String toString() {
        return "Vote{" +
                "id='" + id + '\'' +
                ", questionId='" + questionId + '\'' +
                ", voterId='" + voterId + '\'' +
                ", vote=" + vote +
                ", votedOn=" + votedOn +
                '}';
    }
}
