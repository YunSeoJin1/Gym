package com.green.biz.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.biz.dto.MemberVO;
import com.green.biz.dto.MypageVO;
import com.green.biz.dto.WeightRecordView;

@Repository
public class MypageDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	//체중 측정
	public void insertWeight(MypageVO mpVo, MemberVO mVo) {
		System.out.println("DAO : " + mpVo);
		
		
		mybatis.insert("MypageDAO.insertWeight", mpVo);
		mybatis.update("MypageDAO.updateWeight", mVo);
	}
	//체중 측정 기록 보기
	public List<WeightRecordView> getWeightRecord() {
		
		return mybatis.selectList("MypageDAO.getWeightRecord");
	}
}
