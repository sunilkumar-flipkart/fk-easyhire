package com.flipkart.hackathon.easyhire.service;

import com.flipkart.hackathon.easyhire.domain.Question;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * String: rishabh.goyal
 * Date: 02/08/13
 * Time: 12:22 AM
 * To change this template use File | Settings | File Templates.
 */
public interface QuestionService {

    public void create(Question question);
    public Question read(String questionId);
    public List<Question> readAll();
    public void update(Question question);
    public void delete(String questionId);

}
