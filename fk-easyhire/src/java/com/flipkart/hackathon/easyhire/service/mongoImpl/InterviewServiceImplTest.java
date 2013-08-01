package com.flipkart.hackathon.easyhire.service.mongoImpl;

import com.flipkart.hackathon.easyhire.domain.CandidateResponse;
import com.flipkart.hackathon.easyhire.domain.Interview;
import com.flipkart.hackathon.easyhire.domain.InterviewRound;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: rishabh.goyal
 * Date: 02/08/13
 * Time: 3:53 AM
 * To change this template use File | Settings | File Templates.
 */
public class InterviewServiceImplTest {

    InterviewServiceImpl interviewService;
    Interview interview;

    @Before
    public void setUp() throws Exception {
        interviewService = new InterviewServiceImpl();
        String candidateId = "rishabh";
        List<InterviewRound> interviewRounds = new ArrayList<InterviewRound>();
        interview = new Interview(candidateId, interviewRounds);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testCreate() throws Exception {
        interviewService.create(interview);
    }

    @Test
    public void testRead() throws Exception {
        Interview dbInterview = interviewService.read("51fae14c30044b6b3056c9bc");
        System.out.println(dbInterview.getInterviewRounds());
    }

    @Test
    public void testUpdate() throws Exception {
        InterviewRound round;
        String interviewer = "rishabh";
        Date interviewedOn = new Date();
        Map<String, String> responses = new HashMap<String, String>();
        responses.put("51fac7c130046346821f4065", CandidateResponse.CORRECT.name());
        round = new InterviewRound(interviewer, interviewedOn, responses);
        Interview interviewTest = new Interview("51fae14c30044b6b3056c9bc", interview.getCandidateId(), interview.getInterviewRounds());
        interviewTest.addInterviewRound(round);
        interviewService.update(interviewTest);
    }

    @Test
    public void testDelete() throws Exception {
        interviewService.delete(null);
    }
}
