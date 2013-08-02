package com.flipkart.hackathon.easyhire.question

import com.flipkart.hackathon.easyhire.FilterUtils
import com.flipkart.hackathon.easyhire.domain.Comment
import com.flipkart.hackathon.easyhire.domain.Question
import com.flipkart.hackathon.easyhire.domain.Vote

class ShowController {

    def show() {
        List<Question> questions = ShowService.getQuestions()
        return [questions:questions]
    }

    def showQuestion() {
        Question question = ShowService.getQuestion(params.questionId)
        List<Vote> votes = ShowService.getVotes(params.questionId)
        List<Comment> comments = ShowService.getComments(params.questionId)

        return [question: question, votes:votes, comments:comments]
    }

    def addComment() {
        ShowService.writeComment(params.questionId, params.comment)
    }

    def vote() {
        ShowService.writeVote(params.questionId, params.vote)
    }

    def search() {
        println(params)
        return [keysToType:FilterUtils.keyToTypeMapping as grails.converters.JSON, typeToOperations:FilterUtils.typeOperationMapping as grails.converters.JSON]
    }

    def displaySearch() {
        List<String> properties = new ArrayList<String>(Arrays.asList(params.attributes))
        List<String> operators = new ArrayList<String>(Arrays.asList(params.operators))
        List<String> values = new ArrayList<String>(Arrays.asList(params.values))

        render(actionUri: "show", controllerName: "show", model: [questions: ShowService.getQuestions(properties, operators, values)])
    }
}
