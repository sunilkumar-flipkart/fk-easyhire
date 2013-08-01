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
public class Round {
    Interviewer interviewer;
    Date interviewRoundDate;
    Map<String, CandidateResponse> questionResponses;
}
