package com.flipkart.hackathon.easyhire.service.mongoImpl;

import com.flipkart.hackathon.easyhire.service.DataStore;
import com.flipkart.hackathon.easyhire.domain.CandidateResponse;
import com.flipkart.hackathon.easyhire.domain.Interview;
import com.flipkart.hackathon.easyhire.domain.InterviewRound;
import com.flipkart.hackathon.easyhire.service.InterviewService;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.QueryBuilder;
import org.bson.BasicBSONObject;
import org.bson.types.ObjectId;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: rishabh.goyal
 * Date: 02/08/13
 * Time: 3:43 AM
 * To change this template use File | Settings | File Templates.
 */
public class InterviewServiceImpl implements InterviewService {

    DataStore store;

    public InterviewServiceImpl() throws UnknownHostException {
        store = new DataStore("localhost");
    }

    @Override
    public void create(Interview interview) {
        String id = new ObjectId().toString();
        DBObject object = new BasicDBObject();
        object.put("_id", id);
        object.put("id", id);
        object.put("candidateId", interview.getCandidateId());
        object.put("interviewRounds", interview.getInterviewRounds());
        store.create("fk-easyhire", "interviews", object);
    }

    @Override
    public Interview read(String interviewId) {
        DBObject interviewObject = store.read("fk-easyhire", "interviews", interviewId);
        String candidateId = (String) interviewObject.get("candidateId");
        List<InterviewRound> interviewRounds = (List<InterviewRound>) interviewObject.get("interviewRounds");
        return new Interview(interviewId, candidateId, interviewRounds);
    }

    @Override
    public void update(Interview interview) {
        DBObject object = new BasicDBObject();
        object.put("_id", interview.getId());
        object.put("id", interview.getId());
        object.put("candidateId", interview.getCandidateId());
        List<DBObject> interviewRounds = new ArrayList<DBObject>();
        for ( InterviewRound round : interview.getInterviewRounds() ){
            DBObject tempObject = new BasicDBObject();
            tempObject.put("interviewerId", round.getInterviewerId());
            tempObject.put("interviewRoundDate", round.getInterviewRoundDate());
            tempObject.put("questionResponses", new BasicBSONObject(round.getQuestionResponses()));
            interviewRounds.add(tempObject);
        }
        object.put("interviewRounds", interviewRounds);
        store.update("fk-easyhire", "interviews", object);
    }

    @Override
    public void delete(String interviewId) {
        store.delete("fk-easyhire", "interviews", interviewId);
    }
}
