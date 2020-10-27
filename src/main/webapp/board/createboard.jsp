<%@page import="kr.or.ddit.member.model.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<%@ include file="/layout/commonLib.jsp" %>
<script type="text/javascript">
</script>


</head>

<body>

<%@ include file="/layout/header.jsp" %>
	

<div class="container-fluid">
	<div class="row">
		<div class="col-sm-3 col-md-2 sidebar">
			<%@ include file="/layout/left.jsp" %>
		</div>
		<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			<div class="blog-header">
				<h1 class="blog-title">게시판생성</h1>
			</div>
			
			<form action="${cp}/createBoard" method="post">
				<label for="boardname">게시판 이름</label>
				<input type="text" name="board_name">
				<select name="use" id="use">
					<option value="Y">사용</option>
					<option value="N">미사용</option>
				</select>
				<button type="submit" class="btn btn-default">생성</button>
			</form>
			<hr>

			<c:forEach items="${BoardAllMenu }" var = "board">
	            <form action="${cp}/updateBoardMenu" method="post" >
		            게시판 이름 :
		            <input type = "hidden" name =  "boardmenu_seq" value = "${board.boardmenu_seq }">
		            <input type = "text" name = "board_name" value = "${board.board_name }">
			            <select name="board_status">
				            <c:choose>
								<c:when test="${board.board_status == 'Y'}">
					                  <option value="Y" selected>사용</option>
					                  <option value="N">미사용</option>
								</c:when>
								<c:when test="${board.board_status == 'N'}">
					                  <option value="Y">사용</option>
					                  <option value="N" selected>미사용</option>
								</c:when>
							</c:choose>
			            </select>
						
		            <button type="submit" class="btn btn-default">수정</button>
		            <br><br>
	            </form>
            </c:forEach>   
			

		</div>
	</div>
</div>
</body>
</html>
