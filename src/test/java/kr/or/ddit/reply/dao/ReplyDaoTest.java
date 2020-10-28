package kr.or.ddit.reply.dao;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.reply.model.ReplyVo;

public class ReplyDaoTest {
	
	ReplyDao replydao ;
	
//
//	@Before
//	public void deleteReplyTest() {
//		replydao = new ReplyDao();
//		
//		int reply_seq = 17;
//		
//		replydao.deleteReply(reply_seq);
//	}
//	
//	
//	@Test
//	public void insertReplyTest() {
//		/***Given***/
//		replydao = new ReplyDao();
//		Date now = new Date();
//		ReplyVo vo = new ReplyVo(17,"댓글","Y",now,38,"brown");
//		/***When***/
//		int cnt = replydao.insertReply(vo);
//		/***Then***/
//		assertEquals(1, cnt);
//	}
	
	@Test
	public void ReplyListTest() {
		/***Given***/
		replydao = new ReplyDao();
		int board_seq = 38;
		
		/***When***/
		List<ReplyVo> replyList = replydao.ReplyList(board_seq);
		/***Then***/
		assertEquals(3, replyList.size());
	}

}
