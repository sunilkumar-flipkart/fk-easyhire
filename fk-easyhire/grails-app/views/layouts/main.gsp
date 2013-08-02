<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<title><g:layoutTitle default="EasyHire"/></title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="shortcut icon" href="${resource(dir: 'images', file: 'favicon.ico')}" type="image/x-icon">
		%{--<link rel="stylesheet" href="${resource(dir: 'css', file: 'main.css')}" type="text/css">--}%
		%{--<link rel="stylesheet" href="${resource(dir: 'css', file: 'mobile.css')}" type="text/css">--}%
    <link href="${resource(dir: 'css', file: 'bootstrap.css')}" rel="stylesheet" media="screen">
    <link href="${resource(dir: 'css', file: 'bootstrap-responsive.css')}" rel="stylesheet" media="screen">
    <style type="text/css">
    body {
        padding-top: 60px;
        padding-bottom: 40px;
    }

    .container-narrow {
        margin: 0 auto;
        max-width: 700px;
    }
    .container-narrow > hr {
        margin: 30px 0;
    }
    </style>
    <g:layoutHead/>
		<r:layoutResources />
	</head>

	<body>
    <div class="navbar navbar-inverse navbar-fixed-top">
        <div class="navbar-inner">
            <div class="container">
                <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="brand" href="#">Easy Hire</a>
                <div class="nav-collapse collapse">
                    <ul class="nav">
                        <li class="active"><a href="#">Home</a></li>
                        <li  class="active"><a href="#about">About</a></li>
                        <div class="dropdown">
                            <a href="/fk-easyhire/" class="dropdown-toggle" data-toggle="dropdown"  class="active">Questions <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li  class="active"><a href="#">Add</a></li>
                                <li  class="active"><a href="#">View</a></li>
                            </ul>
                        </div>
                    </ul>
                    <form class="navbar-form pull-right">
                        <input class="span2" type="text" placeholder="LDAP">
                        <input class="span2" type="password" placeholder="Password">
                        <button type="submit" class="btn">Sign in</button>
                    </form>
                </div><!--/.nav-collapse -->
            </div>
        </div>
    </div>

        <div class="container-narrow">
            <g:layoutBody/>
        </div>
		<div id="spinner" class="spinner" style="display:none;"><g:message code="spinner.alt" default="Loading&hellip;"/></div>
		<g:javascript library="application"/>
		<r:layoutResources />
	</body>
</html>
