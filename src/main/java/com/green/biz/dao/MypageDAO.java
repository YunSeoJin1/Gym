package com.green.biz.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.biz.dto.MypageVO;

@Repository
public class MypageDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	//체중 측정
	public void insertWeight(MypageVO mVo) {
		mybatis.insert("MypageDAO.insertWeight",mVo);
	}
	//체중 측정 기록 보기
	public MypageVO getWeightList(String id) {
		
		return mybatis.selectOne("MypageDAO.getWeightList",id);
	}
}
