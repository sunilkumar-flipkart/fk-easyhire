<%@ page import="com.flipkart.hackathon.easyhire.domain.QuestionDifficultyLevel" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
        <title>Add Question</title>
	</head>
	<body>
    <div class="page-header">
        <h1>Add Question</h1>
    </div>
        <%if("$result" == "null") {%>
        <div>
            <table class="table-condensed row row-fluid">
                <g:form controller="add" action="add">
                <tr>
                    <td><label for="title"><h5>Title</h5></label><br/></td>
                    <td><g:textField name="title" rows="5" cols="100" class="input-large" ></g:textField><br/><br/></td>

                </tr>
                <tr>
                    <td><label for="content"><h5>Question</h5></label><br/></td>
                    <td><g:textArea name="content" rows="5" cols="100"  ></g:textArea><br/><br/></td>
                </tr>
                <tr>
                    <td><label for="hint"><h5>Hint</h5></label><br/></td>
                    <td><g:textField name="hint" rows="5" cols="100"></g:textField><br/><br/></td>
                </tr>
                <tr>
                    <td><label for="answer"><h5>Answer</h5></label><br/></td>
                    <td><g:textArea name="answer" rows="5" cols="100"></g:textArea><br/><br/></td>
                </tr>
                <tr>
                    <td><label for="tags"><h5>Tags</h5></label><br/></td>
                    <td><g:textArea name="tags" rows="1" cols="100"></g:textArea><br/><br/></td>
                </tr>
                <tr>
                    <td><label for="difficulty"><h5>Difficulty Level</h5></label><br/></td>
                    <td><g:select name="difficulty" from="${QuestionDifficultyLevel.values()}" keys="${QuestionDifficultyLevel.values()*.name()}"></g:select><br/><br/></td>
                </tr>
                <tr>
                    <td colspan="2"><g:submitButton name="submit" value="submit" class="btn btn-primary"></g:submitButton></td>
                </tr>
            </table>


            </g:form>
        </div>
        <%} else if("$result" =="submitted") {%>
            <div align="center">Yay!! Submitted successfully</div>
        <%} else {%>
            <div align="center">Oops!! Something is wrong</div>
        <%}%>
	</body>
</html>
