package kr.or.ddit.reply.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceI;
import kr.or.ddit.reply.model.ReplyVo;
import kr.or.ddit.reply.service.ReplyService;
import kr.or.ddit.reply.service.ReplyServiceI;

/**
 * Servlet implementation class ReplyInsertServlet
 */
@WebServlet("/replyInsert")
public class ReplyInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private BoardServiceI boardService;
	private ReplyServiceI replyService;
	
	private static final Logger logger = LoggerFactory.getLogger(ReplyInsertServlet.class);
	@Override
	public void init() throws ServletException {
		boardService = new BoardService();
		replyService = new ReplyService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int board_seq = Integer.parseInt(request.getParameter("board_seq"));
		String reply_content = request.getParameter("reply_content");
		String user_id = request.getParameter("user_id");
		
		
		ReplyVo replyVo = new ReplyVo();
		replyVo.setBoard_seq(board_seq);
		replyVo.setReply_content(reply_content);
		replyVo.setUser_id(user_id);
		
		int cnt = replyService.insertReply(replyVo);
		
		List<ReplyVo> replyList = replyService.ReplyList(board_seq);
		
		
		if(cnt > 0) {
			request.setAttribute("replyList", replyList);
			String redirectUrl = request.getContextPath() + "/board?board_seq="+board_seq;
			response.sendRedirect(redirectUrl);
		}else {
			doGet(request, response);
		}
		
		
		
		
	}

}
