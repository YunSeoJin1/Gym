package com.green.biz.exercise;

import java.util.List;

import com.green.biz.dto.DumbellVO;
import com.green.biz.util.Criteria;

public interface DumbellService {
	
	public DumbellVO getDumbell(int deseq);
	
	//덤벨 운동리스트
	public List<DumbellVO> listDumbell(String dex_name);
	
	public List<DumbellVO> getDumbellListByKind(String dex_part);
	
	public void insertDumbell(DumbellVO vo);
	
	public void updateDumbell(DumbellVO vo);
	
	public void deleteDumbell(int deseq);
	
	public List<DumbellVO> getListWithPaging(Criteria criteria, String key);
	
	public int countExerciseList(String name);
	
	public List<DumbellVO> listDumbell(DumbellVO dex_name);
}