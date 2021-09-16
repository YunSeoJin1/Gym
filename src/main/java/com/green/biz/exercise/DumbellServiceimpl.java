package com.green.biz.exercise;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.biz.dao.DumbellDAO;
import com.green.biz.dto.DumbellVO;
import com.green.biz.util.Criteria;

@Service("dumbellService")
public class DumbellServiceimpl implements DumbellService {
	
	@Autowired
	private DumbellDAO dDao;
	
	@Override
	public List<DumbellVO> getDumbellList(String dex_name) {
		
		return dDao.getDumbellList(dex_name);
	}

	
	@Override
	public int countExerciseList(String dex_name) {
		
		return dDao.countExerciseList(dex_name);
	}


	@Override
	public List<DumbellVO> getListWithPaging(Criteria criteria, String key) {

		return dDao.getListWithPaging(criteria, key);
	}



	
}
