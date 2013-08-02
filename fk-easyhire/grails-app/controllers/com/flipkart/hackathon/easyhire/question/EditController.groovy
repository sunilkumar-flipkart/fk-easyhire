package com.flipkart.hackathon.easyhire.question

import com.flipkart.hackathon.easyhire.domain.Question
import org.apache.commons.lang.StringUtils

class EditController {

    def editQuestion() {
        Question question;

        if(StringUtils.isNotEmpty(params.submit)) {
            question = EditService.editQuestion(params.questionId, params.title, params.content, params.hint, params.answer, params.tags, params.difficulty, params.votes)
            redirect(uri: '/show/showQuestion?questionId='+params.questionId)
        } else {
            question = ShowService.getQuestion(params.questionId)
        }

        return [question: question]
    }
}
