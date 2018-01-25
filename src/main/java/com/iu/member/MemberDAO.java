package com.iu.member;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="MemberMapper.";
	
	public MemberDTO memberIdCheck(String id)throws Exception{
		return sqlSession.selectOne(NAMESPACE+"memberIdCheck", id);
	}
	
	public int memberJoin(MemberDTO memberDTO)throws Exception{
		return sqlSession.insert(NAMESPACE+"memberJoin", memberDTO);
	}
	
	public MemberDTO memberLogin(MemberDTO memberDTO)throws Exception{
		return sqlSession.selectOne(NAMESPACE+"memberLogin", memberDTO);
	}
	
	public int memberUpdate(MemberDTO memberDTO) throws Exception{
		return sqlSession.update(NAMESPACE+"memberUpdate", memberDTO);
	}
	
	public int memberDelete(MemberDTO memberDTO)throws Exception{
		return sqlSession.delete(NAMESPACE+"memberDelete", memberDTO);
	}
	

}
