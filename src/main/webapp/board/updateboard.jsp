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
	
	$('#fileBtn1').on('click', function(){
		a = ($(this)).attr('value');
		$(this).hide();
		$('#fileshow1').show();
		$('#file_seq1').val(a);
		
	})
	$('#fileBtn2').on('click', function(){
		a = ($(this)).attr('value');
		$(this).hide();
		$('#fileshow2').show();
		$('#file_seq2').val(a);

	})
	$('#fileBtn3').on('click', function(){
		a = ($(this)).attr('value');
		$(this).hide();
		$('#fileshow3').show();
		$('#file_seq3').val(a);

	})
	$('#fileBtn4').on('click', function(){
		a = ($(this)).attr('value');
		$(this).hide();
		$('#fileshow4').show();
		$('#file_seq4').val(a);

	})
	$('#fileBtn5').on('click', function(){
		a = ($(this)).attr('value');
		$(this).hide();
		$('#fileshow5').show();
		$('#file_seq5').val(a);
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
               
               
               
               <input type="hidden" name="boardmenu_seq" value="${boardVo.boardmenu_seq}">
               <input type="hidden" name="user_id" value="${S_MEMBER.user_id}">
               <input type="hidden" name="board_seq" value="${boardVo.board_seq}">
               <textarea id="summernote" name="board_content">${boardVo.board_content}</textarea>
               
               
               
                  
             <c:forEach items="${filelist}" var="file" varStatus="status">
               <div class="form-group">
                  <label for="file" class="col-sm-2 control-label">첨부파일</label>
                  <div class="col-sm-10">
                  		<input type="file" id="fileshow${status.count }" name="file_realname${status.count }" style="display: none"/>
						<button id="fileBtn${status.count }" type="button" class="btn btn-default" value="${file.file_seq}">${file.file_realname} x</button>
					</div>
               </div>
			</c:forEach>
			
			<c:forEach var="i" begin="${fileCount + 1}" end="5" step="1">
				<div class="form-group">
                  <label for="file" class="col-sm-2 control-label">첨부파일</label>
                  <div class="col-sm-10">
                  		<input type="file" name="file_realname${i}"/>
					</div>
               </div>
			</c:forEach>
						<input type="hidden" id="file_seq1" name="file_seq1" value="">
						<input type="hidden" id="file_seq2" name="file_seq2" value="">
						<input type="hidden" id="file_seq3" name="file_seq3" value="">
						<input type="hidden" id="file_seq4" name="file_seq4" value="">
						<input type="hidden" id="file_seq5" name="file_seq5" value="">
               
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