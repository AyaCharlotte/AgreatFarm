package kro.kr.agreatfarm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

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
	public ModelAndView checkLoginInfo(HttpServletRequest req, @RequestParam String username, @RequestParam String password)
	{
		MemberVO vo = memberDAO.getUserInfo(username);
		HttpSession httpSession = null;
		String url = "/AgreatFarm/login";
		if(vo != null){
			if(vo.getM_password().equals(password)){
				httpSession = req.getSession();
				httpSession.setAttribute("m_num", String.valueOf(vo.getM_num()));
				httpSession.setAttribute("m_email", vo.getM_email());
				httpSession.setAttribute("m_nickname", vo.getM_nickname());
				httpSession.setAttribute("m_farmer", String.valueOf(vo.isM_farmer()));
				url = "/AgreatFarm/main";
			}
		}
		
		RedirectView redirectView = new RedirectView(url);
		ModelAndView mav = new ModelAndView(redirectView);
		return mav;
	}
}
