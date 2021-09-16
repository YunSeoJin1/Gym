package com.green.view.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.green.biz.admin.AdminService;
import com.green.biz.dto.AdminVO;



@Controller
public class AdminController {

	@Autowired
	private AdminService as;
	
	@RequestMapping(value="admin")
	public String adminMain() {
		System.out.println("어드민 로그인 페이지 이동");
		return "admin/adminLogin";
	}
	
	@RequestMapping(value="admin_login", method=RequestMethod.POST)
	public String adminLogin(AdminVO aVo, Model model) {
		System.out.println("로그인 처리");
		AdminVO AdminUser = null;
		System.out.println(aVo);
		int result = as.admin_loginID(aVo);
		System.out.println(result);
		if(result == 1) { // 사용자인증 성공
			AdminUser = as.getAdmin(aVo.getAdmin_id());
			model.addAttribute("AdminUser", AdminUser);
			System.out.println("로그인 성공");
			return "admin/adminIndex";
		} else {
			System.out.println("로그인 실패");
			return "admin/adminLogin";
		}
	}
}
