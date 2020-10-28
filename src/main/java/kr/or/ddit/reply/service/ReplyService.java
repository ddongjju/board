package kr.or.ddit.reply.service;

import java.util.List;

import kr.or.ddit.reply.dao.ReplyDao;
import kr.or.ddit.reply.dao.ReplyDaoI;
import kr.or.ddit.reply.model.ReplyVo;

public class ReplyService implements ReplyServiceI{
	
	private static ReplyDaoI replyDao;
	
	public ReplyService() {
		replyDao = new ReplyDao();
	}

	@Override
	public int insertReply(ReplyVo vo) {
		return replyDao.insertReply(vo);
	}

	@Override
	public List<ReplyVo> ReplyList(int board_seq) {
		return replyDao.ReplyList(board_seq);
	}

	@Override
	public int deleteReply(int reply_seq) {
		return replyDao.deleteReply(reply_seq);
	}

}
