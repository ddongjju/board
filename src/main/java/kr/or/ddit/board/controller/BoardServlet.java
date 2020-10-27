package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceI;
import kr.or.ddit.file.model.FileVo;

/**
 * Servlet implementation class BoardServlet
 */
@WebServlet("/board")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardServiceI boardService;
	
	@Override
	public void init() throws ServletException {
		boardService = new BoardService();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * userid 파라미터 받기 service 객체 준비 - 호출 화면 담당 jsp로 위임
		 */
		int board_seq = Integer.parseInt(request.getParameter("board_seq"));

		BoardVo boardVo = boardService.getBoard(board_seq);

		request.setAttribute("boardVo", boardVo);
		
		List<FileVo> fileList = boardService.showFile(board_seq);
		request.setAttribute("fileList", fileList);
		

		request.getRequestDispatcher("/board/board.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
