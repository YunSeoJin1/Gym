package com.green.biz.mypage;

import com.green.biz.dto.MypageVO;

public interface MypageService {

	//체중 측정
	void insertWeight(MypageVO mVo);

	MypageVO getWeightList(String id);

}