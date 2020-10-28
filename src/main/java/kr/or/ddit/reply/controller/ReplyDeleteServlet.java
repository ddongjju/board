package kr.or.ddit.reply.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.reply.service.ReplyService;
import kr.or.ddit.reply.service.ReplyServiceI;

/**
 * Servlet implementation class ReplyDeleteServlet
 */
@WebServlet("/deleteReply")
public class ReplyDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ReplyServiceI replyService;
	
	@Override
	public void init() throws ServletException {
		replyService = new ReplyService();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int reply_seq = Integer.parseInt(request.getParameter("reply_seq"));
		int board_seq = Integer.parseInt(request.getParameter("board_seq"));
		
		int cnt = replyService.deleteReply(reply_seq);
		

		if(cnt > 0) {
			String redirectUrl = request.getContextPath() + "/board?board_seq="+board_seq;
			response.sendRedirect(redirectUrl);
		}
	}

}
