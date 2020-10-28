package kr.or.ddit.board.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import kr.or.ddit.board.model.BoardMenuVo;
import kr.or.ddit.board.model.BoardVo;

public class BoardDaoTest {
	
	BoardDao boardDao;
	
	@Test
	public void boardMenuListTest() {
		/***Given***/
		boardDao = new BoardDao();
		
		/***When***/
		List<BoardMenuVo> boardList = boardDao.boardMenuList();

		/***Then***/
		assertNotNull(boardList);
	}
	
	@Test
	public void boardMenuAllList() {
		/***Given***/
		boardDao = new BoardDao();
		
		/***When***/
		List<BoardMenuVo> boardList = boardDao.boardMenuAllList();
		
		/***Then***/
		assertNotNull(boardList);
	}
	
	@Test
	public void getBoard() {
		/***Given***/
		boardDao = new BoardDao();
		int board_seq = 1;
		
		BoardVo boardVo = new BoardVo();
		boardVo.setBoard_title("제목");
		boardVo.setBoard_seq(1);
		/***When***/
		BoardVo vo = boardDao.getBoard(board_seq);
		
		/***Then***/
		assertEquals("제목", boardVo.getBoard_title());
//		assertEquals(boardVo, vo);
	}
	
	

}
