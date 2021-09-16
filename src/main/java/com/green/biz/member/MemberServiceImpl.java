package com.green.biz.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.biz.dao.MemberDAO;
import com.green.biz.dto.MemberVO;

@Service("memberService")
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO mDao;
	
	@Override
	public MemberVO getMember(String id) {
		
		return mDao.getMember(id);
	}

	@Override
	public int confirmID(String id) {
		
		return mDao.confirmID(id);
	}

	@Override
	public int loginID(MemberVO mVo) {
		
		return mDao.loginID(mVo);
	}

	@Override
	public void insertMember(MemberVO mVo) {
		mDao.insertMember(mVo);
	}

	@Override
	public MemberVO getMemberByNameAndEmail(MemberVO mVo) {
		return mDao.getMemberByNameAndEmail(mVo);
	}

	@Override
	public MemberVO findPassword(MemberVO mVo) {
		return mDao.findPassword(mVo);
	}

	@Override
	public void changePassword(MemberVO mVo) {
		mDao.changePassword(mVo);
	}

	@Override
	public void memberUpdate(MemberVO mVo) {
		mDao.memberUpdate(mVo);
	}

}
