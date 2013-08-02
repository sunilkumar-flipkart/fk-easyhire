package com.flipkart.hackathon.easyhire.domain;

/**
 * Created with IntelliJ IDEA.
 * String: rishabh.goyal
 * Date: 01/08/13
 * Time: 11:21 PM
 * To change this template use File | Settings | File Templates.
 */
public enum QuestionDifficultyLevel {
    VERY_EASY("Very Easy"),
    EASY("Easy"),
    MEDIUM("Medium"),
    HARD("Hard"),
    VERY_HARD("Very Hard");

    final String value;

    private QuestionDifficultyLevel(String value) {
        this.value = value;
    }

    String getKey() {
        return name();
    }

    @Override
    public String toString() {
        return value;
    }
}
