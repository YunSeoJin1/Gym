package com.green.biz.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.biz.dto.AdminVO;


@Repository
public class AdminDAO {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public AdminVO getAdmin(String id) {
		
		return mybatis.selectOne("AdminDAO.getAdmin", id);
	}
	
	public int admin_confirmID(String id) {
		
		String pwd = mybatis.selectOne("AdminDAO.admin_confirmID", id);
		
		if (pwd!=null) {
			return 1;
		} else {
			return -1;
		}
	}
	

	/*
	 * 회원 로그인
	 */
	public int admin_loginID(AdminVO aVo) {
		int result = -1;
		String pwd = null;
		
		pwd = mybatis.selectOne("AdminDAO.admin_confirmID", aVo.getAdmin_id());
		
		// DB에서 조회한 password와 사용자가 입력한 password 비교
		if (pwd == null) {
			result = -1;
		} else if (pwd.equals(aVo.getAdmin_pwd())) {	// id와 pwd가 일치하는 경우
			result = 1;
		} else {    // 비밀번호가 일치하지 않는 경우
			result = 0;
		}
		
		return result;	
	}
}
