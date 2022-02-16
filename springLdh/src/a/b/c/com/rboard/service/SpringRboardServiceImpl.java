package a.b.c.com.rboard.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import a.b.c.com.rboard.dao.SpringRboardDAO;
import a.b.c.com.rboard.vo.SpringRboardVO;

@Service
@Transactional
public class SpringRboardServiceImpl implements SpringRboardService {
	Logger logger = Logger.getLogger(SpringRboardServiceImpl.class);
	
	@Autowired(required=false)
	private SpringRboardDAO springRboardDAO;
	
	public SpringRboardServiceImpl(SpringRboardDAO springRboardDAO) {
		this.springRboardDAO = springRboardDAO;
	}
	
	@Override
	public List<SpringRboardVO> rboardSelect(SpringRboardVO rbvo) {
		// TODO Auto-generated method stub
		logger.info("SpringRboardServiceImpl rboardSelect >>> : ");
		
		return springRboardDAO.rboardSelect(rbvo);
	}

	@Override
	public List<SpringRboardVO> rboardSelectAll(SpringRboardVO rbvo) {
		// TODO Auto-generated method stub
		logger.info("SpringRboardServiceImpl rboardSelectAll >>> : ");
		return springRboardDAO.rboardSelectAll(rbvo);
	}

	@Override
	public int rboardInsert(SpringRboardVO rbvo) {
		// TODO Auto-generated method stub
		logger.info("SpringRboardServiceImpl rboardInsert >>> : ");
		return springRboardDAO.rboardInsert(rbvo);
	}

	@Override
	public int rboardDelete(SpringRboardVO rbvo) {
		// TODO Auto-generated method stub
		logger.info("SpringRboardServiceImpl rboardDelete >>> : ");
		return springRboardDAO.rboardDelete(rbvo);
	}

}
