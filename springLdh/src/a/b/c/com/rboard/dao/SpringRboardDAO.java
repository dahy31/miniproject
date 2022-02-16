package a.b.c.com.rboard.dao;

import java.util.List;

import a.b.c.com.rboard.vo.SpringRboardVO;

public interface SpringRboardDAO {
	
	public List<SpringRboardVO> rboardSelect(SpringRboardVO rbvo);
	public List<SpringRboardVO> rboardSelectAll(SpringRboardVO rbvo);
	public int rboardInsert(SpringRboardVO rbvo);
	public int rboardDelete(SpringRboardVO rbvo);

}
