package com.green.biz.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.biz.dao.AdminDAO;
import com.green.biz.dto.AdminVO;
@Service("adminService")
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminDAO aDao;

	
	@Override
	public AdminVO getAdmin(String Admin_id) {
		return aDao.getAdmin(Admin_id);
	}
	
	@Override
	public int admin_confirmID(String Admin_id) {
		
		return aDao.admin_confirmID(Admin_id);
	}

	@Override
	public int admin_loginID(AdminVO aVo) {
		
		return aDao.admin_loginID(aVo);
	}

	
	
}
