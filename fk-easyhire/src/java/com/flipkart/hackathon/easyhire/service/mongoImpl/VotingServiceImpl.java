package com.flipkart.hackathon.easyhire.service.mongoImpl;

import com.flipkart.hackathon.easyhire.domain.Vote;
import com.flipkart.hackathon.easyhire.service.VotingService;
import org.bson.types.ObjectId;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: rishabh.goyal
 * Date: 02/08/13
 * Time: 1:11 AM
 * To change this template use File | Settings | File Templates.
 */
public class VotingServiceImpl implements VotingService {
    @Override
    public void create(Vote vote) {
        String id = new ObjectId().toString();
    }

    @Override
    public List<Vote> read(String questionId) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void update(Vote vote) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void delete(String voteId) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
