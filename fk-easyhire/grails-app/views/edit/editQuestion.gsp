<%--
  Created by IntelliJ IDEA.
  User: sunilkumar
  Date: 02/08/13
  Time: 10:36 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page import="com.flipkart.hackathon.easyhire.domain.QuestionDifficultyLevel" contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title>Edit</title>
</head>
<body>
<g:form controller="edit" action="editQuestion" params="[votes:question.getNumberOfVotes(), questionId: question.getId()]">
    <label for="title">Title:</label><br/>
    <g:textArea name="title" rows="5" cols="100" value="${question.getTitle()}"></g:textArea><br/><br/>
    <label for="content">Question:</label><br/>
    <g:textArea name="content" rows="5" cols="100" value="${question.getText()}"></g:textArea><br/><br/>
    <label for="hint">Hint:</label><br/>
    <g:textArea name="hint" rows="5" cols="100" value="${question.getHint()}"></g:textArea><br/><br/>
    <label for="answer">Answer:</label><br/>
    <g:textArea name="answer" rows="5" cols="100" value="${question.getAnswer()}"></g:textArea><br/><br/>
    <label for="tags">Tags:</label><br/>
    <%  String tagString = " "
        for(String str: question.getTags()) {
            tagString  = tagString + str + " "
        }
        tagString = tagString.trim()
        tagString = tagString.replace(" ", ",")
    %>
    <g:textArea name="tags" rows="1" cols="100" value="${tagString}"></g:textArea><br/><br/>
    <label for="difficulty">Difficulty:</label><br/>
    <g:select name="difficulty" from="${QuestionDifficultyLevel.values()}" keys="${QuestionDifficultyLevel.values()*.name()}" value="${question.getDifficultyLevel()}"></g:select><br/><br/>
    <g:submitButton name="submit"></g:submitButton>
</g:form>
</body>
</html>