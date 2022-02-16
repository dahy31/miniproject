package a.b.c.com.rboard.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import a.b.c.com.rboard.vo.SpringRboardVO;

@Repository
public class SpringRboardDAOImpl implements SpringRboardDAO {
	Logger logger = Logger.getLogger(SpringRboardDAOImpl.class);
	
	@Autowired(required=false)
	private SqlSession sqlSession;

	@Override
	public List<SpringRboardVO> rboardSelect(SpringRboardVO rbvo) {
		// TODO Auto-generated method stub
		logger.info("SpringRboardDAOImpl rboardSelect >>> : ");
		return sqlSession.selectList("rboardSelect", rbvo);
	}

	@Override
	public List<SpringRboardVO> rboardSelectAll(SpringRboardVO rbvo) {
		// TODO Auto-generated method stub
		logger.info("SpringRboardDAOImpl rboardSelectAll >>> : ");
		return sqlSession.selectList("rboardSelectAll", rbvo);
	}

	@Override
	public int rboardInsert(SpringRboardVO rbvo) {
		// TODO Auto-generated method stub
		logger.info("SpringRboardDAOImpl rboardInsert >>> : ");
		return (Integer)sqlSession.insert("rboardInsert", rbvo);
	}

	@Override
	public int rboardDelete(SpringRboardVO rbvo) {
		// TODO Auto-generated method stub
		logger.info("SpringRboardDAOImpl rboardDelete >>> : ");
		return (Integer)sqlSession.update("rboardDelete", rbvo);
	}

}
