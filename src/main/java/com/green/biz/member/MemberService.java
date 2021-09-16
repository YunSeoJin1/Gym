package com.green.biz.member;

import com.green.biz.dto.MemberVO;

public interface MemberService {

	// 회원 상세정보 조회
	MemberVO getMember(String id);

	// 회원ID 존재 확인
	int confirmID(String id);
	/*
	 * 회원 로그인
	 */
	int loginID(MemberVO mVo);

	// 회원 추가
	void insertMember(MemberVO mVo);

	// 사용자이름과 이메일을 조건으로 사용자정보 조회
	public MemberVO getMemberByNameAndEmail(MemberVO mVo);
	
	// 사용자 아이디와 이름, 이메일을 조건으로 사용자정보 조회
	public MemberVO findPassword(MemberVO mVo);
		
		// 사용자 암호 변경
	public void changePassword(MemberVO mVo);
	
	//회원 정보 변경
	public void memberUpdate(MemberVO mVo);
}