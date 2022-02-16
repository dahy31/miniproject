package a.b.c.com.login.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import a.b.c.com.login.vo.TempAuthNumVO;
import a.b.c.com.login.vo.TempPwVO;
import a.b.c.com.mem.vo.SpringMemberVO;

@Repository
public class SpringLoginDAOImpl implements SpringLoginDAO {
	Logger logger = Logger.getLogger(SpringLoginDAOImpl.class);
	
	@Autowired(required=false)
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<SpringMemberVO> loginCheck(SpringMemberVO mvo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("loginCheck",mvo);
	}

	@Override
	public List<SpringMemberVO> emailCheck(SpringMemberVO mvo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("emailCheck",mvo);
	}

	@Override
	public int tempAuthNumInsert(TempAuthNumVO tvo) {
		// TODO Auto-generated method stub
		return (Integer)sqlSession.insert("tempAuthNumInsert", tvo);
	}

	@Override
	public List<SpringMemberVO> emailIdFind(SpringMemberVO mvo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("emailIdFind",mvo);
	}

	@Override
	public List<SpringMemberVO> pwIdCheck(SpringMemberVO mvo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("pwIdCheck",mvo);
	}

	@Override
	public List<SpringMemberVO> pwEmailCheck(SpringMemberVO mvo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("pwEmailCheck",mvo);
	}

	@Override
	public int tempPwInsert(TempPwVO tvo) {
		// TODO Auto-generated method stub
		return (Integer)sqlSession.insert("tempPwInsert",tvo);
	}

}
