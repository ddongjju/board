<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Jsp</title>

<%@ include file="/layout/commonLib.jsp"%>
<script type="text/javascript">
$(document).ready(function(){
	
	$('#boardBtn').on('click',function(){
		document.location="${cp}/boardDownInsert?board_seq=${boardVo.board_seq}&boardmenu_seq=${boardVo.boardmenu_seq }";
	});


	//서류사항 textarea 체크
	$('.DOC_TEXT').keyup(function (e){
	    var content = $(this).val();
	    $('#counter').html("("+content.length+" / 최대 500자)");    //글자수 실시간 카운팅

	    if (content.length > 500){
	        alert("최대 500자까지 입력 가능합니다.");
	        $(this).val(content.substring(0, 500));
	        $('#counter').html("(500 / 최대 500자)");
	    }
	});


	
});


</script>
<style type="text/css">
	#hh{
		float: left;
	}
</style>

</head>

<body>
<%@ include file="/layout/header.jsp"%>
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<%@ include file="/layout/left.jsp"%>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">


				<form id="frm" class="form-horizontal" role="form" enctype="multipart/form-data" action="${cp}/boardUpdate" method="get">
					<div class="form-group">
						<label  for="userid" class="col-sm-2 control-label">게시글 번호</label>
						<div class="col-sm-10">
							<label id="label_userid" class="control-label">${boardVo.board_seq }</label>
							<input type="hidden" name="board_seq" value="${boardVo.board_seq }">
							<input type="hidden" name="boardmenu_seq" value="${boardVo.boardmenu_seq }">
						</div>
					</div>
					
					<div class="form-group">
						<label  for="userid" class="col-sm-2 control-label">게시글 제목</label>
						<div class="col-sm-10">
							<label id="label_userid" class="control-label">${boardVo.board_title }</label>
							<input type="hidden" name="board_title" value="${boardVo.board_title }">
						</div>
					</div>

					<div class="form-group">
						<label for="usernm" class="col-sm-2 control-label">게시글 내용</label>
						<div class="col-sm-10">
							<label class="control-label">${boardVo.board_content }</label>
							<input type="hidden" name="board_content" value="${boardVo.board_content }">
						</div>
					</div>
					<div class="form-group">
						<label for="pass" class="col-sm-2 control-label">작성자</label>
						<div class="col-sm-10">
							<label class="control-label">${boardVo.user_id }</label>
							<input type="hidden" name="user_id" value="${boardVo.user_id }">
						</div>
					</div>
					
					
					
					
					<div class="form-group">
						<label for="reg_dt" class="col-sm-2 control-label">작성일자</label>
						<div class="col-sm-10">
							<label class="control-label">
							<fmt:formatDate value="${boardVo.board_create_date }" pattern="YYYY-MM-dd"/>
							<input type="hidden" name="reg_dt" value="${boardVo.board_create_date }">
							</label>
						</div>
					</div>
					
					
					<c:if test="${S_MEMBER.user_id==boardVo.user_id}">
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<button id="modBtn" type="submit" class="btn btn-default" >게시글 수정</button>
							</div>
						</div>
					</c:if>
				</form>
				
				
				<hr>
				<c:if test="${S_MEMBER.user_id==boardVo.user_id}">
					<form action="${cp}/boardDelete" method="post">
						<input type="hidden" name="board_seq" value="${boardVo.board_seq }">
						<input type="hidden" name="boardmenu_seq" value="${boardVo.boardmenu_seq }">
						<button id="delBtn" type="submit" class="btn btn-default" >게시글 삭제</button>
					</form>
					<hr>
				</c:if>
				
				<button id="boardBtn" type="submit" class="btn btn-default" >답글 작성</button>


				<hr>
				<div>
					<div class="form-group">
						<label for="pass" class="col-sm-2 control-label">다운로드 </label>
						<div class="col-sm-10">
							<c:forEach items="${fileList}" var="file">
								<form action="${cp}/fileDownload" method="post">
									<input type="hidden" data-board_seq="${file.file_seq }">
									<input type="hidden" name="file_seq" value="${file.file_seq }">
									<button id="profileDownBtn" type="submit"
										class="btn btn-default">${file.file_realname }</button>
								</form>
							</c:forEach>

						</div>
					</div>
				</div>

				<hr id="hh"><br>
				
	               <c:forEach items="${replyList }" var="reply">
	               		<form action="${cp}/deleteReply" method="post">
		               		<div class="form-group">
								<div class="col-sm-10">
								<label for="reply" class="col-sm-2 control-label">댓글</label>
								<c:choose>
									<c:when test="${reply.reply_status=='Y'}">
										<label class="control-label">${reply.reply_seq}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;/</label>
										<label class="control-label">&nbsp;&nbsp;&nbsp;&nbsp;${reply.reply_content }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;/</label>
										<label class="control-label">&nbsp;&nbsp;&nbsp;&nbsp;${reply.user_id}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
									<c:if test="${S_MEMBER.user_id==reply.user_id}">
										<input type="submit" value="댓글삭제">
	             					</c:if>
				                  		<input type="hidden" name="reply_seq" value="${reply.reply_seq}">
				                  		<input type="hidden" name="board_seq" value="${reply.board_seq}">
				                  		<input type="hidden" name="reply_status" value="${reply.reply_status}">
										<hr>
									</c:when>
									<c:when test="${reply.reply_status=='N'}">
										<label class="control-label">삭제된 댓글입니다.</label>
										<hr>
									</c:when>
								</c:choose>
								</div>
							</div>	
						</form>
	               </c:forEach>
					
					<form class="form-horizontal" role="form" action="${cp}/replyInsert" method="post">
		               <div class="form-group">
		                  <label for="file" class="col-sm-2 control-label"></label>
		                  <div class="col-sm-10">
		                  	<input type="hidden" name="board_seq" value="${boardVo.board_seq }">
		                  	<input type="hidden" name="user_id" value="${S_MEMBER.user_id }">
								<textarea class="DOC_TEXT" name="reply_content" rows="5" cols="70" placeholder="댓글을 입력하세요"></textarea>
								<span style="color:#aaa;" id="counter">(0 / 최대 500자)</span>
								<button id="replyBtn" type="submit" class="btn btn-default" >댓글 작성</button>
		                  </div>
		               </div>
	               </form>
	               




	               
				
			</div>
		</div>
	</div>
</body>
</html>
