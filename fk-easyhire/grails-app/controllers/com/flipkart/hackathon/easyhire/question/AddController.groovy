package com.flipkart.hackathon.easyhire.question

import org.apache.commons.lang.StringUtils

class AddController {

    def add() {
        if(StringUtils.isEmpty(params.name)) {
            return [result:"null"]
        } else if(params.name){
            if(true) {
                return [result:"submitted"]
            } else {
                return [result:"error"]
            }
        }
    }
}
