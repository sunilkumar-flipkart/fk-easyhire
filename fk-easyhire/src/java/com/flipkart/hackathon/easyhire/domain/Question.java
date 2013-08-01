package com.flipkart.hackathon.easyhire.domain;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: rishabh.goyal
 * Date: 01/08/13
 * Time: 10:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class Question {
    String id;
    String text;
    Date createdOn;
    User creator;
    String hint;
    String answer;
    List<String> tags;
    QuestionDifficultyLevel difficultyLevel;
    int numberOfVotes;
}
