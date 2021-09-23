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
	
	//�쉶�썝 �젙蹂� �닔�젙 �럹�씠吏� �씠�룞
	@RequestMapping(value="info_form")
	public String infoView(MemberVO mVo, HttpSession session, Model model) {
		
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		
		System.out.println("�쉶�썝�젙蹂� �닔�젙");
		
		if (loginUser == null) {
			System.out.println("濡쒓렇�씤 �젙蹂� �뾾�쓬");
			return "mypage/notlogin";
		} else {
			System.out.println("�쉶�썝�젙蹂� �닔�젙 �럹�씠吏� �씠�룞");
			MemberVO member = memberService.getMember(loginUser.getId());
			model.addAttribute("memberVO",member);
			return "mypage/myInfo";
			}
	}
	
	
	//�쉶�썝�젙蹂� �닔�젙
	@RequestMapping(value="info", method=RequestMethod.POST)
	public String infoAction(@RequestParam(value="profile") MultipartFile uploadFile,
			MemberVO mVo, HttpSession session) {
	
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		
		System.out.println("�쉶�썝�젙蹂� �닔�젙");
	

		if (loginUser == null) {
			System.out.println("濡쒓렇�씤 �젙蹂� �뾾�쓬");
			return "mypage/notlogin";
		} else {
		String fileName = "";
		
			if (!uploadFile.isEmpty()) {	// �솕硫댁뿉�꽌 product_image �븘�뱶�뿉 �씠誘몄�媛� �엯�젰�맂 寃쎌슦
				fileName = uploadFile.getOriginalFilename();
				mVo.setProfile_img(fileName); // VO 媛앹껜�뿉 �씠誘몄��뙆�씪紐� ���옣
				
				// �씠誘몄� �뙆�씪�쓣 �뾽濡쒕뱶 �븯湲� �쐞�빐 �씠誘몄� ���옣 �떎�젣 寃쎈줈瑜� 援ы븳�떎.
				String image_path 
				= session.getServletContext().getRealPath("WEB-INF/resources/profile_img/");
				System.out.println("�씠誘몄� 寃쎈줈 : " + image_path);
				
				try {
					File file = new File(image_path+fileName);
					uploadFile.transferTo(file); // �긽�뭹�씠誘몄� ���옣 寃쎈줈濡� �씠�룞�떆�궡
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
				}	
			}
			
			memberService.memberUpdate(mVo);
			session.invalidate();
			System.out.println("�쉶�썝�젙蹂� �닔�젙 �꽦怨�");
			return "redirect:index";
		}
	}
	
	@RequestMapping(value="weight_record")
	public String recordView(MemberVO mVo, HttpSession session) {
	
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		
		System.out.println("泥댁쨷 痢≪젙 �럹�씠吏� �씠�룞");
	

		if (loginUser == null) {
			System.out.println("濡쒓렇�씤 �젙蹂� �뾾�쓬");
			return "mypage/notlogin";
		}else {
			return "mypage/weight_record";
		}
	}
	
	@RequestMapping(value="record", method=RequestMethod.GET)
	public String recordAction(MemberVO mVo, HttpSession session,MypageVO pVo) {
		
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		
		if (loginUser == null) {
			System.out.println("濡쒓렇�씤 �젙蹂� �뾾�쓬");
			return "mypage/notlogin";
		}else {
			
			System.out.println(pVo);
			
			mypageService.insertWeight(pVo,mVo);
			System.out.println("泥댁쨷 �엯�젰 �셿猷�!");
			System.out.println(mVo);
			return "mypage/record";
		}
		
		
		
	}
	
	
}

