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
import com.green.biz.exercise.DumbellService;



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
	@GetMapping(value="/admin_dumbell_view")
	public String exView(DumbellVO vo, HttpSession session, Model model) {
		DumbellVO dumbell = ds.getDumbell(vo.getDeseq());
		model.addAttribute("dumbellVO", dumbell);
		return "admin/exercise/dumbellView";
	}
	
	// 분류별 운동 목록조회
	@GetMapping(value="/admin_dumbell_part")
	public String dumbellKindList(DumbellVO vo, Model model) {

		List<DumbellVO> listDumbell = ds.getDumbellListByKind(vo.getDex_part());

		model.addAttribute("dumbellKindList", listDumbell);

		return "admin/exercise/dumbellKind";
	}
	
	// 운동 목록 조회
	@RequestMapping(value = "admin_dumbell_list")
	public String dumbellList(HttpSession session, Model model, DumbellVO vo) {
			
			List<DumbellVO> dumbellList = ds.listDumbell(vo.getDex_name());
			
			model.addAttribute("dumbellList", dumbellList);
			
			return "admin/exercise/dumbellList";
	}
	
	// 운동 등록 화면 이동
	@RequestMapping(value = "admin_dumbell_write_form")
	public String adminExWriteView(HttpSession session) {
		return "admin/exercise/dumbellWrite";
	}
	
	// 운동 등록 기능
	@RequestMapping(value="admin_dumbell_write")
	public String adminExWrite(
			@RequestParam(value="dumbell_image",required = false) MultipartFile uploadFile,
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
		return "redirect:admin_dumbell_list";
}
	
	// 운동 수정 화면
	@RequestMapping(value="admin_dumbell_update_form")
	public String adminPlaceUpdateView(DumbellVO vo, Model model) {
		DumbellVO dumbell = ds.getDumbell(vo.getDeseq());

		model.addAttribute("dumbellVO", dumbell);	

		return "admin/exercise/dumbellUpdate";
	}
	
	// 운동 수정 기능
	@RequestMapping(value="admin_dumbell_update")
	public String adminDumbellUpdate(
			@RequestParam(value="dumbell_image",required = false) MultipartFile uploadFile,
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
		return "redirect:admin_dumbell_view?deseq="+vo.getDeseq();
}
	
	// 운동 삭제
	@RequestMapping(value = "admin_dumbell_delete")
	public String adminDumbellDelete(DumbellVO vo, Model model) {
	
		ds.deleteDumbell(vo.getDeseq());
		
		return "redirect:admin_dumbell_list";
	}
}
	
