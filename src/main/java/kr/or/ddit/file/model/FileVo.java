package kr.or.ddit.file.model;

public class FileVo {
	private String file_name;
	private String file_realname;
	private int board_seq;
	private int file_seq;
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	public String getFile_realname() {
		return file_realname;
	}
	public void setFile_realname(String file_realname) {
		this.file_realname = file_realname;
	}
	public int getBoard_seq() {
		return board_seq;
	}
	public void setBoard_seq(int board_seq) {
		this.board_seq = board_seq;
	}
	public int getFile_seq() {
		return file_seq;
	}
	public void setFile_seq(int file_seq) {
		this.file_seq = file_seq;
	}
	@Override
	public String toString() {
		return "FileVo [file_name=" + file_name + ", file_realname=" + file_realname + ", board_seq=" + board_seq
				+ ", file_seq=" + file_seq + "]";
	}

	
	
	
	
}
