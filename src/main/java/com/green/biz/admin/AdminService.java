package com.green.biz.admin;


import com.green.biz.dto.AdminVO;

public interface AdminService {
		
		//관리자 정보 상세 조회
	
		AdminVO getAdmin(String id);
		
		// 관리자ID 존재 확인
		int admin_confirmID(String id);
		/*
		 * 관리자 로그인
		 */
		int admin_loginID(AdminVO aVo);
}
