package kr.or.ddit.board.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.board.model.BoardMenuVo;
import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.file.model.FileVo;

public interface BoardServiceI {

	
	int createBoard(String board_name);
	
	List<BoardMenuVo> boardMenuList();
	
	List<BoardMenuVo> boardMenuAllList();
	
	Map<String, Object> selectPageBoard(PageVo pageVo);
	
	int updateboardMenu(BoardMenuVo vo);
	
	int insertBoard(BoardVo vo);
	
	int insertFile(FileVo vo);
	
	BoardVo getBoard(int board_seq);
	
	int updateBoard(BoardVo vo);

	FileVo getFile(int board_seq);

	int insertBoardDown(BoardVo boardVo);

	List<FileVo> showFile(int board_seq);

	FileVo getFileDown(int file_seq);

	int deleteBoard(int board_seq);
	
	
}
