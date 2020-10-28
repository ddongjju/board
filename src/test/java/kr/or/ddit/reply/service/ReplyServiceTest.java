package kr.or.ddit.reply.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import kr.or.ddit.reply.model.ReplyVo;

public class ReplyServiceTest {
	
	
	@Test
	public void ReplyListTest() {
		/***Given***/
		ReplyServiceI replyService = new ReplyService();
		int board_seq = 38;
		
		/***When***/
		List<ReplyVo> replyList = replyService.ReplyList(board_seq);
		/***Then***/
		assertEquals(3, replyList.size());
	}
	

}
