package com.flipkart.hackathon.easyhire.question

import com.flipkart.hackathon.easyhire.domain.Question
import com.flipkart.hackathon.easyhire.domain.QuestionDifficultyLevel
import com.flipkart.hackathon.easyhire.service.mongoImpl.QuestionServiceImpl

class AddService {

    def static service = new QuestionServiceImpl()

    def static addQuestionToDatabase(title, content, hint, answer, tags, difficulty) {
        String[] tagArr = Arrays.asList(tags.split(","))
        List<String> tagList = new ArrayList<String>()

        for(String string : tagArr) {
            tagList.add(string.trim())
        }
        Question question = new Question(title, content, new Date(), "rishabh", hint, answer, tagList, QuestionDifficultyLevel.valueOf(difficulty), 0)
        service.create(question)
        return true;
    }
}
