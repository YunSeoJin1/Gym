package com.green.view.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.biz.dto.DumbellVO;
import com.green.biz.exercise.DumbellService;
import com.green.biz.util.Criteria;
import com.green.biz.util.PageMaker;

@Controller
public class ExerciseController {
	
	@Autowired
	private DumbellService es;
	
	// 운동 상세보기
	@GetMapping(value="/dumbell_view")
	public String exView(DumbellVO vo, HttpSession session, Model model) {
		DumbellVO dumbell = es.getDumbell(vo.getDeseq());
		model.addAttribute("dumbellVO", dumbell);
		return "exercise/dumbellView";
	}		
	
	// 분류별 운동 목록조회
	@GetMapping(value="/dumbell_part")
	public String dumbellKindList(DumbellVO vo, Model model) {

		List<DumbellVO> listDumbell = es.getDumbellListByKind(vo.getDex_part());

		model.addAttribute("dumbellKindList", listDumbell);

		return "exercise/dumbellKind";
	}
	
	// 운동 목록 조회
	@RequestMapping(value = "dumbell_list")
	public String dumbellList(
			@RequestParam(value="key", defaultValue="") String key,
			HttpSession session, Model model, DumbellVO vo, Criteria cri) {
			
		
			List<DumbellVO> dumbellList = es.getListWithPaging(cri, key);
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			
			int totalCount = es.countExerciseList(key);
			pageMaker.setTotalCount(totalCount);
			
			model.addAttribute("dumbellList", dumbellList);
			model.addAttribute("pageMaker",pageMaker);
			
			return "exercise/dumbellList";
	}
}
