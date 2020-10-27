package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.model.BoardMenuVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceI;

/**
 * Servlet implementation class CreateBoardServlet
 */
@WebServlet("/createBoard")
public class CreateBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private BoardServiceI boardService;
	
	@Override
	public void init() throws ServletException {
		boardService = new BoardService();
	}
	
	private static final Logger logger = LoggerFactory.getLogger(CreateBoardServlet.class);
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<BoardMenuVo> allList = boardService.boardMenuAllList();
		
		request.getSession().setAttribute("BoardAllMenu", allList);
		
		request.getRequestDispatcher("/board/createboard.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String board_name = request.getParameter("board_name");
		
		logger.debug("board_name : {}", board_name);
//		BoardServiceI boardService = new BoardService();
		
		int cnt = boardService.createBoard(board_name);
		
		List<BoardMenuVo> vo = boardService.boardMenuList();
		
		request.getSession().setAttribute("BoardMenu", vo);
		
		
		logger.debug("board : {}", vo.toString());
		
		if (cnt == 1) {
			String redirectUrl = request.getContextPath() + "/createBoard";
			response.sendRedirect(redirectUrl);
		} else {
			doGet(request, response);
		}
		
		
		
	}

}
