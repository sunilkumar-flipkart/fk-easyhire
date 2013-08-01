package com.flipkart.hackathon.easyhire.service;

import com.flipkart.hackathon.easyhire.domain.Interview;
import com.flipkart.hackathon.easyhire.domain.Question;

/**
 * Created with IntelliJ IDEA.
 * User: rishabh.goyal
 * Date: 02/08/13
 * Time: 3:41 AM
 * To change this template use File | Settings | File Templates.
 */
public interface InterviewService {
    public void create(Interview interview);
    public Interview read(String interviewId);
    public void update(Interview interview);
    public void delete(String interviewId);
}
