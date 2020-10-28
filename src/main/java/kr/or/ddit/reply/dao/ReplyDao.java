package kr.or.ddit.reply.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.reply.model.ReplyVo;

public class ReplyDao implements ReplyDaoI{

	@Override
	public int insertReply(ReplyVo vo) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int	cnt = sqlSession.insert("reply.insertReply", vo);
		
		if(cnt > 0 ) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		sqlSession.close();
		return cnt;
	}

	@Override
	public List<ReplyVo> ReplyList(int board_seq) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		List<ReplyVo> replyList = sqlSession.selectList("reply.ReplyList",board_seq);
		sqlSession.close();
		
		return replyList;
	}

	@Override
	public int deleteReply(int reply_seq) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int cnt = 0;
		try {
			cnt = sqlSession.update("reply.deleteReply", reply_seq);
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
