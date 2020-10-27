package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceI;
import kr.or.ddit.file.controller.FileUploadUtil;
import kr.or.ddit.file.model.FileVo;


/**
 * Servlet implementation class BoardInsertServlet
 */
@WebServlet("/boardInsert")
@MultipartConfig
public class BoardInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(BoardInsertServlet.class);
	private BoardServiceI boardService;
	BoardVo boardVo;
	
	@Override
	public void init() throws ServletException {
		boardService = new BoardService();
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int boardmenu_seq = Integer.parseInt((request.getParameter("boardmenu_seq")));
		request.setAttribute("boardmenu_seq", boardmenu_seq);
//		
//		String board_seq = request.getParameter("board_seq");
//		request.setAttribute("board_seq", board_seq);
		
		request.getRequestDispatcher("/board/insertboard.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String board_title = request.getParameter("board_title");
		String board_content = request.getParameter("board_content");
		int boardmenu_seq = Integer.parseInt(request.getParameter("boardmenu_seq"));
		String user_id = request.getParameter("user_id");
//		String board_seq = request.getParameter(BoardVo);

		logger.debug("{} : ",board_title);
		logger.debug("{} : ",board_content);
		logger.debug("boardmenu_seq : {} ",boardmenu_seq);
		logger.debug("{} : ",user_id);
//		logger.debug("board_seq : {} ",board_seq);
		
		boardVo = new BoardVo();
		boardVo.setBoard_title(board_title);
		boardVo.setBoard_content(board_content);
		boardVo.setBoardmenu_seq(boardmenu_seq);
		boardVo.setUser_id(user_id);
		int cnt = boardService.insertBoard(boardVo);
		
		for(int i = 1; i<6; i++) {
			Part file = request.getPart("file_realname" + i);
			
			String realFilename = FileUploadUtil.getFilename(file.getHeader("Content-Disposition"));
			String ext = FileUploadUtil.getExtension(realFilename);
			String fileName = UUID.randomUUID().toString();
			String filePath = "";
			
			
			if (file.getSize() > 0) {
				filePath = "D:\\profile\\" + fileName + "." + ext;
				file .write(filePath);
				
				FileVo fileVo = new FileVo();
				
				logger.debug("글번호 : {}", cnt);
				fileVo.setFile_name(filePath);
				fileVo.setFile_realname(realFilename);
				fileVo.setBoard_seq(cnt);
				boardService.insertFile(fileVo);
			}
			
//			logger.debug("filePath : {}",filePath);
//			logger.debug("fileName : {}",fileName);
//			logger.debug("realFilename : {}",realFilename);
			
			
		}
		
		if(cnt > 0) {
			String redirectUrl = request.getContextPath() + "/boardList?boardmenu_seq="+boardmenu_seq;
			response.sendRedirect(redirectUrl);
			
		}else {
			doGet(request, response);
		}
		

	}

}
