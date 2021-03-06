package com.flipkart.hackathon.easyhire.service.mongoImpl;

import com.flipkart.hackathon.easyhire.FilterUtils;
import com.flipkart.hackathon.easyhire.domain.Filter;
import com.flipkart.hackathon.easyhire.domain.VoteOption;
import com.flipkart.hackathon.easyhire.service.DataStore;
import com.flipkart.hackathon.easyhire.domain.Question;
import com.flipkart.hackathon.easyhire.domain.QuestionDifficultyLevel;
import com.flipkart.hackathon.easyhire.service.QuestionService;
import com.mongodb.*;
import org.bson.types.ObjectId;
import org.junit.Test;

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
public class QuestionServiceImpl implements QuestionService {

    DataStore store;

    public QuestionServiceImpl() throws UnknownHostException {
        store = new DataStore("localhost");
    }

    @Override
    public void create(Question question) {
        ObjectId questionId = new ObjectId();
        DBObject object = new BasicDBObject();
        object.put("_id", questionId.toString());
        object.put("id", questionId.toString());
        object.put("title", question.getTitle());
        object.put("text", question.getText());
        object.put("createdOn", question.getCreatedOn());
        object.put("creatorId", question.getCreatorId());
        object.put("hint", question.getHint());
        object.put("answer", question.getAnswer());
        object.put("tags", question.getTags());
        object.put("difficultyLevel", question.getDifficultyLevel().name());
        object.put("numberOfVotes", 0);
        store.create("fk-easyhire", "questions", object );
    }

    @Override
    public Question read(String questionId) {
        DBObject object = store.read("fk-easyhire", "questions", questionId);
        String title = (String) object.get("title");
        String text = (String) object.get("text");
        Date createdOn = (Date) object.get("createdOn");
        String creatorId = (String) object.get("creatorId");
        String hint = (String) object.get("hint");
        String answer = (String) object.get("answer");
        List<String> tags = (List<String>) object.get("tags");
        QuestionDifficultyLevel difficultyLevel = QuestionDifficultyLevel.valueOf((String) object.get("difficultyLevel"));

        int count = getQuestionCount(questionId);
//        int numVotes = Integer.parseInt(object.get("numberOfVotes").toString());
        int numVotes = count;
        return new Question(questionId, title, text, createdOn, creatorId, hint, answer, tags, difficultyLevel, numVotes);
    }

    public int getQuestionCount(String questionId){
        MongoClient client = store.mongoClient;
        DBObject queryObject = new QueryBuilder().put("questionId").is(questionId).get();
        DBCursor cursor = client.getDB("fk-easyhire").getCollection("votes").find(queryObject);
        int upVotes = 0;
        int downVotes = 0;

        while (cursor.hasNext()){
            DBObject object = cursor.next();
            String voteOption = (String) object.get("vote");

            if ( voteOption.equalsIgnoreCase(VoteOption.DOWN.name()) ){
                downVotes++;
            }
            if( voteOption.equalsIgnoreCase(VoteOption.UP.name())){
                upVotes++;
            }
        }
        return upVotes - downVotes;
    }

    @Override
    public List<Question> readAll(){
        List<Question> questions = new ArrayList<Question>();
        List<DBObject> objects = store.readAll("fk-easyhire", "questions", new BasicDBObject());
        for ( DBObject object : objects ){
            String id = (String) object.get("_id");
            String title = (String) object.get("title");
            String text = (String) object.get("text");
            Date createdOn = (Date) object.get("createdOn");
            String creatorId = (String) object.get("creatorId");
            String hint = (String) object.get("hint");
            String answer = (String) object.get("answer");
            List<String> tags = (List<String>) object.get("tags");
            QuestionDifficultyLevel difficultyLevel = QuestionDifficultyLevel.valueOf((String) object.get("difficultyLevel"));
            int numVotes = Integer.parseInt(object.get("numberOfVotes").toString());
            questions.add(new Question(id, title, text, createdOn, creatorId, hint, answer, tags, difficultyLevel, numVotes));
        }
        return questions;
    }

    public List<Question> readAll(ArrayList<String> properties, ArrayList<String> operators, ArrayList<String> values) {
        List<Filter> filters = FilterUtils.createFilterFromQueryParams(properties, operators, values);
        DBObject queryObject = FilterUtils.getQueryObject(filters);
        List<Question> questions = new ArrayList<Question>();
        List<DBObject> objects = store.readAll("fk-easyhire", "questions", queryObject);
        for ( DBObject object : objects ){
            String id = (String) object.get("_id");
            String title = (String) object.get("title");
            String text = (String) object.get("text");
            Date createdOn = (Date) object.get("createdOn");
            String creatorId = (String) object.get("creatorId");
            String hint = (String) object.get("hint");
            String answer = (String) object.get("answer");
            List<String> tags = (List<String>) object.get("tags");
            QuestionDifficultyLevel difficultyLevel = QuestionDifficultyLevel.valueOf((String) object.get("difficultyLevel"));
            int numVotes = Integer.parseInt(object.get("numberOfVotes").toString());
            questions.add(new Question(id, title, text, createdOn, creatorId, hint, answer, tags, difficultyLevel, numVotes));
        }
        return questions;
    }

    @Override
    public void update(Question question) {
        DBObject object = new BasicDBObject();
        object.put("_id", question.getId());
        object.put("id", question.getId());
        object.put("title", question.getTitle());
        object.put("text", question.getText());
        object.put("createdOn", question.getCreatedOn());
        object.put("creatorId", question.getCreatorId());
        object.put("hint", question.getHint());
        object.put("answer", question.getAnswer());
        object.put("tags", question.getTags());
        object.put("difficultyLevel", question.getDifficultyLevel().name());
        object.put("numberOfVotes", 0);
        store.update("fk-easyhire", "questions", object);
    }

    @Override
    public void delete(String questionId) {
        store.delete("fk-easyhire", "questions", questionId);
    }
}
