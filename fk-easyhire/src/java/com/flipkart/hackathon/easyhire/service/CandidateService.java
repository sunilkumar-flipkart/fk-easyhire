package com.flipkart.hackathon.easyhire.service;

import com.flipkart.hackathon.easyhire.domain.Candidate;

/**
 * Created with IntelliJ IDEA.
 * User: rishabh.goyal
 * Date: 02/08/13
 * Time: 5:23 AM
 * To change this template use File | Settings | File Templates.
 */
public interface CandidateService {
    public void create(Candidate candidate);
    public Candidate read(String candidateId);
    public void update(Candidate candidate);
    public void delete(String candidateId);
}
