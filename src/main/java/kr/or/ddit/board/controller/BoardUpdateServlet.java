package kr.or.ddit.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceI;

/**
 * Servlet implementation class BoardUpdateServlet
 */
@WebServlet("/boardUpdate")
@MultipartConfig
public class BoardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private BoardServiceI boardService;
	
	BoardVo boardVo;
	
	private static final Logger logger = LoggerFactory.getLogger(BoardUpdateServlet.class);
	
	@Override
	public void init() throws ServletException {
		boardService = new BoardService();
		boardVo = new BoardVo();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String board_seq = request.getParameter("board_seq");
		int board_seq = Integer.parseInt(request.getParameter("board_seq"));
		boardVo = boardService.getBoard(board_seq);
		request.setAttribute("boardVo", boardVo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/board/updateboard.jsp");
		dispatcher.forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String board_title = request.getParameter("board_title");
		String board_content = request.getParameter("board_content");
//		request.getParameter("file_realname");
		logger.debug("parameter : {}, {}", board_title,  board_content);
		
		boardVo.setBoard_title(board_title);
		boardVo.setBoard_content(board_content);
		
		int cnt = boardService.updateBoard(boardVo);

		if (cnt == 1) {
			String redirectUrl = request.getContextPath() + "/board?board_seq="+boardVo.getBoard_seq();
			response.sendRedirect(redirectUrl);
		} else {
			doGet(request, response);
		}
	}

}
