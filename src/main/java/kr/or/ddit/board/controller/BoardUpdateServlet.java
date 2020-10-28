package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
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
		List<FileVo> filelist = boardService.showFile(board_seq);
		int fileCount = filelist.size();
		
		request.setAttribute("boardVo", boardVo);
		request.setAttribute("filelist", filelist);
		request.setAttribute("fileCount", fileCount);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/board/updateboard.jsp");
		dispatcher.forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String board_title = request.getParameter("board_title");
		String board_content = request.getParameter("board_content");
		int board_seq = Integer.parseInt(request.getParameter("board_seq"));
		
		
		String file_seq1 = request.getParameter("file_seq1");
		String file_seq2 = request.getParameter("file_seq2");
		String file_seq3 = request.getParameter("file_seq3");
		String file_seq4 = request.getParameter("file_seq4");
		String file_seq5 = request.getParameter("file_seq5");
		
		logger.debug("file_seq1 : {}", file_seq1);
		if(!(file_seq1.equals("")) && file_seq1 != null) {
			int file_seq= Integer.parseInt(file_seq1);
			boardService.deleteFile(file_seq);
		}
		
		if(!(file_seq2.equals("")) && file_seq1 != null) {
			int file_seq= Integer.parseInt(file_seq2);
			boardService.deleteFile(file_seq);
		}
		
		if(!(file_seq3.equals("")) && file_seq1 != null) {
			int file_seq= Integer.parseInt(file_seq3);
			boardService.deleteFile(file_seq);
		}
		
		if(!(file_seq4.equals("")) && file_seq1 != null) {
			int file_seq= Integer.parseInt(file_seq4);
			boardService.deleteFile(file_seq);
		}
		
		if(!(file_seq5.equals("")) && file_seq1 != null) {
			int file_seq= Integer.parseInt(file_seq5);
			boardService.deleteFile(file_seq);
		}
		
		logger.debug("parameter : {}, {}", board_title,  board_content);
		
		boardVo.setBoard_title(board_title);
		boardVo.setBoard_content(board_content);
		
		int cnt = boardService.updateBoard(boardVo);
		
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
				
				fileVo.setFile_name(filePath);
				fileVo.setFile_realname(realFilename);
				fileVo.setBoard_seq(board_seq);
				boardService.insertFile(fileVo);
			}
			
			logger.debug("filePath : {}",filePath);
			logger.debug("fileName : {}",fileName);
			logger.debug("realFilename : {}",realFilename);
			
			
		}

		if (cnt == 1) {
			String redirectUrl = request.getContextPath() + "/board?board_seq="+boardVo.getBoard_seq();
			response.sendRedirect(redirectUrl);
		} else {
			doGet(request, response);
		}
	}

}
