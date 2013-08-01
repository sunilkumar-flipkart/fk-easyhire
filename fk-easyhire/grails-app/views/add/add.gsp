<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Add Questions</title>
        <link rel="stylesheet" href="${resource(dir: 'css', file: 'template.css')}" type="text/css">
	</head>
	<body>
        <%if("$result" == "null") {%>
        <div align="center">
            <g:form controller="add" action="add">
                <label for="name">Name:</label>
                <g:textField name="name" maxlength="50"></g:textField>
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
