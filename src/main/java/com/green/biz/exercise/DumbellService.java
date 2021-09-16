package com.green.biz.exercise;

import java.util.List;

import com.green.biz.dto.DumbellVO;
import com.green.biz.util.Criteria;

public interface DumbellService {
	
	//덤벨 운동리스트
	public List<DumbellVO> getDumbellList(String dex_name);
	
	public int countExerciseList(String name);
	
	public List<DumbellVO> getListWithPaging(Criteria criteria, String key);
}