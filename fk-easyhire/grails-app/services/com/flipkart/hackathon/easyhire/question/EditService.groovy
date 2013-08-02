package com.flipkart.hackathon.easyhire.question

import com.flipkart.hackathon.easyhire.domain.Question
import com.flipkart.hackathon.easyhire.domain.QuestionDifficultyLevel
import com.flipkart.hackathon.easyhire.service.mongoImpl.QuestionServiceImpl

class EditService {

    def static questionService = new QuestionServiceImpl();

    def static editQuestion(questionId, title, content, hint, answer, tags, difficulty, votes) {
        String[] tagArr = Arrays.asList(tags.split(","))
        List<String> tagList = new ArrayList<String>()

        for(String string : tagArr) {
            tagList.add(string.trim())
        }

        Question question = new Question(questionId, title, content, new Date(), "rishabh", hint, answer, tagList, QuestionDifficultyLevel.valueOf(difficulty), Integer.parseInt(votes))
        println(question)
        questionService.update(question)
        return question
    }
}
