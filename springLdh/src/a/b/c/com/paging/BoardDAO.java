package a.b.c.com.paging;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class BoardDAO {
	
	//페이지 이동처리
	private int pageSize = 0;
	private int groupSize = 0;
	private int curPage = 0;
	private int totalCount = 0;
	
	//select list
	@SuppressWarnings({ "unchecked", "rawtypes"})
	public ArrayList selectList(int pageSize, int curPage) throws Exception{
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		HashMap data = null;
		ArrayList data_list = new ArrayList();
		
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
			sql.append("\n         CEIL(ROW_NUMBER()  OVER(ORDER BY A.mnum)/?) PAGENO,    ");
			sql.append("\n         COUNT(mnum)  OVER() AS TOTALCOUNT                      ");
			sql.append("\n     FROM                                  ");
			sql.append("\n        SE_BOARD A                         ");
			sql.append("\n     )                                     ");
			sql.append("\n   WHERE                                   ");
			sql.append("\n       PAGENO = ?                          ");
			sqls = sql.toString();
			
			try {
				conn = ConnProperty.getConnection();
				
				pstmt = conn.prepareStatement(sqls);
				pstmt.setInt(1, pageSize);
				pstmt.setInt(2, curPage);
				System.out.println("sqls >>> : \n" + sqls);
				rsRs = pstmt.executeQuery();
				
				if(rsRs != null) {
					while(rsRs.next()) {
						data = new HashMap();
						
						data.put("mnum", rsRs.getString("mnum"));
						data.put("mtitle", rsRs.getString("mtitle"));
						data.put("mname", rsRs.getString("mname"));
						data.put("memail", rsRs.getString("memail"));
						data.put("marea", rsRs.getString("marea"));
						data.put("mpass", rsRs.getString("mpass"));
						data.put("mref", rsRs.getString("mref"));
						data.put("mstep", rsRs.getString("mstep"));
						data.put("mdepth", rsRs.getString("mdepth"));
						data.put("mwriteday", rsRs.getString("mwriteday"));
						data.put("mhits", rsRs.getString("mhits"));
						data.put("PAGENO", rsRs.getString("PAGENO"));
						data.put("TOTALCOUNT", rsRs.getString("TOTALCOUNT"));
						
						data_list.add(data);
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
