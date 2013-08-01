package com.flipkart.hackathon.easyhire.domain;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * String: rishabh.goyal
 * Date: 01/08/13
 * Time: 10:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class Question {
    private String id;
    private String title;
    private String text;
    private Date createdOn;
    private String creatorId;
    private String hint;
    private String answer;
    private List<String> tags;
    private QuestionDifficultyLevel difficultyLevel;
    private int numberOfVotes;

    public Question(String id, String title, String text, Date createdOn, String creatorId, String hint, String answer, List<String> tags, QuestionDifficultyLevel difficultyLevel, int numberOfVotes) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.createdOn = createdOn;
        this.creatorId = creatorId;
        this.hint = hint;
        this.answer = answer;
        this.tags = tags;
        this.difficultyLevel = difficultyLevel;
        this.numberOfVotes = numberOfVotes;
    }

    public Question(String title, String text, Date createdOn, String creatorId, String hint, String answer, List<String> tags, QuestionDifficultyLevel difficultyLevel, int numberOfVotes) {
        this.title = title;
        this.text = text;
        this.createdOn = createdOn;
        this.creatorId = creatorId;
        this.hint = hint;
        this.answer = answer;
        this.tags = tags;
        this.difficultyLevel = difficultyLevel;
        this.numberOfVotes = numberOfVotes;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public String getHint() {
        return hint;
    }

    public String getAnswer() {
        return answer;
    }

    public List<String> getTags() {
        return tags;
    }

    public QuestionDifficultyLevel getDifficultyLevel() {
        return difficultyLevel;
    }

    public int getNumberOfVotes() {
        return numberOfVotes;
    }
}
