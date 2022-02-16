package a.b.c.com.paging;

import java.sql.Connection;
import java.sql.Statement;

public class InsertData {
	
	public void insertData() throws Exception{
		
		Connection con = ConnProperty.getConnection();
		Statement stmt = con.createStatement();
		String sqls = null;
		
		//for(long i=0; i<1000000; i++)
		for (long i =0; i<200; i++) {
			sqls = "INSERT INTO SE_BOARD VALUES ( "
									+ "B_SEQ.NEXTVAL, "
									+ "'" + i + "', "
									+ "'" + i + "', "
									+ "'" + i + "', "
									+ "'" + i + "', "
									+ "'" + i + "', "
									+ " 1, 1, 1, DEFAULT, 1)";
			
			int nCount = stmt.executeUpdate(sqls);
			//if (nCount % 1000 == 0) con,commit();
			if(nCount % 100 == 0) con.commit();
		}
		
		con.commit();
		stmt.close();stmt = null;
		con.close();con = null;
	}
	
	public static void main(String args[]) throws Exception{
		new InsertData().insertData();
	}

}
