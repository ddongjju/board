package kr.or.ddit.reply.model;

import java.util.Date;

public class ReplyVo {
	
	private String reply_seq;
	private String reply_content;
	private String reply_status;
	private Date reply_create_date;
	private String board_seq;
	private String user_id;
	public String getReply_seq() {
		return reply_seq;
	}
	public void setReply_seq(String reply_seq) {
		this.reply_seq = reply_seq;
	}
	public String getReply_content() {
		return reply_content;
	}
	public void setReply_content(String reply_content) {
		this.reply_content = reply_content;
	}
	public String getReply_status() {
		return reply_status;
	}
	public void setReply_status(String reply_status) {
		this.reply_status = reply_status;
	}
	public Date getReply_create_date() {
		return reply_create_date;
	}
	public void setReply_create_date(Date reply_create_date) {
		this.reply_create_date = reply_create_date;
	}
	public String getBoard_seq() {
		return board_seq;
	}
	public void setBoard_seq(String board_seq) {
		this.board_seq = board_seq;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	@Override
	public String toString() {
		return "ReplyVo [reply_seq=" + reply_seq + ", reply_content=" + reply_content + ", reply_status=" + reply_status
				+ ", reply_create_date=" + reply_create_date + ", board_seq=" + board_seq + ", user_id=" + user_id
				+ "]";
	}
	
	
	
	

}
