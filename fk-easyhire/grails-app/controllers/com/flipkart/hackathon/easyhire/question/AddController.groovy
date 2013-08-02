package com.flipkart.hackathon.easyhire.question

import org.apache.commons.lang.StringUtils

class AddController {

    def add() {
        if(StringUtils.isEmpty(params.content)) {
            return [result:"null"]
        } else if(params.content){
            def resp = AddService.addQuestionToDatabase(params.title, params.content, params.hint, params.answer, params.tags, params.difficulty)
            if(resp) {
                return [result:"submitted"]
            } else {
                return [result:"error"]
            }
        }
    }
}
