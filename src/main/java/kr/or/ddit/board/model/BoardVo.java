package kr.or.ddit.board.model;

import java.util.Date;

public class BoardVo {
	private String board_title;
	private String board_content;
	private int board_seq;
	private String board_status;
	private Date board_create_date;
	private int boardmenu_seq;
	private int board_parent_seq;
	private String user_id;
	public String getBoard_title() {
		return board_title;
	}
	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}
	public String getBoard_content() {
		return board_content;
	}
	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}
	public int getBoard_seq() {
		return board_seq;
	}
	public void setBoard_seq(int board_seq) {
		this.board_seq = board_seq;
	}
	public String getBoard_status() {
		return board_status;
	}
	public void setBoard_status(String board_status) {
		this.board_status = board_status;
	}
	public Date getBoard_create_date() {
		return board_create_date;
	}
	public void setBoard_create_date(Date board_create_date) {
		this.board_create_date = board_create_date;
	}
	public int getBoardmenu_seq() {
		return boardmenu_seq;
	}
	public void setBoardmenu_seq(int boardmenu_seq) {
		this.boardmenu_seq = boardmenu_seq;
	}
	public int getBoard_parent_seq() {
		return board_parent_seq;
	}
	public void setBoard_parent_seq(int board_parent_seq) {
		this.board_parent_seq = board_parent_seq;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	@Override
	public String toString() {
		return "BoardVo [board_title=" + board_title + ", board_content=" + board_content + ", board_seq=" + board_seq
				+ ", board_status=" + board_status + ", board_create_date=" + board_create_date + ", boardmenu_seq="
				+ boardmenu_seq + ", board_parent_seq=" + board_parent_seq + ", user_id=" + user_id + "]";
	}
	
	
	
	
	
	
}
