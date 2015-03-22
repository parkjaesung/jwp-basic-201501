<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@ include file="/include/tags.jspf"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/include/header.jspf"%>
</head>
<body>
    <div id="header">
        <div id="title">
            <h2><a href="/list.next">Java Web Programming 실습</a></h2>
        </div>
    </div>
     
    <div id="main">
	<div class="post">
	    <h2 class="post-title">
	        <a href="">${question.title}</a>
	    </h2>
	    <div class="post-metadata">
	        <span class="post-author">${question.writer}</span>,
	        <span class="post-date"><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${question.createdDate}" /></span>
	    </div>
	    <div class="post-content">
	        <div class="about">내용 : </div>
	        ${nf:hbr(question.contents)}
	    </div>
	</div>   
	<div class="questionDelete">
		<form method="post">
		<input type="hidden" name="questionId" value="${question.questionId}">
	    <input type="submit" value="질문 삭제"/>
    	</form>
	</div> 
  	<br /> <a href="/list.next">목록으로</a>
  	
	<h3>답변</h3>
	<div class="answerWrite">
	<form method="post">
		<input type="hidden" name="questionId" value="${question.questionId}">
	    <p>
	        <label for="author">이름: </label>
	        <input type="text" name="writer" id="writer" />
	    </p>
	    <p>
	        <label for="content">내용 : </label>
	        <textarea name="content" id="content"></textarea>
	    </p>
	    <p>
	        <input type="submit" value="저장" />
	    </p>
    </form>
    </div>
    
    <!-- comments start -->
	<div class="comments">
	    <h3>
	        댓글 수 : ${question.countOfComment}
	    </h3>
	    	<c:forEach var="result" items="${answers}" varStatus="status">
	    		<div class="comment">
	            <div class="comment-metadata">
	                <span class="comment-author">${result.writer}</span>
	                <span class="comment-date">
	                    ${result.createdDate}
	                </span>
	            </div>
	            <div class="comment-content">
	                <div class="about">내용 : </div>
					${result.contents}
	            </div>
	            <div class="answerDelete">
					<form method="post">
					<input type="hidden" name="questionId" value="${question.questionId}">
					<input type="hidden" name="answerId" value="${result.answerId}">
				    <input type="submit" value="삭제" />
				    </form>
	            </div>
	        </div>	   
	    	</c:forEach>
	</div>
	<!-- comments end -->
	
    </div>
    <%@ include file="/include/footer.jspf"%>
</body>
</html>