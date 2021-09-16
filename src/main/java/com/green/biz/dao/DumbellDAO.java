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
	
	//덤벨 리스트
	public List<DumbellVO> getDumbellList(String dex_name){
		
		return mybatis.selectList("DumbellDAO.dumbellList",dex_name);
	}
	
	
	//페이징 처리
	public List<DumbellVO> getListWithPaging(Criteria criteria, String key) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("criteria", criteria);
		map.put("key", key);
		
		return mybatis.selectList("DumbellDAO.listWithPaging", map);
	}
	//리스트 갯수
	public int countExerciseList(String dex_name) {
		
		return mybatis.selectOne("DumbellDAO.countExerciseList", dex_name);
	}
	
	
}
