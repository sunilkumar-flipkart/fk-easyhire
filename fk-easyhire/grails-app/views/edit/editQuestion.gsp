<%@ page import="com.flipkart.hackathon.easyhire.domain.QuestionDifficultyLevel" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Edit Question</title>
</head>
<body>
<g:form controller="edit" action="editQuestion" params="[votes:question.getNumberOfVotes(), questionId: question.getId()]">
    <div class="page-header">
        <h1>Edit Question</h1>
    </div>

    <table class="table-condensed row row-fluid">
        <tr>
            <td><label for="title"><h5>Title</h5></label><br/></td>
            <td><g:textArea name="title" rows="5" cols="100" value="${question.getTitle()}"></g:textArea><br/><br/></td>

        </tr>
        <tr>
            <td><label for="content"><h5>Question</h5></label><br/></td>
            <td><g:textArea name="content" rows="5" cols="100" value="${question.getText()}"></g:textArea><br/><br/></td>
        </tr>
        <tr>
            <td><label for="hint"><h5>Hint</h5></label><br/></td>
            <td><g:textArea name="hint" rows="5" cols="100" value="${question.getHint()}"></g:textArea><br/><br/></td>
        </tr>
        <tr>
            <td><label for="answer"><h5>Answer</h5></label><br/></td>
            <td><g:textArea name="answer" rows="5" cols="100" value="${question.getAnswer()}"></g:textArea><br/><br/></td>
        </tr>
        <tr>
            <td><label for="tags"><h5>Tags</h5></label><br/></td>
            <td><g:textArea name="tags" rows="1" cols="100"></g:textArea><br/><br/></td>
        </tr>
        <tr>
            <td><label for="difficulty"><h5>Difficulty Level</h5></label><br/></td>
            <td><g:select name="difficulty" from="${QuestionDifficultyLevel.values()}" keys="${QuestionDifficultyLevel.values()*.name()}" value="${question.getDifficultyLevel()}" ></g:select><br/><br/></td>
        </tr>
        <tr>
            <td colspan="2"><g:submitButton name="submit" value="submit"></g:submitButton></td>
        </tr>
        </table>
</g:form>
</body>
</html>

