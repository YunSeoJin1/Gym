package com.green.view.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.green.biz.dto.DumbellVO;
import com.green.biz.exercise.DumbellService;

@Controller
public class ExerciseController {
	
	@Autowired
	private DumbellService ds;
	
	// 운동 상세보기
	@GetMapping(value="/dumbell_view")
	public String exView(DumbellVO vo, HttpSession session, Model model) {
		DumbellVO dumbell = ds.getDumbell(vo.getDeseq());
		model.addAttribute("dumbellVO", dumbell);
		return "exercise/dumbellView";
	}		
	
	// 분류별 운동 목록조회
	@GetMapping(value="/dumbell_part")
	public String dumbellKindList(DumbellVO vo, Model model) {

		List<DumbellVO> listDumbell = ds.getDumbellListByKind(vo.getDex_part());

		model.addAttribute("dumbellKindList", listDumbell);

		return "exercise/dumbellKind";
	}
	
	// 운동 목록 조회
	@RequestMapping(value = "dumbell_list")
	public String dumbellList(HttpSession session, Model model, DumbellVO vo) {
			
			List<DumbellVO> dumbellList = ds.listDumbell(vo.getDex_name());
			
			model.addAttribute("dumbellList", dumbellList);
			
			return "exercise/dumbellList";
	}
}
