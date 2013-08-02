<%@ page import="com.flipkart.hackathon.easyhire.domain.VoteOption; com.flipkart.hackathon.easyhire.domain.Comment; com.flipkart.hackathon.easyhire.domain.Vote; com.flipkart.hackathon.easyhire.domain.Question" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <g:javascript library="jquery" />
</head>
<body>
<div> <h2><%println(question.title)%> </h2></div>
<div>

    <br/>
    <table class="table table-bordered table-striped row row-fluid">
        <tr> <td><%println(question.text)%> <br/>
            <g:link controller="edit" action="editQuestion" params="[questionId: question.getId()]">Edit</g:link>
        </td></tr>
    </table>

    <img src="${resource(dir: 'images', file: 'thumbs-up.jpg')}" width="40" height="40" onclick= "${remoteFunction(controller: 'show', action: 'vote', update: 'votingDone', params: [questionId: question.getId(), vote: VoteOption.UP.toString()])}" >
    <%println("Votes: " + question.numberOfVotes)%>
    <img src="${resource(dir: 'images', file: 'thumbs-down.jpg')}" width="40" height="40" onclick= "${remoteFunction(controller: 'show', action: 'vote', update: 'votingDone', params: [questionId: question.getId(), vote: VoteOption.DOWN.toString()])}">
    <div id="votingDone"></div>


    <table class="table table-bordered table-striped row row-fluid">
        <thead>
            <th>Comments</th>
        </thead>
        <tbody>
        <% for(Comment comment: comments) { %>
        <tr>
            <td> <span class="bar"> <b> ${comment?.getCommentedBy()} </b> &nbsp; ${comment.getComment()} </span> <br/> <div class="alert-info">  on ${comment?.getCommentedOn()} </div></td>
        </tr>
        <%}%>
        <tr>
            <td>
                <g:formRemote name="comment" update="updateMe" url="[controller: 'show', action:'addComment', params: [questionId: question.getId()]]" onComplete="document.location.reload()">
                    <g:textArea name="comment" rows="5" cols="100" style="width: 500pt" placeholder="Write your comment.."></g:textArea>
                    <br/>
                    <g:submitButton name="submit" value="submit"></g:submitButton>
                </g:formRemote>
                <div id="updateMe"></div>
            </td>
        </tr>
        </tbody>
    </table>


</div>
</body>
</html>
