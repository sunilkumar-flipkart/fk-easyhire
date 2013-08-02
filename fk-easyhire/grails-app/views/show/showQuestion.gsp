<%@ page import="com.flipkart.hackathon.easyhire.domain.VoteOption; com.flipkart.hackathon.easyhire.domain.Comment; com.flipkart.hackathon.easyhire.domain.Vote; com.flipkart.hackathon.easyhire.domain.Question" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title><%println(question.title)%></title>
    <g:javascript library="jquery" />
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'template.css')}" type="text/css">
</head>
<body>
<div>
    <h1><%println(question.title)%></h1>
    <br/>
    <br/>
    <%println(question.text)%>
     <br/>
    <img src="${resource(dir: 'images', file: 'up-arrow.png')}" width="40" height="40" onclick= "${remoteFunction(controller: 'show', action: 'vote', update: 'votingDone', params: [questionId: question.getId(), vote: VoteOption.UP.toString()])}" >
    <%println("Votes: " + question.numberOfVotes)%>
    <img src="${resource(dir: 'images', file: 'down-arrow.png')}" width="40" height="40" onclick= "${remoteFunction(controller: 'show', action: 'vote', update: 'votingDone', params: [questionId: question.getId(), vote: VoteOption.DOWN.toString()])}">
    <div id="votingDone"></div>
    <table>
        <tbody>
        <% for(Comment comment: comments) { %>
        <tr>
            <td> ${comment.getComment()} <br/> ${comment?.getCommentedBy()}  on ${comment?.getCommentedOn()} </td>
        </tr>
        <%}%>
        </tbody>
    </table>

    <g:formRemote name="comment" update="updateMe" url="[controller: 'show', action:'addComment', params: [questionId: question.getId()]]" onComplete="document.location.reload()">
        <g:textArea name="comment" rows="5" cols="100"></g:textArea>
        <br/>
        <g:submitButton name="submit"></g:submitButton>
    </g:formRemote>
    <div id="updateMe"></div>
</div>
</body>
</html>
