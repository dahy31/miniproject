package a.b.c.com.login.vo;

public class TempPwVO {
	
	private String pnum;
	private String ptemppw;
	private String mid;
	private String insertdate;
	
	public TempPwVO(String pnum, String ptemppw, String mid, String insertdate) {
	
		this.pnum = pnum;
		this.ptemppw = ptemppw;
		this.mid = mid;
		this.insertdate = insertdate;
	}

	
	public TempPwVO() {
	
	}


	public String getPnum() {
		return pnum;
	}

	public String getPtemppw() {
		return ptemppw;
	}

	public String getMid() {
		return mid;
	}

	public String getInsertdate() {
		return insertdate;
	}

	public void setPnum(String pnum) {
		this.pnum = pnum;
	}

	public void setPtemppw(String ptemppw) {
		this.ptemppw = ptemppw;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public void setInsertdate(String insertdate) {
		this.insertdate = insertdate;
	}

	
}
