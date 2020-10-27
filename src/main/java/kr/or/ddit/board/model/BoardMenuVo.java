package kr.or.ddit.board.model;

public class BoardMenuVo {
	private int boardmenu_seq;
	private String board_name;
	private String board_status;
	
	public int getBoardmenu_seq() {
		return boardmenu_seq;
	}
	public void setBoardmenu_seq(int boardmenu_seq) {
		this.boardmenu_seq = boardmenu_seq;
	}
	public String getBoard_name() {
		return board_name;
	}
	public void setBoard_name(String board_name) {
		this.board_name = board_name;
	}
	public String getBoard_status() {
		return board_status;
	}
	public void setBoard_status(String board_status) {
		this.board_status = board_status;
	}
	@Override
	public String toString() {
		return "BoardMenuVo [boardmenu_seq=" + boardmenu_seq + ", board_name=" + board_name + ", board_status="
				+ board_status + "]";
	}
	
	
	
	
}
