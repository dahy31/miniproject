package a.b.c.com.login.service;

import java.util.List;

import a.b.c.com.login.vo.TempAuthNumVO;
import a.b.c.com.login.vo.TempPwVO;
import a.b.c.com.mem.vo.SpringMemberVO;

public interface SpringLoginService {
	
	public List<SpringMemberVO> loginCheck(SpringMemberVO mvo);
	
	//이메일로 ID 찾기
		//1.이메일 체크
		public List<SpringMemberVO> emailCheck(SpringMemberVO mvo);
		//2.인증번호 입력 : TEMP_AUTH_NUM 테이블
		public int tempAuthNumInsert(TempAuthNumVO tvo);
		//3.이메일 및 인증번호로 아이디 찾기
		public List<SpringMemberVO> emailIdFind(SpringMemberVO mvo);
		
		//아이디로 비밀번호 체크하기
		//1.아이디 체크
		public List<SpringMemberVO> pwIdCheck(SpringMemberVO mvo);
		//2.이메일 체크
		public List<SpringMemberVO> pwEmailCheck(SpringMemberVO mvo);
		//3.임시 비밀번호 입력: TEMP_PW 테이블
		public int tempPwInsert(TempPwVO tvo);
}
