package com.green.biz.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.biz.dto.MemberVO;

@Repository
public class MemberDAO{
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	// 회원 상세정보 조회
		public MemberVO getMember(String id) {
			
			return mybatis.selectOne("MemberDAO.getMember", id);
		}
		
		// 회원ID 존재 확인
		public int confirmID(String id) {
			
			String pwd = mybatis.selectOne("MemberDAO.confirmID", id);
			
			if (pwd!=null) {
				return 1;
			} else {
				return -1;
			}
		}
		

		/*
		 * 회원 로그인
		 */
		public int loginID(MemberVO mVo) {
			int result = -1;
			String pwd = null;
			
			pwd = mybatis.selectOne("MemberDAO.confirmID", mVo.getId());
			
			// DB에서 조회한 password와 사용자가 입력한 password 비교
			if (pwd == null) {
				result = -1;
			} else if (pwd.equals(mVo.getPwd())) {	// id와 pwd가 일치하는 경우
				result = 1;
			} else {    // 비밀번호가 일치하지 않는 경우
				result = 0;
			}
			
			return result;	
		}
		
		// 회원 추가
		public void insertMember(MemberVO mVo) {
			
			mybatis.insert("MemberDAO.insertMember", mVo);
		}
		
		//이름과 이메일로 아이디 찾기
		public MemberVO getMemberByNameAndEmail(MemberVO mVo) {
			
			return mybatis.selectOne("MemberDAO.getMemberByNameAndEmail", mVo);
		}
		
		public MemberVO findPassword(MemberVO mVo) {
			
			return mybatis.selectOne("MemberDAO.findPassword", mVo);
		}
		
		public void changePassword(MemberVO mVo) {
			
			mybatis.update("MemberDAO.changePassword", mVo);
		}
		public void memberUpdate(MemberVO mVo) {
			mybatis.update("MemberDAO.memberUpdate", mVo);
		}
}
