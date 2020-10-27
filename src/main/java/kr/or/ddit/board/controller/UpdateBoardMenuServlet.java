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
 * Servlet implementation class UpdateBoardMenuServlet
 */
@WebServlet("/updateBoardMenu")
public class UpdateBoardMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory.getLogger(UpdateBoardMenuServlet.class);
	private BoardServiceI boardService;
	
	@Override
	public void init() throws ServletException {
		boardService = new BoardService();
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/board/createboard.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int boardmenu_seq = Integer.parseInt(request.getParameter("boardmenu_seq"));
		String board_name = request.getParameter("board_name");
		String board_status = request.getParameter("board_status");
		logger.debug("boardmenu_seq : {}", boardmenu_seq);
		logger.debug("board_name : {}", board_name);
		logger.debug("board_status : {}", board_status);
		try {
			if(board_status.equals("미사용")||board_status.equals("N")){
				board_status ="N";
			}else {
				board_status ="Y";
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		BoardMenuVo vo = new BoardMenuVo();
		
		vo.setBoardmenu_seq(boardmenu_seq);
		vo.setBoard_name(board_name);
		vo.setBoard_status(board_status);
		
		int cnt = boardService.updateboardMenu(vo);
		
		List<BoardMenuVo> BoardAllMenu= boardService.boardMenuAllList();
		List<BoardMenuVo> BoardMenu= boardService.boardMenuList();
		
		
		request.getSession().setAttribute("BoardAllMenu", BoardAllMenu);
		request.getSession().setAttribute("BoardMenu", BoardMenu);
		
		if (cnt > 0) {
			String redirectUrl = request.getContextPath() + "/createBoard";
			response.sendRedirect(redirectUrl);
		} else {
			doGet(request, response);
		}
	}

}
