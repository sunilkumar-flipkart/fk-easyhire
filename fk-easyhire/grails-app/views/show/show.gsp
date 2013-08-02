<%@ page import="com.flipkart.hackathon.easyhire.domain.Question" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
	</head>
	<body>

    <div>
        <table class="table table-bordered table-striped row row-fluid">

            <thead>
            <tr>
                <th>S.No</th>
                <th>Questions</th>
            </tr>
            </thead>
            <tbody>
                <%i=1%>
                <% for(Question question: questions) {%>
                    <tr>
                    <td >${i}</td>
                    <td><h5><g:link controller="show" action="showQuestion" params="[questionId: question.getId()]"> ${question.getTitle()}<br/></g:link></h5>
                    ${question.getText()}</td>
                    </tr>
                    <%i++%>
                <%}%>
            </tbody>
        </table>
    </div>
    </body>
</html>
