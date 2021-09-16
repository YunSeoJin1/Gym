package com.green.view.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.green.biz.admin.AdminService;
import com.green.biz.dto.AdminVO;
import com.green.biz.dto.DumbellVO;
import com.green.biz.dto.MemberVO;
import com.green.biz.exercise.DumbellService;
import com.green.biz.util.Criteria;
import com.green.biz.util.PageMaker;



@Controller
public class AdminController {

	@Autowired
	private AdminService as;
	@Autowired
	private DumbellService ds;
	
	// 로그인 화면이동
	@RequestMapping(value="admin")
	public String adminMain() {
		System.out.println("어드민 로그인 페이지 이동");
		return "admin/adminLogin";
	}
	
	// 로그인
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
			return "redirect:admin_index";
		} else {
			System.out.println("로그인 실패");
			return "admin/adminLogin";
		}
	}
	
	// 관리자 메인 화면 이동
	@RequestMapping(value="admin_index", method = RequestMethod.GET)
	public String adminIndex() {
		return "admin/adminIndex";
	}
	
	// 운동 상세보기
	@GetMapping(value="/admin_ex_view")
	public String exView(DumbellVO vo, HttpSession session, Model model) {
		DumbellVO ex = ds.getEx(vo.getDeseq());
		model.addAttribute("dumbellVO", ex);
		return "admin/exercise/exView";
	}
	
	// 분류별 운동 목록조회
	@GetMapping(value="/admin_ex_part")
	public String adminExPart(DumbellVO vo, Model model) {

		List<DumbellVO> exList = ds.getDumbellListByKind(vo.getDex_part());

		model.addAttribute("exList", exList);

		return "admin/exercise/exercisePartList";
	}
	
	// 관리자 운동 목록 조회
	@RequestMapping(value = "admin_exercise_list")
	public String dumbell_List(HttpSession session, Model model) {
			
		DumbellVO d = new DumbellVO();
			List<DumbellVO> dumbList = ds.getDumbellList(d.getDex_name());
			
			model.addAttribute("dumbellList", dumbList);
			
			return "admin/exercise/exerciseList";
	}
	
	// 운동 등록 화면 이동
	@RequestMapping(value = "admin_exercise_write_form")
	public String adminExWriteView(HttpSession session) {
		return "admin/exercise/exerciseWrite";
	}
	
	// 운동 등록 기능
	@RequestMapping(value="admin_exercise_write")
	public String adminExWrite(
			@RequestParam(value="exercise_image") MultipartFile uploadFile,
			DumbellVO vo, HttpSession session) {
	
		String fileName= "";
		if(!uploadFile.isEmpty()) {
			fileName = uploadFile.getOriginalFilename();
			vo.setDex_img(fileName);
			
		String image_path
		= session.getServletContext().getRealPath("WEB-INF/resources/images");
		
		
		try {
			File file = new File(image_path+fileName);
			uploadFile.transferTo(file);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
	}
		ds.insertDumbell(vo);
		return "admin/exercise/exerciseList";
}
	
	// 운동 수정 화면
	@RequestMapping(value="admin_exercise_update_form")
	public String adminPlaceUpdateView(DumbellVO vo, Model model) {
		DumbellVO ex = ds.getEx(vo.getDeseq());

		model.addAttribute("dumbellVO", ex);	

		return "admin/exercise/exerciseUpdate";
	}
	
	// 운동 수정 기능
	@RequestMapping(value="admin_exercise_update")
	public String adminExUpdate(
			@RequestParam(value="exercise_image") MultipartFile uploadFile,
			DumbellVO vo, HttpSession session) {
	
		String fileName= "";
		if(!uploadFile.isEmpty()) {
			fileName = uploadFile.getOriginalFilename();
			vo.setDex_img(fileName);
			
		String image_path
		= session.getServletContext().getRealPath("WEB-INF/resources/images");
		
		
		try {
			File file = new File(image_path+fileName);
			uploadFile.transferTo(file);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
	}
		ds.updateDumbell(vo);
		return "redirect:admin_ex_view?deseq="+vo.getDeseq();
}
	
	// 운동 삭제
	@RequestMapping(value = "admin_exercise_delete")
	public String adminExDelete(DumbellVO vo, Model model) {
	
		ds.deleteDumbell(vo.getDeseq());
		
		return "redirect:admin_exercise_list";
	}
}
	
