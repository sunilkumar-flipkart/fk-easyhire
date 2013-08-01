package com.flipkart.hackathon.easyhire.service;

import com.flipkart.hackathon.easyhire.domain.Vote;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: rishabh.goyal
 * Date: 02/08/13
 * Time: 12:23 AM
 * To change this template use File | Settings | File Templates.
 */
public interface VotingService {
    public void create(Vote vote);
    public List<Vote> read(String questionId);
    public void update(Vote vote);
    public void delete(String voteId);
}
