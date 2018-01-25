package com.iu.s7;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.iu.member.MemberDTO;
import com.iu.member.MemberService;

@Controller
@RequestMapping(value="/member/**")
public class MemberController {
	@Inject
	private MemberService memberService;
	
	@RequestMapping(value="memberView")
	public void memberView()throws Exception{
	}
	
	@RequestMapping(value="memberIdCheck")
	public ModelAndView memberIdCheck(String id)throws Exception{
		MemberDTO memberDTO=memberService.memberIdCheck(id);
		int result=1;
		if(memberDTO != null){
			result=0;
		}
		ModelAndView mv = new ModelAndView();
		mv.addObject("result", result);
		mv.setViewName("common/fileResult");
		return mv;
	}
	
	@RequestMapping(value="memberJoin", method=RequestMethod.GET)
	public void memberJoin(){}
	@RequestMapping(value="memberJoin", method=RequestMethod.POST)
	public String memberJoin(MemberDTO memberDTO, MultipartFile file, HttpSession session)throws Exception{
		int result=memberService.memberJoin(memberDTO, file, session);
		return "redirect:../";
	}
	
	@RequestMapping(value="memberLogin", method=RequestMethod.GET)
	public void memberLogin(){}
	
	@RequestMapping(value="memberLogin", method=RequestMethod.POST)
	public ModelAndView memberLogin(MemberDTO memberDTO, HttpSession session)throws Exception{
		memberDTO=memberService.memberLogin(memberDTO);
		String message="LogIn Fail";
		String path ="./memberLogin";
		
		if(memberDTO != null){
			session.setAttribute("member", memberDTO);
			message="LogIn Success";
			path ="../";
		}
		ModelAndView mv = new ModelAndView();
		mv.addObject("message", message);
		mv.addObject("path", path);
		mv.setViewName("common/result");
		return mv;
	}
	
	@RequestMapping(value="memberUpdate", method=RequestMethod.GET)
	public void memberUpdate(){}
	
	@RequestMapping(value="memberUpdate", method=RequestMethod.POST)
	public void memberUpdate(MemberDTO memberDTO, MultipartFile file, HttpSession session){
		System.out.println("member");
	}
	
	@RequestMapping(value="memberDelete")
	public String memberDelete(HttpSession session, RedirectAttributes rd)throws Exception{
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		int result=memberService.memberDelete(memberDTO, session);
		String message ="Fail";
		
		if(result>0){
			message="Success";
			session.invalidate();
		}
		
		rd.addFlashAttribute("message", message);
		
		return "home";
		
	}
	
	@RequestMapping(value="memberLogOut")
	public String memberLogOut(HttpSession session)throws Exception{
		session.invalidate();
		return "redirect:../";
	}
	
	
	
	

}











