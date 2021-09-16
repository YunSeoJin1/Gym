package com.green.view.controller;



import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

import com.green.biz.dto.MemberVO;
import com.green.biz.member.MemberService;

@Controller
@SessionAttributes("loginUser")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value = "login_form", method = RequestMethod.GET)
	public String login_form() {
		System.out.println("로그인 페이지 이동");
		return "member/login_form";
	}
	
	
	//로그인 처리
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginAction(MemberVO mVo,Model model) {
		System.out.println("로그인 처리");
		MemberVO loginUser = null;
		int result = memberService.loginID(mVo);
		if(result == 1) { // 사용자인증 성공
			loginUser = memberService.getMember(mVo.getId());
			model.addAttribute("loginUser", loginUser);
			System.out.println("로그인 성공");
			return "redirect:/index";
		} else {
			System.out.println("로그인 실패");
			return "member/login_fail";
		}
	}
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout(SessionStatus status) {
		System.out.println("로그아웃");
		status.setComplete();
		
		return "redirect:/index";
	}
	@RequestMapping(value="/contract", method=RequestMethod.GET)
	   public String contractView() {

		System.out.println("약관 동의 페이지 이동");
		return "member/contract";
	}
	
	
	@RequestMapping(value="/join_form", method=RequestMethod.POST)
	   public String joinView() {
		
		System.out.println("회원가입 페이지 이동");
		return "member/join";
	}
	
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
		public String joinAction(@RequestParam(value="profile") MultipartFile uploadFile,
				MemberVO mVo, HttpSession session) {
		System.out.println("회원가입 처리");

		String fileName = "";
		
		if (!uploadFile.isEmpty()) {	// 화면에서 product_image 필드에 이미지가 입력된 경우
			fileName = uploadFile.getOriginalFilename();
			mVo.setProfile_img(fileName); // VO 객체에 이미지파일명 저장
			
			// 이미지 파일을 업로드 하기 위해 이미지 저장 실제 경로를 구한다.
			String image_path 
			= session.getServletContext().getRealPath("WEB-INF/resources/profile_img/");
			System.out.println("이미지 경로 : " + image_path);
			
			try {
				File file = new File(image_path+fileName);
				uploadFile.transferTo(file); // 상품이미지 저장 경로로 이동시킴
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}	
		}
		
		
		memberService.insertMember(mVo);
		
		
		return "redirect:index";
	}
	
	
	@RequestMapping(value="/id_check_form", method = RequestMethod.GET)
	   public String idCheckView(@RequestParam(value="id",defaultValue="",required=true)
	                                 String id, Model model) {
		System.out.println("ID 중복 체크");
		model.addAttribute("id", id);
		return "member/idcheck";
	}
	@RequestMapping(value="/id_check_form", method=RequestMethod.POST)
	   public String idCheckAction(@RequestParam(value="id",defaultValue="",required=true)
	                        String id, Model model) {
		System.out.println("중복체크 처리");
		MemberVO user =memberService.getMember(id);
		if(user != null) {
			model.addAttribute("message", 1);
		}
		else {
			model.addAttribute("message", -1);
		}
		model.addAttribute("id", id);
		return "member/idcheck";
	}
	
	@RequestMapping(value="/id_check_confirmed", method=RequestMethod.GET)
	   public String idCheckConfirm(MemberVO mv,Model model) {
		System.out.println("사용자 ID 중복체크후 사용");
		model.addAttribute("id", mv.getId());
		model.addAttribute("reid", mv.getId());
		
		return "member/join";
	}
	//���̵� ã��
	 @RequestMapping(value = "/find_id_form", method = RequestMethod.GET)
	 public String findIdView() {
		 return "member/findid";
	 }	
	
	 @RequestMapping(value = "/find_id", method = RequestMethod.GET)
	 public String findIdAction(MemberVO mVo, Model model) {
		 MemberVO member = memberService.getMemberByNameAndEmail(mVo);
		 if(member != null) {  // 사용자 아이디가 존재한다면
			 model.addAttribute("message", "1");
			 model.addAttribute("id", member.getId());
		 } else {
			 model.addAttribute("message", "-1");
		 }
		 return "member/findResult";
	 }
	 @RequestMapping(value = "/find_password", method = RequestMethod.GET)
	 public String findPassword(MemberVO mVo, Model model) {
		 System.out.println("비밀번호 찾기");
		 MemberVO member = memberService.findPassword(mVo);
		 
		 if(member != null) { // 사용자 비밀번호가 존재한다면
			 model.addAttribute("message", "1");
			 model.addAttribute("id", member.getId());
		 } else {
			 model.addAttribute("message", "-1");
		 }
		 return "member/findPwdResult";
	 }
	 
	 @RequestMapping(value = "/find_pwd_form", method = RequestMethod.GET)
	 public String findPwdView() {
		 return "member/findpwd";
	 }	
	 
	 @RequestMapping(value = "/change_password", method = RequestMethod.POST)
	 public String changePassword(MemberVO mv, Model model) {
		 memberService.changePassword(mv);
		 return "member/close";
		 
	 }
	 
	@RequestMapping(value = "foam_roller", method = RequestMethod.GET)
	public String foam_roller() {
		
		return "stretching/foam_roller";
	}
	@RequestMapping(value = "body_stretching", method = RequestMethod.GET)
	public String foam_roller2() {
		
		return "stretching/body_stretching";
	}
	
}
