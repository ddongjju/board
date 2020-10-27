<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.board.model.BoardMenuVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<ul class="nav nav-sidebar">
		<li class="active"><a href="#">Main <span class="sr-only">(current)</span></a></li>
		<li class="active"><a href="${pageContext.request.contextPath }/createBoard">게시판생성</a></li>
	<c:forEach items="${BoardMenu}" var="boardmenu">
		<li class="active">
		<a href="${pageContext.request.contextPath }/boardList?boardmenu_seq=${boardmenu.boardmenu_seq}">
		${boardmenu.board_name}</a></li>
	</c:forEach>
</ul>