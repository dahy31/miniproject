package a.b.c.com.mem.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import a.b.c.com.mem.dao.SpringMemberDAO;
import a.b.c.com.mem.vo.SpringMemberVO;

@Service
@Transactional
public class SpringMemberServiceImpl implements SpringMemberService {
	Logger logger = Logger.getLogger(SpringMemberServiceImpl.class);
	
	private SpringMemberDAO springMemberDAO;
	
	@Autowired(required=false)
	public SpringMemberServiceImpl(SpringMemberDAO springMemberDAO) {
		this.springMemberDAO = springMemberDAO;
	}

	@Override
	public List<SpringMemberVO> memberSelectAll(SpringMemberVO mvo) {
		// TODO Auto-generated method stub
		logger.info("SpringMemberServiceImpl memberSelectAll() 함수 진입 >>> : ");
		return springMemberDAO.memberSelectAll(mvo);
	}

	@Override
	public List<SpringMemberVO> memberSelect(SpringMemberVO mvo) {
		// TODO Auto-generated method stub
		logger.info("SpringMemberServiceImpl memberSelect() 함수 진입 >>> : ");
		return springMemberDAO.memberSelect(mvo);
	}

	@Override
	public int memberInsert(SpringMemberVO mvo) {
		// TODO Auto-generated method stub
		logger.info("SpringMemberServiceImpl memberInsert() 함수 진입 >>> : ");
		return springMemberDAO.memberInsert(mvo);
	}

	@Override
	public int memberUpdate(SpringMemberVO mvo) {
		// TODO Auto-generated method stub
		logger.info("SpringMemberServiceImpl memberupdate() 함수 진입 >>> : ");
		return springMemberDAO.memberUpdate(mvo);
	}

	@Override
	public int memberDelete(SpringMemberVO mvo) {
		// TODO Auto-generated method stub
		logger.info("SpringMemberServiceImpl memberDelete() 함수 진입 >>> : ");
		return springMemberDAO.memberDelete(mvo);
	}

	@Override
	public List<SpringMemberVO> memberIdCheck(SpringMemberVO mvo) {
		// TODO Auto-generated method stub
		logger.info("SpringMemberServiceImpl memberIdCheck() 함수 진입 >>> : ");
		return springMemberDAO.memberIdCheck(mvo);
	}

}
