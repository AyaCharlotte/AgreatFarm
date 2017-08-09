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
import org.springframework.web.servlet.ModelAndView;

import kro.kr.agreatfarm.dao.ManagingTipDAO;
import kro.kr.agreatfarm.vo.ManagingTipVO;

@Controller
public class ManagingTipController {
	
	@Autowired
	private ManagingTipDAO managingTipDao;
	
	@RequestMapping(value="/managing", method=RequestMethod.GET)
	public ModelAndView managing(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("managing");
		return mav;
	}
	
	@RequestMapping(value="/managing/{mId}", method=RequestMethod.GET)
	public ModelAndView readManagingTip(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("readManagingTip");
		return mav;
	}
	
	@RequestMapping(value="/readManagingTipContent/{mId}", method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> readManagingTipContent(@PathVariable int mId){
		ManagingTipVO vo = managingTipDao.readManagingTipContent(mId);
		Map<String, Object> jsonObject = null;
		
		if(vo != null){
			jsonObject = new HashMap<String, Object>();
			jsonObject.put("mId", vo.getmId());
			jsonObject.put("mUsername", vo.getmUsername());
			jsonObject.put("mTitle", vo.getmTitle());
			jsonObject.put("mContent", vo.getmContent());
			jsonObject.put("mDate", vo.getmDate());
			jsonObject.put("mHit", vo.getmHit());
			jsonObject.put("mCommentCount", vo.getmCommentCount());
		}
		
		return jsonObject;
	}
	
	
	
	
	@RequestMapping(value="/getManagingTipBoardData", method=RequestMethod.GET)
	public @ResponseBody ArrayList<Map<String, Object>> getBoardData(){
		List<ManagingTipVO> list = managingTipDao.getBoardData();
		
		ArrayList<Map<String, Object>> jsonList = new ArrayList<Map<String, Object>>();
		Map<String, Object> jsonObject = null;
		
		for(ManagingTipVO vo : list){
			jsonObject = new HashMap<String, Object>();
			jsonObject.put("mId", vo.getmId());
			jsonObject.put("mUsername", vo.getmUsername());
			jsonObject.put("mTitle", vo.getmTitle());
			jsonObject.put("mDate", vo.getmDate());
			jsonObject.put("mHit", vo.getmHit());
			jsonObject.put("mCommentCount", vo.getmCommentCount());
			jsonList.add(jsonObject);
		}
		
		return jsonList;
	}
}
