package com.flipkart.hackathon.easyhire.service.mongoImpl;

import com.flipkart.hackathon.easyhire.service.DataStore;
import com.flipkart.hackathon.easyhire.domain.Vote;
import com.flipkart.hackathon.easyhire.domain.VoteOption;
import com.flipkart.hackathon.easyhire.service.VotingService;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.QueryBuilder;
import org.bson.types.ObjectId;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * String: rishabh.goyal
 * Date: 02/08/13
 * Time: 1:11 AM
 * To change this template use File | Settings | File Templates.
 */
public class VotingServiceImpl implements VotingService {

    DataStore store;

    public VotingServiceImpl() throws UnknownHostException {
        store = new DataStore("localhost");
    }

    @Override
    public void create(Vote vote) {
        String id = new ObjectId().toString();
        DBObject object = new BasicDBObject();
        object.put("_id", id);
        object.put("id", id);
        object.put("questionId", vote.getQuestionId());
        object.put("voterId", vote.getVoterId());
        object.put("vote", vote.getVote().name());
        object.put("votedOn", vote.getVotedOn());
        store.create("fk-easyhire", "votes", object);

    }

    @Override
    public List<Vote> read(String questionId) {
        DBObject queryObject = new QueryBuilder().put("questionId").is(questionId).get();
        List<DBObject> objects = store.readAll("fk-easyhire", "votes", queryObject);
        List<Vote> votes = new ArrayList<Vote>();
        for( DBObject object : objects) {
            String id = (String) object.get("_id");
            String voterId = (String) object.get("voterId");
            VoteOption voteOption = VoteOption.valueOf(object.get("vote").toString());
            Date votedOn = (Date) object.get("votedOn");
            votes.add(new Vote(id, questionId, voterId, voteOption, votedOn));
        }
        return votes;
    }

    @Override
    public void update(Vote vote) {
        DBObject object = new BasicDBObject();
        object.put("_id", vote.getId());
        object.put("id", vote.getId());
        object.put("questionId", vote.getQuestionId());
        object.put("voterId", vote.getVoterId());
        object.put("vote", vote.getVote().name());
        object.put("votedOn", vote.getVotedOn());
        store.update("fk-easyhire", "votes", object);
    }

    @Override
    public void delete(String voteId) {
        store.delete("fk-easyhire", "votes", voteId);
    }
}
