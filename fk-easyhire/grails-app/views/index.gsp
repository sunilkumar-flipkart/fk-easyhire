<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Welcome to EasyHire</title>
        <link rel="stylesheet" href="${resource(dir: 'css', file: 'template.css')}" type="text/css">
	</head>
	<body>
		<div id="page-body" role="main">
			<h1>Options</h1>
			<ul>
				<li><g:link controller="add" action="add">Add Question</g:link></li>
                <li><g:link controller="show" action="show">Show Questions</g:link></li>
            </ul>
		</div>
	</body>
</html>
