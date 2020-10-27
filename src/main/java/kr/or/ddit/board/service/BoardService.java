package kr.or.ddit.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.dao.BoardDao;
import kr.or.ddit.board.dao.BoardDaoI;
import kr.or.ddit.board.model.BoardMenuVo;
import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.file.model.FileVo;

public class BoardService implements BoardServiceI{
	
	private static BoardDaoI boardDao;
	
	public BoardService() {
		boardDao = new BoardDao();
	}

	@Override
	public int createBoard(String board_name) {
		return boardDao.createBoard(board_name);
	}

	@Override
	public List<BoardMenuVo> boardMenuList() {
		return boardDao.boardMenuList();
	}

	@Override
	public Map<String, Object> selectPageBoard(PageVo pageVo) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("boardList", boardDao.selectPageBoard(sqlSession, pageVo));
		
		int totalCnt = boardDao.selectBoardTotalCnt(sqlSession, pageVo.getBoardmenu_seq());
		int pages = (int)Math.ceil((double)totalCnt/pageVo.getPageSize());
		map.put("pages", pages);
		map.put("pageSize", pageVo.getPageSize());
		
		return map;
	}

	@Override
	public List<BoardMenuVo> boardMenuAllList() {
		return boardDao.boardMenuAllList();
	}

	@Override
	public int updateboardMenu(BoardMenuVo vo) {
		return boardDao.updateboardMenu(vo);
	}

	@Override
	public int insertBoard(BoardVo vo) {
		return boardDao.insertBoard(vo);
	}

	@Override
	public int insertFile(FileVo vo) {
		return boardDao.insertFile(vo);
	}

	@Override
	public BoardVo getBoard(int board_seq) {
		return boardDao.getBoard(board_seq);
	}

	@Override
	public int updateBoard(BoardVo vo) {
		return boardDao.updateBoard(vo);
	}

	@Override
	public FileVo getFile(int board_seq) {
		return boardDao.getFile(board_seq);
	}

	@Override
	public int insertBoardDown(BoardVo boardVo) {
		return boardDao.insertBoardDown(boardVo);
	}

	@Override
	public List<FileVo> showFile(int board_seq) {
		return boardDao.showFile(board_seq);
	}

	@Override
	public FileVo getFileDown(int file_seq) {
		return boardDao.getFileDown(file_seq);
	}

	@Override
	public int deleteBoard(int board_seq) {
		return boardDao.deleteBoard(board_seq);
	}
	
	

}
