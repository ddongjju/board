package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceI;
import kr.or.ddit.common.model.PageVo;

/**
 * Servlet implementation class BoardListServlet
 */
@WebServlet("/boardList")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	
	private BoardServiceI boardService;
	
	private static final Logger logger = LoggerFactory.getLogger(BoardListServlet.class);
	@Override
	public void init() throws ServletException {
		boardService = new BoardService();
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String page_str = request.getParameter("page");
		int page = page_str == null ? 1 : Integer.parseInt(page_str);
		
		String pageSize_str = request.getParameter("pageSize");
		int pageSize = pageSize_str == null ? 10 : Integer.parseInt(pageSize_str);
		
		int boardmenu_seq = Integer.parseInt(request.getParameter("boardmenu_seq"));
		
		request.setAttribute("boardmenu_seq", boardmenu_seq);
		request.setAttribute("page", page);
		request.setAttribute("pageSize", pageSize);
		
		
		PageVo pageVo = new PageVo(page,pageSize, boardmenu_seq);
//		vo.setPage(page);
//		vo.setPageSize(pageSize);
		
		Map<String, Object> map = boardService.selectPageBoard(pageVo);
		request.setAttribute("boardList", map.get("boardList"));
		request.setAttribute("pages", map.get("pages"));
		request.setAttribute("pageSize", map.get("pageSize"));
		
		request.getRequestDispatcher("/board/boardList.jsp").forward(request, response);
	}
	
}
