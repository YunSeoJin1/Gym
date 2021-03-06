package com.green.biz.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.biz.dto.DumbellVO;
import com.green.biz.util.Criteria;

@Repository
public class DumbellDAO{
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	// 상세보기
	public DumbellVO getDumbell(int deseq) {
		return mybatis.selectOne("DumbellDAO.getDumbell", deseq);
	}
	
	//덤벨 리스트
	
	public List<DumbellVO> listDumbell(String dex_name){
		
		return mybatis.selectList("DumbellDAO.listDumbell",dex_name);
	}
	// 운동 분류
	public List<DumbellVO> getDumbellListByKind(String dex_part) {
		return mybatis.selectList("DumbellDAO.getDumbellListByKind", dex_part);
	}

	// 운동추가
	public void insertDumbell(DumbellVO vo) {
		mybatis.insert("DumbellDAO.insertDumbell", vo);
	}
	
	// 운동수정
	public void updateDumbell(DumbellVO vo) {
		mybatis.update("DumbellDAO.updateDumbell", vo);
	}
	
	// 운동삭제
	public void deleteDumbell(int deseq) {
		mybatis.delete("DumbellDAO.deleteDumbell", deseq);
	}
	
	//페이징
	public List<DumbellVO> getListWithPaging(Criteria criteria, String key) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("criteria", criteria);
		map.put("key", key);
		
		return mybatis.selectList("DumbellDAO.listWithPaging", map);
	}
	
	public int countExerciseList(String name) {
		
		return mybatis.selectOne("DumbellDAO.countExerciseList", name);
	}
	
	//검색 기능
	
	public List<DumbellVO> listDumbell(DumbellVO dex_name){
		
		return mybatis.selectList("DumbellDAO.listDumbell",dex_name);
		
	}
}
