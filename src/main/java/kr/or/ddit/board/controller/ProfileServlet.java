package kr.or.ddit.board.controller;

import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceI;
import kr.or.ddit.file.model.FileVo;

@WebServlet("/profileImg")
public class ProfileServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
   private BoardServiceI boardService;
   
   @Override
   public void init() throws ServletException {
	   boardService = new BoardService();
   }
   
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // response context-type 설정
      response.setContentType("image/png");
      
      // 사용자 아이디 파라미터 확인하고
      int board_seq = Integer.parseInt(request.getParameter("board_seq"));
      
      // db에서 사용자 filename 확인
      FileVo fileVo = boardService.getFile(board_seq);
      
      // 경로 확인 후 파일 입출력을 통해 응답생성
      // 파일 읽기
      // 응답 생성
//      mv.getFilename(); // 파일 경로
      FileInputStream fis = new FileInputStream(fileVo.getFile_name());
      
      ServletOutputStream sos = response.getOutputStream();
      
      byte[] buffer = new byte[512];
      
      while(fis.read(buffer) != -1) {
         sos.write(buffer);
      }
      
      fis.close();
      sos.flush();
      sos.close();
      
   }
}