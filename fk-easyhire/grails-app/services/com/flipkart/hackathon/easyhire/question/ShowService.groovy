package com.flipkart.hackathon.easyhire.question

import com.flipkart.hackathon.easyhire.domain.Comment
import com.flipkart.hackathon.easyhire.domain.Vote
import com.flipkart.hackathon.easyhire.domain.VoteOption
import com.flipkart.hackathon.easyhire.service.mongoImpl.CommentServiceImpl
import com.flipkart.hackathon.easyhire.service.mongoImpl.QuestionServiceImpl
import com.flipkart.hackathon.easyhire.service.mongoImpl.VotingServiceImpl

class ShowService {

    def static questionService = new QuestionServiceImpl()
    def static commentService = new CommentServiceImpl()
    def static voteService = new VotingServiceImpl()

    def static getQuestions() {
        return questionService.readAll()
    }

    def static getQuestion(String questionId) {
        return questionService.read(questionId)
    }

    def static getComments(questionId) {
        return commentService.read(questionId)
    }

    def static writeComment(questionId, comment) {
        return commentService.create(new Comment(questionId, "rishab", comment, new Date()))
    }

    def static getVotes(questionId) {
        return voteService.read(questionId)
    }

    def static writeVote(questionId, voteOption) {
        return voteService.create(new Vote(questionId, "rishabh", VoteOption.valueOf(voteOption), new Date()))
    }
}
