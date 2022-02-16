package a.b.c.com.rboard.service;

import java.util.List;

import a.b.c.com.rboard.vo.SpringRboardVO;

public interface SpringRboardService {
	
	public List<SpringRboardVO> rboardSelect(SpringRboardVO rbvo);
	public List<SpringRboardVO> rboardSelectAll(SpringRboardVO rbvo);
	public int rboardInsert(SpringRboardVO rbvo);
	public int rboardDelete(SpringRboardVO rbvo);

}
