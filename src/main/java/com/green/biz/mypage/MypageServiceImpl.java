package com.green.biz.mypage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.biz.dao.MypageDAO;
import com.green.biz.dto.MypageVO;
@Service("mypageService")
public class MypageServiceImpl implements MypageService {
	
	@Autowired
	private MypageDAO myDao;
	
	@Override
	public void insertWeight(MypageVO mVo) {
		
		myDao.insertWeight(mVo);
	}

	@Override
	public MypageVO getWeightList(String id) {
		
		return myDao.getWeightList(id);
	}

}
