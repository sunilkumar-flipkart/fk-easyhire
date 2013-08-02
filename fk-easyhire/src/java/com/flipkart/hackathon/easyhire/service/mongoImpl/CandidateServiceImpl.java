package com.flipkart.hackathon.easyhire.service.mongoImpl;

import com.flipkart.hackathon.easyhire.service.DataStore;
import com.flipkart.hackathon.easyhire.domain.Candidate;
import com.flipkart.hackathon.easyhire.service.CandidateService;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.bson.types.ObjectId;

import java.net.UnknownHostException;

/**
 * Created with IntelliJ IDEA.
 * User: rishabh.goyal
 * Date: 02/08/13
 * Time: 5:25 AM
 * To change this template use File | Settings | File Templates.
 */
public class CandidateServiceImpl implements CandidateService{
    DataStore store;

    public CandidateServiceImpl() throws UnknownHostException {
        store = new DataStore("localhost");
    }

    @Override
    public void create(Candidate candidate) {
        String id = new ObjectId().toString();
        DBObject object = new BasicDBObject();
        object.put("_id", id);
        object.put("id", id);
        object.put("name", candidate.getName());
        object.put("email", candidate.getEmail());
        object.put("resume", candidate.getResume());
        store.create("fk-easyhire", "candidates", object);
    }

    @Override
    public Candidate read(String candidateId) {
        DBObject object = store.read("fk-easyhire", "candidates", candidateId);
        String name = (String) object.get("name");
        String email = (String) object.get("email");
        Object resume = object.get("resume");
        return new Candidate(candidateId, name, email, resume);
    }

    @Override
    public void update(Candidate candidate) {
        DBObject object = new BasicDBObject();
        object.put("_id", candidate.getId());
        object.put("id", candidate.getId());
        object.put("name", candidate.getName());
        object.put("email", candidate.getEmail());
        object.put("resume", candidate.getResume());
        store.update("fk-easyhire", "candidates", object);
    }

    @Override
    public void delete(String candidateId) {
        store.delete("fk-easyhire", "candidates", candidateId);
    }
}
