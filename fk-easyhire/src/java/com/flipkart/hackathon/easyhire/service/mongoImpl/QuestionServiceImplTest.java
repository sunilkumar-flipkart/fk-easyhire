package com.flipkart.hackathon.easyhire.service.mongoImpl;

import com.flipkart.hackathon.easyhire.domain.Question;
import com.flipkart.hackathon.easyhire.domain.QuestionDifficultyLevel;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: rishabh.goyal
 * Date: 02/08/13
 * Time: 1:49 AM
 * To change this template use File | Settings | File Templates.
 */
public class QuestionServiceImplTest {

    QuestionServiceImpl questionService;
    Question question;

    @Before
    public void setUp() throws Exception {
        questionService = new QuestionServiceImpl();
        String title = "Hello First Question";
        String text = "This is demo question";
        Date createdOn = new Date();
        String creatorId = "priya";
        String hint = "Impossible";
        String answer = "0/0";
        List<String> tags = new ArrayList<String>();
        tags.add("C++");
        tags.add("C");
        tags.add("Java");
        QuestionDifficultyLevel difficultyLevel = QuestionDifficultyLevel.EASY;
        int numOfVotes = 0;
        question = new Question(title, text, createdOn, creatorId, hint, answer, tags, difficultyLevel, numOfVotes);
    }

    @After
    public void tearDown() throws Exception {
        question = null;
    }

    @Test
    public void testCreate() throws Exception {
        questionService.create(question);
    }

    @Test
    public void testRead() throws Exception {
        String id = "51fac6dc3004a7334a80028c";
        Question actualQuestion = new Question(id, question.getTitle(), question.getText(), question.getCreatedOn(), question.getCreatorId(), question.getHint(), question.getAnswer(), question.getTags(), question.getDifficultyLevel(), question.getNumberOfVotes());
        Question returnedValue = questionService.read(id);
        System.out.println(returnedValue.getTitle() +  " : " + returnedValue.getTags());
    }

    @Test
    public void testUpdate() throws Exception {
        String id = "51fac6dc3004a7334a80028c";
        Question modifiedQuestion = new Question(id, "QuestionUpdated", question.getText(), question.getCreatedOn(), question.getCreatorId(), question.getHint(), question.getAnswer(), question.getTags(), question.getDifficultyLevel(), question.getNumberOfVotes());
        questionService.update(modifiedQuestion);
    }

    @Test
    public void testDelete() throws Exception {
        String id = "51fac6dc3004a7334a80028c";
        questionService.delete(id);
    }
}
