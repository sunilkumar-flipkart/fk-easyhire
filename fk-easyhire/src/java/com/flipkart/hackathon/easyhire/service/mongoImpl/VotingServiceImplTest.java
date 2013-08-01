package com.flipkart.hackathon.easyhire.service.mongoImpl;

import com.flipkart.hackathon.easyhire.domain.Vote;
import com.flipkart.hackathon.easyhire.domain.VoteOption;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * String: rishabh.goyal
 * Date: 02/08/13
 * Time: 2:35 AM
 * To change this template use File | Settings | File Templates.
 */
public class VotingServiceImplTest {

    VotingServiceImpl votingService;
    Vote vote;

    @Before
    public void setUp() throws Exception {
        votingService = new VotingServiceImpl();
        String questionId = "51fac7c130046346821f4065";
        String voterId = "priya";
        VoteOption voteOption = VoteOption.DOWN;
        Date votedOn = new Date();
        vote = new Vote(questionId, voterId, voteOption, votedOn);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testCreate() throws Exception {
        votingService.create(vote);
    }

    @Test
    public void testRead() throws Exception {
        List<Vote> votes = votingService.read("51fac7c130046346821f4065");
        System.out.println(votes);
    }

    @Test
    public void testUpdate() throws Exception {
        String id = "51faceb83004c9c500ebca06";
        String questionId = "51fac7c130046346821f4065";
        String voterId = "priya";
        VoteOption voteOption = VoteOption.UP;
        Date votedOn = new Date();
        vote = new Vote(id, questionId, voterId, voteOption, votedOn);
        votingService.update(vote);
    }

    @Test
    public void testDelete() throws Exception {
        String id = "51faceb83004c9c500ebca06";
        votingService.delete(id);
    }
}
