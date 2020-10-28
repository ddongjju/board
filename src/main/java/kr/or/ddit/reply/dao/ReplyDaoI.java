package kr.or.ddit.reply.dao;

import java.util.List;

import kr.or.ddit.reply.model.ReplyVo;

public interface ReplyDaoI {
	int insertReply(ReplyVo vo);

	List<ReplyVo> ReplyList(int reply_seq);
	
	int deleteReply(int reply_seq);
}
