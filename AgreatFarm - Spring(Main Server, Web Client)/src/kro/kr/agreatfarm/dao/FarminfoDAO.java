package kro.kr.agreatfarm.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kro.kr.agreatfarm.vo.FarminfoVO;

@Repository
public class FarminfoDAO {
	@Autowired
	private SqlSessionTemplate ss;
	
	public void addFarminfo(FarminfoVO vo)
	{
		ss.insert("member.addMember", vo);
	}
	
	public String fixFarminfo(String m_email, String m_password)
	{
		String pwd = ss.selectOne("member.selectPwd", m_email.trim());
		return pwd;
	}
	
	public List<FarminfoVO> getFarminfo(int m_num)
	{
		List<FarminfoVO> list = ss.selectList("farminfo.getFarminfo", m_num);
		return list;
	}
}
