package kr.or.ddit.member.service;

import java.util.Map;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.member.model.MemberVo;

public interface MemberServiceI {

	MemberVo getMember(String userId);
	
	Map<String, Object> selectPagemember(PageVo pageVo);
	
	

}
