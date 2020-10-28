package kr.or.ddit.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.model.BoardMenuVo;
import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.file.model.FileVo;

public class BoardDao implements BoardDaoI{
	
	private static final Logger logger = LoggerFactory.getLogger(BoardDao.class);

	@Override
	public int createBoard(String board_name) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int cnt = 0;
		try {
			cnt = sqlSession.insert("board.createBoard", board_name);
		}catch (Exception e) {
			// TODO: handle exception
		}
		if(cnt == 1) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		sqlSession.close();

		return cnt;
	}

	@Override
	public List<BoardMenuVo> boardMenuList() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		List<BoardMenuVo> boardmenuVo = sqlSession.selectList("board.boardMenuList");
		sqlSession.close();
		
		return boardmenuVo;
	}
	
	public List<BoardVo> selectPageBoard(SqlSession sqlSession, PageVo pageVo){
		return sqlSession.selectList("board.pagecount",pageVo);
	}

	@Override
	public int selectBoardTotalCnt(SqlSession sqlSession, int boardmenu_seq) {
		return sqlSession.selectOne("board.selectBoardTotalCnt",boardmenu_seq);
	}

	@Override
	public List<BoardMenuVo> boardMenuAllList() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		List<BoardMenuVo> boardmenuVo = sqlSession.selectList("board.boardMenuAllList");
		sqlSession.close();
		
		return boardmenuVo;
	}

	@Override
	public int updateboardMenu(BoardMenuVo vo) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int cnt = 0;
		try {
			cnt = sqlSession.insert("board.updateboardMenu", vo);
		}catch (Exception e) {
		}
		if(cnt == 1) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		sqlSession.close();

		return cnt;
	}

	@Override
	public int insertBoard(BoardVo vo) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int	cnt = sqlSession.insert("board.insertBoard", vo);
		
		if(cnt > 0 ) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		sqlSession.close();
		logger.debug("등록완료값:{}",cnt);
		return vo.getBoard_seq();
	}

	@Override
	public int insertFile(FileVo vo) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int cnt = 0;
		try {
			cnt = sqlSession.insert("board.insertFile", vo);
		}catch (Exception e) {
		}
		if(cnt == 1) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		sqlSession.close();
		logger.debug("등록완료값2:{}",cnt);
		return cnt;
	}

	@Override
	public BoardVo getBoard(int board_seq) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		BoardVo boardVo = sqlSession.selectOne("board.getBoard", board_seq);
		sqlSession.close();
		
		return boardVo;
	}

	@Override
	public int updateBoard(BoardVo vo) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int cnt = 0;
		try {
			cnt = sqlSession.update("board.updateBoard", vo);
		}catch (Exception e) {
		}
		if(cnt == 1) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		sqlSession.close();
	
		return cnt;
	}

	@Override
	public FileVo getFile(int board_seq) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		FileVo fileVo = sqlSession.selectOne("board.getFile", board_seq);
		sqlSession.close();
		
		return fileVo;
	}

	@Override
	public int insertBoardDown(BoardVo boardVo) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int cnt = 0;
		try {
			cnt = sqlSession.insert("board.insertBoardDown", boardVo);
		}catch (Exception e) {
		}
		if(cnt == 1) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		sqlSession.close();
		return boardVo.getBoard_seq();
	}

	@Override
	public List<FileVo> showFile(int board_seq) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		List<FileVo> FileList = sqlSession.selectList("board.showFile",board_seq);
		sqlSession.close();
		
		return FileList;
	}

	@Override
	public FileVo getFileDown(int file_seq) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		FileVo fileVo = sqlSession.selectOne("board.getFileDown", file_seq);
		sqlSession.close();
		
		return fileVo;
	}

	@Override
	public int deleteBoard(int board_seq) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int cnt = 0;
		try {
			cnt = sqlSession.update("board.deleteBoard", board_seq);
		}catch (Exception e) {
		}
		if(cnt == 1) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		sqlSession.close();
	
		return cnt;
	}

	@Override
	public int deleteFile(int file_seq) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int cnt = 0;
		try {
			cnt = sqlSession.delete("board.deleteFile", file_seq);
		}catch (Exception e) {
		}
		if(cnt == 1) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		sqlSession.close();
	
		return cnt;
	}
	
	

}
