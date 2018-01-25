package com.iu.member;

import java.io.File;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.util.FileSaver;

@Service
public class MemberService {
	@Inject
	private MemberDAO memberDAO;
	
	public MemberDTO memberIdCheck(String id)throws Exception{
		return memberDAO.memberIdCheck(id);
	}
	
	public int memberJoin(MemberDTO memberDTO, MultipartFile file, HttpSession session)throws Exception{
		String filePath = session.getServletContext().getRealPath("resources/upload");
		System.out.println(filePath);
		File f = new File(filePath);
		if(!f.exists()){
			f.mkdirs();
		}
		FileSaver fs = new FileSaver();
		memberDTO.setFname(fs.saver(file, filePath));
		memberDTO.setOname(file.getOriginalFilename());
		return memberDAO.memberJoin(memberDTO);
	}
	
	public MemberDTO memberLogin(MemberDTO memberDTO)throws Exception{
		return memberDAO.memberLogin(memberDTO);		
	}
	
	public int memberUpdate(MemberDTO memberDTO)throws Exception{
		return memberDAO.memberUpdate(memberDTO);
	}
	
	public int memberDelete(MemberDTO memberDTO, HttpSession session)throws Exception{
		String filePath = session.getServletContext().getRealPath("resources/upload");
		File f = new File(filePath, memberDTO.getFname());
		f.delete();
		
		return memberDAO.memberDelete(memberDTO);
	}

}
