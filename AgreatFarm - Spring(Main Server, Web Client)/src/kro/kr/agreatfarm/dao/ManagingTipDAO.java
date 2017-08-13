package kro.kr.agreatfarm.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kro.kr.agreatfarm.vo.ManagingTipVO;

@Repository
public class ManagingTipDAO {
	@Autowired
	private SqlSessionTemplate ss;
	
	public List<ManagingTipVO> getBoardData(){
		List<ManagingTipVO> list = ss.selectList("managing.getBoardData");
		return list;
	}
	
	public ManagingTipVO readManagingTipContent(int mId){
		ManagingTipVO vo = ss.selectOne("managing.readManagingTipContent", mId);
		return vo;
	}
}
