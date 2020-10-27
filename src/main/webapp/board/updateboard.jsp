<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<%@ include file="/layout/commonLib.jsp" %>

<!-- include summernote css/js -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>

<title>Jsp</title>

<script>
$(document).ready(function(){
	
	$('#summernote').summernote();


	$('#regBtn').on('click', function(){
		
		$('#frm').submit();

	})
});

</script>
<style type="text/css">
	#dd{
		width: 70%;
		height: 70%;
	}
	.note-editable{
		height: 500px;
	}
</style>

</head>

<body>
   <%@ include file="/layout/header.jsp" %>
   
   <div class="container-fluid">
      <div class="row">

         <div class="col-sm-3 col-md-2 sidebar">
            <%@ include file="/layout/left.jsp" %>
         </div>
         <br><br>
         <div id ="dd2" class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
	<div id = "dd">
            <form id="frm" class="form-horizontal" role="form" action="${cp}/boardUpdate" method="post" enctype="multipart/form-data">
               <div class="form-group">
                  <label for="userid" class="col-sm-2 control-label">게시글 제목</label>
                  <div class="col-sm-10">
                     <input type="text" class="form-control" id="board_title" name="board_title" placeholder="제목" value="${boardVo.board_title}">
                  </div>
               </div>
               
               <div class="form-group">
                  <label for="file" class="col-sm-2 control-label">첨부파일</label>
                  <div class="col-sm-10">
						<img src="${cp}/profileImg?board_seq=${boardVo.board_seq}"><br>
					</div>
               </div>
               
               
               
               <input type="hidden" name="boardmenu_seq" value="${boardVo.boardmenu_seq}">
               <input type="hidden" name="user_id" value="${S_MEMBER.user_id}">
               <input type="hidden" name="board_seq" value="${boardVo.board_seq}">
               <textarea id="summernote" name="board_content">${boardVo.board_content}</textarea>
               <div class="form-group">
                  <label for="file" class="col-sm-2 control-label">첨부파일</label>
                  <div class="col-sm-10">
                     <input type="file" name="file_realname"/>
               		</div>
                 </div>
               <div class="form-group">
                  <label for="file" class="col-sm-2 control-label">첨부파일</label>
                  <div class="col-sm-10">
                     <input type="file" name="file_realname"/>
               		</div>
                 </div>
               <div class="form-group">
                  <label for="file" class="col-sm-2 control-label">첨부파일</label>
                  <div class="col-sm-10">
                     <input type="file" name="file_realname"/>
               		</div>
                 </div>
               <div class="form-group">
                  <label for="file" class="col-sm-2 control-label">첨부파일</label>
                  <div class="col-sm-10">
                     <input type="file" name="file_realname"/>
               		</div>
                 </div>
               <div class="form-group">
                  <label for="file" class="col-sm-2 control-label">첨부파일</label>
                  <div class="col-sm-10">
                     <input type="file" name="file_realname"/>
               		</div>
                 </div>
               
               <div class="form-group">
                  <div class="col-sm-offset-2 col-sm-10">
                     <button id="regBtn" type="button" class="btn btn-default">게시글 수정</button>
                  </div>
               </div>
            </form>
         </div>
   </div>
      </div>
   </div>
</body>
</html>