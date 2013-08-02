<%@ page import="com.flipkart.hackathon.easyhire.domain.QuestionDifficultyLevel" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Add Questions</title>
        <link rel="stylesheet" href="${resource(dir: 'css', file: 'template.css')}" type="text/css">
	</head>
	<body>
        <%if("$result" == "null") {%>
        <div>
            <g:form controller="add" action="add">
                <label for="title">Title:</label><br/>
                <g:textArea name="title" rows="5" cols="100"></g:textArea><br/><br/>
                <label for="content">Question:</label><br/>
                <g:textArea name="content" rows="5" cols="100"></g:textArea><br/><br/>
                <label for="hint">Hint:</label><br/>
                <g:textArea name="hint" rows="5" cols="100"></g:textArea><br/><br/>
                <label for="answer">Answer:</label><br/>
                <g:textArea name="answer" rows="5" cols="100"></g:textArea><br/><br/>
                <label for="tags">Tags:</label><br/>
                <g:textArea name="tags" rows="1" cols="100"></g:textArea><br/><br/>
                <label for="difficulty">Difficulty:</label><br/>
                <g:select name="difficulty" from="${QuestionDifficultyLevel.values()}" keys="${QuestionDifficultyLevel.values()*.name()}"></g:select><br/><br/>
                <g:submitButton name="submit"></g:submitButton>
            </g:form>
        </div>
        <%} else if("$result" =="submitted") {%>
            <div align="center">Yay!! Submitted successfully</div>
        <%} else {%>
            <div align="center">Oops!! Something is wrong</div>
        <%}%>
	</body>
</html>
