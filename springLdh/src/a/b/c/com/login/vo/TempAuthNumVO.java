package a.b.c.com.login.vo;

import org.apache.log4j.Logger;

public class TempAuthNumVO {
	private static Logger logger = Logger.getLogger(TempAuthNumVO.class);
	
	private int anum;
	private String authnum;
	private String memail;
	private String insertdate;
	
	public TempAuthNumVO() {
		
	}
	
	public TempAuthNumVO(int anum, String authnum, String memail, String insertdate) {
		this.anum = anum;
		this.authnum = authnum;
		this.memail = memail;
		this.insertdate = insertdate;
	}


	public static Logger getLogger() {
		return logger;
	}

	public int getAnum() {
		return anum;
	}

	public String getAuthnum() {
		return authnum;
	}

	public String getMemail() {
		return memail;
	}

	public String getInsertdate() {
		return insertdate;
	}

	public static void setLogger(Logger logger) {
		TempAuthNumVO.logger = logger;
	}

	public void setAnum(int anum) {
		this.anum = anum;
	}

	public void setAuthnum(String authnum) {
		this.authnum = authnum;
	}

	public void setMemail(String memail) {
		this.memail = memail;
	}

	public void setInsertdate(String insertdate) {
		this.insertdate = insertdate;
	}
	
	//매개변수 확인
	public static void printVO(TempAuthNumVO tvo) {
		logger.info("TempAuthNumVO 데이터 확인 시작 >>> ");
		
		logger.info("인증번호 시퀀스 >>> : " + tvo.getAnum());
		logger.info("인증번호 >>> : " + tvo.getAnum());
		logger.info("인증이메일 >>> : " + tvo.getAnum());
		logger.info("입력일 >>> : " + tvo.getAnum());
		
		logger.info("TempAuthNumVO 데이터 확인 끝 >>> :");
	}
	
}
