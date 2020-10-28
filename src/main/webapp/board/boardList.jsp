<%@page import="kr.or.ddit.member.model.MemberVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<%@ include file="/layout/commonLib.jsp" %>
<script>
$(document).ready(function(){
	$('#boardList tr').on('click',function(){	
		var board_status =$(this).data("board_status");
		if(board_status=='N'){
			
		}
		else{
			var board_seq =$(this).data("board_seq");
			console.log(board_seq)
	
			document.location="/board/board?board_seq="+board_seq;
		}
	})
})

</script>


</head>

<body>
<%@ include file="/layout/header.jsp" %>
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<%@ include file="/layout/left.jsp"%>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

				<div class="row">
					<div class="col-sm-8 blog-main">
						<h2 class="sub-header">게시글</h2>
						<div class="table-responsive">
							<table class="table table-striped">

								<tr>
									<th>게시글 번호</th>
									<th>제목</th>
									<th>작성자 아이디</th>
									<th>작성일시</th>
								</tr>
								<tbody id="boardList">
									<c:forEach items="${boardList}" var="board">
										<tr data-board_seq="${board.board_seq }" data-board_status="${board.board_status }"> 
											<td>${board.board_seq }</td>
											<td>${board.board_title}</td>
											<td>${board.user_id}</td>
											<!-- format : yyyy-MM-dd -->
											<td><fmt:formatDate value="${board.board_create_date}" pattern="yyyy-MM-dd"/></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>

						<a class="btn btn-default pull-right" href="${cp}/boardInsert?boardmenu_seq=${boardmenu_seq}">게시글 등록</a>
						<div class="text-center">
							<ul class="pagination">
							<c:choose>
								<c:when test="${page == 0 }"></c:when>
								<c:when test="${page == 1 }">
									  <li class="active"><a href="#"><<</a></li>
									  <li class="active"><a href="#"><</a></li>
								</c:when>
								<c:otherwise>
									  <li><a href="${pageContext.request.contextPath }/boardList?page=1&boardmenu_seq=${boardmenu_seq}"><<</a></li>
									  <li><a href="${pageContext.request.contextPath }/boardList?page=${page-1 }&boardmenu_seq=${boardmenu_seq}"><</a></li>
								</c:otherwise>
							</c:choose>
							
									<c:forEach var="i" begin="1" end="${pages }">
										<c:choose>
											<c:when test="${i == page}">
												<li class="active"><span>${i}</span></li>
											</c:when>
											<c:otherwise>
												<li><a href="${pageContext.request.contextPath }/boardList?page=${i}&boardmenu_seq=${boardmenu_seq}">${i}</a></li>
											</c:otherwise>
										</c:choose>
									</c:forEach>
									
							<c:choose>
								<c:when test="${page == pages }">
									  <li class="active"><a href="#">></a></li>
									  <li class="active"><a href="#">>></a></li>
								</c:when>
								<c:otherwise>
									  <li><a href="${pageContext.request.contextPath }/boardList?page=${page+1 }&boardmenu_seq=${boardmenu_seq}">></a></li>
									  <li><a href="${pageContext.request.contextPath }/boardList?page=${pages }&boardmenu_seq=${boardmenu_seq}">>></a></li>
								</c:otherwise>
							</c:choose> 
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
