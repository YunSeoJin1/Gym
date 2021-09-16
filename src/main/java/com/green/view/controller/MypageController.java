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
import org.springframework.web.multipart.MultipartFile;

import com.green.biz.dto.MemberVO;
import com.green.biz.dto.MypageVO;
import com.green.biz.member.MemberService;
import com.green.biz.mypage.MypageService;

@Controller
public class MypageController {
	
	@Autowired
	private MemberService memberService;
	@Autowired
	private MypageService mypageService;
	
	//회원 정보 수정 페이지 이동
	@RequestMapping(value="info_form")
	public String infoView(MemberVO mVo, HttpSession session, Model model) {
		
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		
		System.out.println("회원정보 수정");
		
		if (loginUser == null) {
			System.out.println("로그인 정보 없음");
			return "mypage/notlogin";
		} else {
			System.out.println("회원정보 수정 페이지 이동");
			MemberVO member = memberService.getMember(loginUser.getId());
			model.addAttribute("memberVO",member);
			return "mypage/myInfo";
			}
	}
	
	
	//회원정보 수정
	@RequestMapping(value="info", method=RequestMethod.POST)
	public String infoAction(@RequestParam(value="profile") MultipartFile uploadFile,
			MemberVO mVo, HttpSession session) {
	
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		
		System.out.println("회원정보 수정");
	

		if (loginUser == null) {
			System.out.println("로그인 정보 없음");
			return "mypage/notlogin";
		} else {
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
			
			memberService.memberUpdate(mVo);
			session.invalidate();
			System.out.println("회원정보 수정 성공");
			return "redirect:index";
		}
	}
	
	@RequestMapping(value="weight_record")
	public String recordView(MemberVO mVo, HttpSession session) {
	
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		
		System.out.println("체중 측정 페이지 이동");
	

		if (loginUser == null) {
			System.out.println("로그인 정보 없음");
			return "mypage/notlogin";
		}else {
			return "mypage/weight_record";
		}
	}
	
	@RequestMapping(value="record", method=RequestMethod.GET)
	public String recordAction(MemberVO mVo, HttpSession session,MypageVO pVo) {
		
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		
		if (loginUser == null) {
			System.out.println("로그인 정보 없음");
			return "mypage/notlogin";
		}else {
			
			System.out.println(pVo);
			
			mypageService.insertWeight(pVo,mVo);
			System.out.println("체중 입력 완료!");
			System.out.println(mVo);
			return "mypage/record";
		}
		
		
		
	}
	
	
}

