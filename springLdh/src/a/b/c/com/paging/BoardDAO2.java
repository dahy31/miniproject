package a.b.c.com.paging;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BoardDAO2 {

	//페이지 이동 처리
	private int pageSize = 0;
	private int groupSize = 0;
	private int curPage = 0;
	private int totalCount = 0;
	
	//select list
	@SuppressWarnings({ "unchecked", "rawtypes"})
	public ArrayList selectList(BoardVO bvo) throws Exception{
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		ArrayList data_list = null;
		
		String sqls = null;
		
		StringBuffer sql = new StringBuffer();
		sql.append("\n  SELECT                                 ");
		sql.append("\n            *                            ");
		sql.append("\n  FROM(                                  ");
		sql.append("\n      SELECT                              ");
		sql.append("\n         A.mnum,        --글번호                         ");
		sql.append("\n         A.mtitle,      --제목                             ");
		sql.append("\n         A.mname,       --작성자                          ");
		sql.append("\n         A.memail,      --이메일                         ");
		sql.append("\n         A.marea,       --글내용                         ");
		sql.append("\n         A.mpass,       --비밀번호                       ");
		sql.append("\n         A.mref,        --REF             ");
		sql.append("\n         A.mstep,       --STEP            ");
		sql.append("\n         A.mdepth,      --DEPTH           ");
		sql.append("\n         TO_CHAR(A.mwriteday, 'YYYY-MM-DD') mwriteday, -- 작성일   ");
		sql.append("\n         A.mhits,       --조회수                          ");
		sql.append("\n         CEIL(ROW_NUMBER()  OVER(ORDER BY A.mnum)/?) pageSize,    ");
		sql.append("\n         COUNT(mnum)  OVER() AS TOTALCOUNT                      ");
		sql.append("\n     FROM                                  ");
		sql.append("\n        SE_BOARD A                         ");
		sql.append("\n     )                                     ");
		sql.append("\n   WHERE                                   ");
		sql.append("\n      pageSize = ?                          ");
		sqls = sql.toString();
		
		try {
			conn = ConnProperty.getConnection();
			pstmt = conn.prepareStatement(sqls);
			//pstmt.setInt(1, pageSize);
			//pstmt.setInt(2, curPage);
			pstmt.setInt(1, Integer.parseInt(bvo.getPageSize()));
			pstmt.setInt(2, Integer.parseInt(bvo.getCurPage()));
			System.out.println("sqls >>> : \n " + sqls);
			
			rsRs = pstmt.executeQuery();
			
			if(rsRs != null) {
				data_list = new ArrayList();
				
				while(rsRs.next()) {
					BoardVO _bvo = new BoardVO();
					
					_bvo.setMnum(rsRs.getString("mnum"));
					_bvo.setMtitle(rsRs.getString("mtitle"));
					_bvo.setMname(rsRs.getString("mname"));
					_bvo.setMemail(rsRs.getString("memail"));
					_bvo.setMarea(rsRs.getString("marea"));
					_bvo.setMpass(rsRs.getString("mpass"));
					_bvo.setMref(rsRs.getString("mref"));
					_bvo.setMstep(rsRs.getString("mstep"));
					_bvo.setMdepth(rsRs.getString("mdepth"));
					_bvo.setMwriteday(rsRs.getString("mwriteday"));
					_bvo.setMhits(rsRs.getString("mhits"));
					_bvo.setPageSize(rsRs.getString("pageSize"));
					_bvo.setTotalCount(rsRs.getString("totalCount"));
					//data.put("PAGENO", rsRs.getString("PAGENO"));
					//data.put("TOTALCOUNT", rsRs.getString("TOTALCOUNT"));
					
					data_list.add(_bvo);
				}
			}
			ConnProperty.conClose(conn, pstmt, rsRs);
		}
		catch(SQLException e) {
			System.out.println("selectDBList() : " + e);
		}
		finally {
			ConnProperty.conClose(conn, pstmt, rsRs);
		}
		return data_list;
	}
}
