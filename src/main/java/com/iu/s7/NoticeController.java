package com.iu.s7;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.iu.board.BoardDTO;
import com.iu.notice.NoticeDAO;
import com.iu.notice.NoticeDTO;
import com.iu.notice.NoticeSerivce;
import com.iu.util.ListData;

@Controller
@RequestMapping(value="/notice/**")
public class NoticeController {
	@Inject
	private NoticeSerivce noticeSerivce;
	
	@RequestMapping(value="noticeUpdate", method=RequestMethod.GET)
	public String update(int num, Model model)throws Exception{
		BoardDTO boardDTO= noticeSerivce.selectOne(num);
		model.addAttribute("view", boardDTO);
		model.addAttribute("board", "notice");
		return "board/boardUpdate";
	}
	
	@RequestMapping(value="noticeDelete")
	public String delete(int num, HttpSession session)throws Exception{
		int result=noticeSerivce.delete(num, session);
		
		return "redirect:./noticeList";
		
	}
	
	@RequestMapping(value="noticeView")
	public ModelAndView selectOne(int num)throws Exception{
		 BoardDTO boardDTO=noticeSerivce.selectOne(num);
		 ModelAndView mv = new ModelAndView();
		 mv.addObject("view", boardDTO);
		 mv.addObject("board", "notice");
		 mv.setViewName("board/boardView");
		return mv;
	}
	
	@RequestMapping(value="noticeList")
	public ModelAndView selectList(ListData listData) throws Exception{
//		System.out.println("search : " +listData.getSearch());
//		System.out.println("kind : "+ listData.getKind());
//		System.out.println("curpage : "+ listData.getCurPage());
		
		ModelAndView mv = new ModelAndView();
		
		List<BoardDTO> ar = noticeSerivce.selectList(listData);
		
		mv.addObject("list", ar);
		mv.addObject("page",listData);
		mv.addObject("board", "notice");
		mv.setViewName("board/boardList");
		return mv;
	}
	
	@RequestMapping(value="noticeWrite", method=RequestMethod.GET)
	public String insert(Model model) throws Exception{
		model.addAttribute("board", "notice");
		return "board/boardWrite";
	}
	
	@RequestMapping(value="noticeWrite", method=RequestMethod.POST)
	public String insert(NoticeDTO noticeDTO,MultipartFile [] file,HttpSession session, RedirectAttributes re) throws Exception{
		int result=noticeSerivce.insert(noticeDTO, file, session);
		String message="Write Fail";
		if(result>0){
			message="Write Success";
		}
		
		re.addFlashAttribute("message", message);
		return "redirect:./noticeList";
	}
}
