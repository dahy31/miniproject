package a.b.c.com.rboard.vo;

public class SpringRboardVO {
	
	private String rsbnum;
	private String sbnum;
	private String rsbname;
	private String rsbcontent;
	private String rsbpw;
	private String rsbdelyn;
	private String rsbinsertdate;
	


	public SpringRboardVO(String rsbnum, String sbnum, String rsbname,
						  String rsbcontent, String rsbpw, String rsbdelyn,
						  String rsbinsertdate) {

		this.rsbnum = rsbnum;
		this.sbnum = sbnum;
		this.rsbname = rsbname;
		this.rsbcontent = rsbcontent;
		this.rsbpw = rsbpw;
		this.rsbdelyn = rsbdelyn;
		this.rsbinsertdate = rsbinsertdate;
	}

	
	public String getRsbnum() {
		return rsbnum;
	}

	public void setRsbnum(String rsbnum) {
		this.rsbnum = rsbnum;
	}

	public String getSbnum() {
		return sbnum;
	}

	public void setSbnum(String sbnum) {
		this.sbnum = sbnum;
	}

	public String getRsbname() {
		return rsbname;
	}

	public void setRsbname(String rsbname) {
		this.rsbname = rsbname;
	}

	public String getRsbcontent() {
		return rsbcontent;
	}

	public void setRsbcontent(String rsbcontent) {
		this.rsbcontent = rsbcontent;
	}

	public String getRsbpw() {
		return rsbpw;
	}

	public void setRsbpw(String rsbpw) {
		this.rsbpw = rsbpw;
	}

	public String getRsbdelyn() {
		return rsbdelyn;
	}

	public void setRsbdelyn(String rsbdelyn) {
		this.rsbdelyn = rsbdelyn;
	}

	public String getRsbinsertdate() {
		return rsbinsertdate;
	}

	public void setRsbinsertdate(String rsbinsertdate) {
		this.rsbinsertdate = rsbinsertdate;
	}
	
	
}
