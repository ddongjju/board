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
	


	
});


</script>

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
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button id="modBtn" type="submit" class="btn btn-default" >게시글 수정</button>
						</div>
					</div>
					
				</form>
				<form action="${cp}/boardDelete" method="post">
					<input type="hidden" name="board_seq" value="${boardVo.board_seq }">
					<input type="hidden" name="boardmenu_seq" value="${boardVo.boardmenu_seq }">
					<button id="delBtn" type="submit" class="btn btn-default" >게시글 삭제</button>
				</form>
				<hr>
				<div class="form-group">
						<label for="pass" class="col-sm-2 control-label">다운로드 </label>
						<div class="col-sm-10">
						<c:forEach items="${fileList}" var="file">
							<form action="${cp}/fileDownload" method="post">
								<input type="hidden" data-board_seq="${file.file_seq }">
								<button id="profileDownBtn" type="submit" class="btn btn-default" > ${file.file_realname }</button>
								<input type="hidden" name="file_seq" value="${file.file_seq }">
							</form>
						</c:forEach>
							
						</div>
					</div>
					<br><br><hr>
				
					<button id="boardBtn" type="submit" class="btn btn-default" >답글 작성</button>
					<br><br>
					<hr>
				
				<form class="form-horizontal" role="form" action="${cp}/replyInsert" method="post">
	               <div class="form-group">
	                  <label for="file" class="col-sm-2 control-label"></label>
	                  <div class="col-sm-10">
							<textarea name="reply_content" rows="5" cols="70" placeholder="댓글을 입력하세요"></textarea>
							<button id="replyBtn" type="submit" class="btn btn-default" >댓글 작성</button>
	                  </div>
	               </div>
               </form>
				
			</div>
		</div>
	</div>
</body>
</html>
