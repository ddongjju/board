package kr.or.ddit.reply.service;

import java.util.List;

import kr.or.ddit.reply.model.ReplyVo;

public interface ReplyServiceI {
	
	int insertReply(ReplyVo vo);

	List<ReplyVo> ReplyList(int board_seq);
	
	int deleteReply(int reply_seq);
	

}
