package a.b.c.com.mem.dao;

import java.util.List;

import a.b.c.com.mem.vo.SpringMemberVO;

public interface SpringMemberDAO {
	
	public List<SpringMemberVO> memberSelectAll(SpringMemberVO mvo);
	public List<SpringMemberVO> memberSelect(SpringMemberVO mvo);
	public int memberInsert(SpringMemberVO mvo);
	public int memberUpdate(SpringMemberVO mvo);
	public int memberDelete(SpringMemberVO mvo);
	
	//아이디 중복 체크
	public List<SpringMemberVO> memberIdCheck(SpringMemberVO mvo);

}
