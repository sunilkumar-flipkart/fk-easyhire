<%@ page import="com.flipkart.hackathon.easyhire.domain.Question" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Show Questions</title>
        <link rel="stylesheet" href="${resource(dir: 'css', file: 'template.css')}" type="text/css">
	</head>
	<body>
    <div>
        <table border="solid">
            <tbody>
                <% for(Question question: questions) {%>
                    <tr>
                        <td><g:link controller="show" action="showQuestion" params="[questionId: question.getId()]"> ${question.getTitle()} - it is Title</g:link></td>
                    </tr>
                    <tr>
                        <td>${question.getText()} - it is Text</td>
                    </tr>
                <%}%>
            </tbody>
        </table>
    </div>
    </body>
</html>
