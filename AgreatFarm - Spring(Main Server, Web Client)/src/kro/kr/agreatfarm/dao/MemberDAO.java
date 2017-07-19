package kro.kr.agreatfarm.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kro.kr.agreatfarm.vo.MemberVO;

@Repository
public class MemberDAO 
{
	@Autowired
	private SqlSessionTemplate ss;
	
	public MemberVO getUserInfo(String email)
	{
		MemberVO vo = ss.selectOne("getUserInfo", email);
		
		return vo;
	}
}
