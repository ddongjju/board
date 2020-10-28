package kr.or.ddit.member.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import kr.or.ddit.member.model.MemberVo;

public class MemberDaoTest {
	
	MemberDao memberDao;
	
	
	@Test
	public void getMemberTest() {
		/***Given***/
		memberDao = new MemberDao();
		String userId = "brown";
		
		MemberVo answerMemberVo = new MemberVo();
		answerMemberVo.setUser_id("brown");
		answerMemberVo.setUser_pass("brownPass");	

		/***When***/
		MemberVo memberVo = memberDao.getMember(userId);

		/***Then***/
		assertEquals("brown", memberVo.getUser_id());
		assertEquals("brownPass", memberVo.getUser_pass());
		
//		assertEquals(answerMemberVo, memberVo);
	}
	
	
	

	
}
