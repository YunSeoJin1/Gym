package com.green.view.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.biz.dto.DumbellVO;
import com.green.biz.dto.MemberVO;
import com.green.biz.exercise.DumbellService;
import com.green.biz.util.PageMaker;
import com.green.biz.util.Criteria;

@Controller
public class ExerciseController {
	
	@Autowired
	private DumbellService ds;
	
	@RequestMapping(value = "dumbell", method = RequestMethod.GET)
	public String dumbell_List(@RequestParam(value="key", defaultValue="") String key,
			MemberVO mVo, HttpSession session, Model model, Criteria criteria) {
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
				
		System.out.println("덤벨 리스트 페이지 이동");
		
		if (loginUser == null) {
			System.out.println("로그인 정보 없음");
			return "mypage/notlogin";
		} else {
			List<DumbellVO> dumbList = ds.getListWithPaging(criteria, key);
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(criteria); 
			
			int totalCount = ds.countExerciseList(key);
			pageMaker.setTotalCount(totalCount);
			
			model.addAttribute("dumbListSize", dumbList.size());
			model.addAttribute("dumbellList", dumbList);
			model.addAttribute("pageMaker", pageMaker);
			
			return "exercise/dumbell";
		}
	}
		
	
}
