package a.b.c.com.paging;

public class BoardVO {
	
	private String mnum;
	private String mtitle;
	private String mname;
	private String memail;
	private String marea;
	private String mpass;
	private String mref;
	private String mstep;
	private String mdepth;
	private String mwriteday;
	private String mhits;
	
	private String pageSize;
	private String groupSize;
	private String curPage;
	private String totalCount;

	public BoardVO() {
		
	}

	public BoardVO(String mnum,      String mtitle,  String mname,
				   String memail,    String marea,   String mpass, 
				   String mref,      String mstep,   String mdepth, 
				   String mwriteday, String mhits,   String pageSize, 
				   String groupSize, String curPage, String totalCount) {
		
		this.mnum = mnum;
		this.mtitle = mtitle;
		this.mname = mname;
		this.memail = memail;
		this.marea = marea;
		this.mpass = mpass;
		this.mref = mref;
		this.mstep = mstep;
		this.mdepth = mdepth;
		this.mwriteday = mwriteday;
		this.mhits = mhits;
		this.pageSize = pageSize;
		this.groupSize = groupSize;
		this.curPage = curPage;
		this.totalCount = totalCount;
	}
	
	//getter함수
	public String getMnum() {
		return mnum;
	}

	public String getMtitle() {
		return mtitle;
	}

	public String getMname() {
		return mname;
	}

	public String getMemail() {
		return memail;
	}

	public String getMarea() {
		return marea;
	}

	//setter함수
	public String getMpass() {
		return mpass;
	}

	public String getMref() {
		return mref;
	}

	public String getMstep() {
		return mstep;
	}

	public String getMdepth() {
		return mdepth;
	}

	public String getMwriteday() {
		return mwriteday;
	}

	public String getMhits() {
		return mhits;
	}

	public String getPageSize() {
		return pageSize;
	}

	public String getGroupSize() {
		return groupSize;
	}

	public String getCurPage() {
		return curPage;
	}

	public String getTotalCount() {
		return totalCount;
	}

	public void setMnum(String mnum) {
		this.mnum = mnum;
	}

	public void setMtitle(String mtitle) {
		this.mtitle = mtitle;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public void setMemail(String memail) {
		this.memail = memail;
	}

	public void setMarea(String marea) {
		this.marea = marea;
	}

	public void setMpass(String mpass) {
		this.mpass = mpass;
	}

	public void setMref(String mref) {
		this.mref = mref;
	}

	public void setMstep(String mstep) {
		this.mstep = mstep;
	}

	public void setMdepth(String mdepth) {
		this.mdepth = mdepth;
	}

	public void setMwriteday(String mwriteday) {
		this.mwriteday = mwriteday;
	}

	public void setMhits(String mhits) {
		this.mhits = mhits;
	}

	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}

	public void setGroupSize(String groupSize) {
		this.groupSize = groupSize;
	}

	public void setCurPage(String curPage) {
		this.curPage = curPage;
	}

	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}

}
