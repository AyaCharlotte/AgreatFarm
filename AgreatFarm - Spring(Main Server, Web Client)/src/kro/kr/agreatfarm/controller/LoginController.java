package kro.kr.agreatfarm.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kro.kr.agreatfarm.dao.MemberDAO;
import kro.kr.agreatfarm.vo.MemberVO;

@Controller
public class LoginController 
{
	@Autowired
	private MemberDAO memberDAO;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView login()
	{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login");
		
		return mav;
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ModelAndView loginValidityCheck(HttpServletRequest req, @RequestParam String email, @RequestParam String password)
	{
		ModelAndView mav = new ModelAndView();
		MemberVO vo = memberDAO.getUserInfo(email);
		
		if(vo != null)
		{
			if(vo.getM_password().equals(password))
			{
				mav.setViewName("main");
			}
			else mav.setViewName("login");
		}
		else mav.setViewName("login");
		
		return mav;
	}
}
