package com.green.biz.mypage;

import java.util.List;

import com.green.biz.dto.MemberVO;
import com.green.biz.dto.MypageVO;
import com.green.biz.dto.WeightRecordView;

public interface MypageService {

	//체중 측정
	void insertWeight(MypageVO mpVo,MemberVO mVo);

	public List<WeightRecordView> getWeightRecord();

}