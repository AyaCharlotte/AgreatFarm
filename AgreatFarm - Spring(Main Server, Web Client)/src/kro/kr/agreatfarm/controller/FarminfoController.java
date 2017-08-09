package kro.kr.agreatfarm.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kro.kr.agreatfarm.dao.FarminfoDAO;
import kro.kr.agreatfarm.vo.FarminfoVO;

@Controller
public class FarminfoController {
	@Autowired
	private FarminfoDAO farminfoDao;
	
	@RequestMapping(value="/getFarminfo/{m_num}", method=RequestMethod.GET)
	public @ResponseBody ArrayList<Map<String, String>> getFarminfo(@PathVariable String m_num){
		List<FarminfoVO> list = farminfoDao.getFarminfo(Integer.parseInt(m_num));
		
		ArrayList<Map<String, String>> jsonList = new ArrayList<Map<String, String>>();
		Map<String, String> jsonObject = null;
		
		for(FarminfoVO vo : list){
			jsonObject = new HashMap<String, String>();
			jsonObject.put("f_num", String.valueOf(vo.getF_num()));
			jsonObject.put("f_url", String.valueOf(vo.getF_url()));
			jsonObject.put("f_cagename", String.valueOf(vo.getF_cagename()));
			jsonObject.put("f_type", String.valueOf(vo.getF_type()));
			jsonObject.put("f_count", String.valueOf(vo.getF_count()));
			jsonObject.put("f_location", String.valueOf(vo.getF_location()));
			jsonList.add(jsonObject);
		}
		
		return jsonList;
	}
}
