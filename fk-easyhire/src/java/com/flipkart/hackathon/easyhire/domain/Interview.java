package com.flipkart.hackathon.easyhire.domain;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * String: rishabh.goyal
 * Date: 01/08/13
 * Time: 11:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class Interview {
    String id;
    String candidateId;
    List<InterviewRound> interviewRounds;

    public Interview(String candidateId, List<InterviewRound> interviewRounds) {
        this.candidateId = candidateId;
        this.interviewRounds = interviewRounds;
    }

    public Interview(String id, String candidateId, List<InterviewRound> interviewRounds) {
        this.id = id;
        this.candidateId = candidateId;
        this.interviewRounds = interviewRounds;
    }

    public String getId() {
        return id;
    }

    public String getCandidateId() {
        return candidateId;
    }

    public List<InterviewRound> getInterviewRounds() {
        return interviewRounds;
    }


    public void addInterviewRound(InterviewRound interviewRound){
        interviewRounds.add(interviewRound);
    }

    @Override
    public String toString() {
        return "Interview{" +
                "id='" + id + '\'' +
                ", candidateId='" + candidateId + '\'' +
                ", interviewRounds=" + interviewRounds +
                '}';
    }
}