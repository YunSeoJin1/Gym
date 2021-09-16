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


	@Override
	public void insertDumbell(DumbellVO vo) {
		dDao.insertDumbell(vo);
	}


	@Override
	public void updateDumbell(DumbellVO vo) {
		dDao.updateDumbell(vo);
	}


	@Override
	public void deleteDumbell(int deseq) {
		dDao.deleteDumbell(deseq);
	}


	@Override
	public List<DumbellVO> getDumbellListByKind(String dex_part) {
		return dDao.getDumbellListByKind(dex_part);
	}


	@Override
	public DumbellVO getEx(int deseq) {
		return dDao.getEx(deseq);
	}



	
}
