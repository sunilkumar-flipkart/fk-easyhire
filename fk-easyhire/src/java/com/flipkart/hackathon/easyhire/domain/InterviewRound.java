package com.flipkart.hackathon.easyhire.domain;

import java.util.Date;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * String: rishabh.goyal
 * Date: 01/08/13
 * Time: 11:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class InterviewRound {
    String interviewerId;
    Date interviewRoundDate;
    Map<String, String> questionResponses;

    public InterviewRound(String interviewerId, Date interviewRoundDate, Map<String, String> questionResponses) {
        this.interviewerId = interviewerId;
        this.interviewRoundDate = interviewRoundDate;
        this.questionResponses = questionResponses;
    }

    public String getInterviewerId() {
        return interviewerId;
    }

    public Date getInterviewRoundDate() {
        return interviewRoundDate;
    }

    public Map<String, String> getQuestionResponses() {
        return questionResponses;
    }
}
