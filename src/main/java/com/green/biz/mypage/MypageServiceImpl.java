package com.green.biz.mypage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.biz.dao.MypageDAO;
import com.green.biz.dto.MemberVO;
import com.green.biz.dto.MypageVO;
import com.green.biz.dto.WeightRecordView;
@Service("mypageService")
public class MypageServiceImpl implements MypageService {
	
	@Autowired
	private MypageDAO mDao;
	
	@Override
	public void insertWeight(MypageVO mpVo,MemberVO mVo) {
		
		mDao.insertWeight(mpVo,mVo);
		
	}

	@Override
	public List<WeightRecordView> getWeightRecord() {
		
		return mDao.getWeightRecord();
	}

	
}
