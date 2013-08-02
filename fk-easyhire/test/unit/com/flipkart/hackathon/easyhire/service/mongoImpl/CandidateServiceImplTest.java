package com.flipkart.hackathon.easyhire.service.mongoImpl;

import com.flipkart.hackathon.easyhire.domain.Candidate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: rishabh.goyal
 * Date: 02/08/13
 * Time: 5:32 AM
 * To change this template use File | Settings | File Templates.
 */
public class CandidateServiceImplTest {

    CandidateServiceImpl candidateService;
    Candidate candidate;

    @Before
    public void setUp() throws Exception {
        candidateService = new CandidateServiceImpl();
        String name = "Rishabh Goyal";
        String email = "rishabh.goyal@flipkart.com";
        Object resume = "";
        candidate = new Candidate(name, email, resume);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testCreate() throws Exception {
        candidateService.create(candidate);
    }

    @Test
    public void testRead() throws Exception {
        Candidate candidateDb = candidateService.read("51faf7843004dcdea67ff3b5");
    }

    @Test
    public void testUpdate() throws Exception {
        String id = "51faf7843004dcdea67ff3b5";
        String name = "Rishabh";
        String email = "rgoyal@flipkart.com";
        Object resume = "";
        candidateService.update(new Candidate(id, name, email, resume));
    }

    @Test
    public void testDelete() throws Exception {
        String id = "51faf7843004dcdea67ff3b5";
        candidateService.delete(id);
    }
}
