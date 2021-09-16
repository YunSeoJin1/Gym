package com.green.biz.mypage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.biz.dao.MypageDAO;
import com.green.biz.dto.MemberVO;
import com.green.biz.dto.MypageVO;
@Service("mypageService")
public class MypageServiceImpl implements MypageService {
	
	@Autowired
	private MypageDAO mDao;
	
	@Override
	public void insertWeight(MypageVO mpVo,MemberVO mVo) {
		
		mDao.insertWeight(mpVo,mVo);
		
	}

	@Override
	public MypageVO getWeightList(String id) {
		
		return mDao.getWeightList(id);
	}

}
