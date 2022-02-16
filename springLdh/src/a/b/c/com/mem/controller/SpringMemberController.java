package a.b.c.com.mem.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import a.b.c.com.common.ChabunUtil;
import a.b.c.com.common.CommonUtils;
import a.b.c.com.common.FileUploadUtil;
import a.b.c.com.common.service.ChabunService;
import a.b.c.com.mem.service.SpringMemberService;
import a.b.c.com.mem.vo.SpringMemberVO;

@Controller
public class SpringMemberController {
	Logger logger = Logger.getLogger(SpringMemberController.class);
	
	private SpringMemberService springMemberService;
	private ChabunService chabunService;
	
	//생성자 오토와이어드
	@Autowired(required=false)
	public SpringMemberController(SpringMemberService springMemberService, ChabunService chabunService) {
		this.springMemberService = springMemberService;
		this.chabunService = chabunService;
	}
	
	//회원가입 입력 폼
	// @RequestMapping(value="memForm", method=RequestMethod.GET)
	@GetMapping("memForm")
	public String memForm() {
		logger.info("SpringMemberController memForm() 함수 진입 >>> : ");
		return "mem/springMemForm";
	}
	
	//회원가입
	//@RequestMapping(value="memInsert", method=RequestMethod.POST)
	@PostMapping("memInsert")
	public String memInsert(HttpServletRequest req) {
		logger.info("SpringMemberController memInsert() 함수 진입 >>> : ");
		
		//채번구하기
		String mnum = ChabunUtil.getMemChabun("D", chabunService.getMemChabun().getMnum());
		logger.info("SpringMemberController memInsert mnum >>> : " + mnum);
		
		//이미지 업로드
		FileUploadUtil fu = new FileUploadUtil(CommonUtils.MEMBER_IMG_UPLOAD_PATH
												,CommonUtils.MEMBER_IMG_FILE_SIZE
												,CommonUtils.MEMBER_EN_CODE);
		//이미지 파일 원본 사이즈
		//boolean bool = fu.imgfileUpload(req);
		//이미지 파일 원본 사이즈 크기 조절하기
		boolean bool = fu.imgfileUploadSize(req);
		logger.info("SpringMemberController memInsert bool >>> : " + bool);
		
		//채번, 이미지 업로드 성공하면 VO 세팅하기
		SpringMemberVO mvo = null;
		mvo = new SpringMemberVO();
		
		//회원번호
		mvo.setMnum(mnum);
		//회원이름
		mvo.setMname(fu.getParameter("mname"));
		//아이디
		mvo.setMid(fu.getParameter("mid"));
		//패스워드
		mvo.setMpw(fu.getParameter("mpw"));
		
		//성별
		mvo.setMgender(fu.getParameter("mgender"));
		
		//생년월일
		String mbirth = fu.getParameter("mbirth");
		String mbirth1 = fu.getParameter("mbirth1");
		String mbirth2 = fu.getParameter("mbirth2");
		mbirth = mbirth + mbirth1 + mbirth2;
		mvo.setMbirth(mbirth);
		
		//핸드폰
		String mhp = fu.getParameter("mhp");
		String mhp1 = fu.getParameter("mhp1");
		String mhp2 = fu.getParameter("mhp2");
		mhp = mhp + mhp1 + mhp2;
		mvo.setMhp(mhp);
		
		//전화번호
		String mtel = fu.getParameter("mtel");
		String mtel1 = fu.getParameter("mtel1");
		String mtel2 = fu.getParameter("mtel2");
		mtel = mtel + mtel1 + mtel2;
		mvo.setMtel(mtel);
		
		//이메일
		String memail = fu.getParameter("memail");
		String memail1 = fu.getParameter("memail1");
		memail = memail.concat("@").concat(memail1);
		mvo.setMemail(memail);
		
		//주소 : 우편번호
		mvo.setMzonecode(fu.getParameter("mzonecode"));
		
		// 주소 : 도로명 주소						
		String mroadaddress = fu.getParameter("mroadaddress");
		String mroadaddressdetail = fu.getParameter("mroadaddressdetail");						
		mroadaddress = mroadaddress.concat("@").concat(mroadaddressdetail);
		mvo.setMroadaddress(mroadaddress);
		
		// 주소 : 지번 주소 
		mvo.setMjibunaddress(fu.getParameter("mjibunaddress"));
		
		// 취미
		String[] hobby = fu.getParameterValues("mhobby");
		String mhobby = "";
		for (int i=0; i < hobby.length; i++){
			mhobby += hobby[i] + ",";
		}
		mvo.setMhobby(mhobby);
		
		// 내소개
		mvo.setMinfo(fu.getParameter("minfo"));
		
		// 사진
		ArrayList<String> aFileName = fu.getFileNames();
		String mphoto = aFileName.get(0);				
		mvo.setMphoto(mphoto);
		
		// 관리자
		mvo.setMadmin("00"); // 관리자

		int nCnt = springMemberService.memberInsert(mvo);
			
		if (nCnt > 0) { return "mem/springMemInsert";}
		return "mem/springMemInsert";
	}
	
	//회원 목록 조회
	@RequestMapping(value="memSelectAll", method=RequestMethod.GET)
	public String memSelectAll(SpringMemberVO mvo, Model model) {
		logger.info("SpringMemberController memSelectAll 함수 진입 >>> : ");
		
		List<SpringMemberVO> listAll = springMemberService.memberSelectAll(mvo);
		logger.info("SpringMemberController memSelectAll listAll.size() >>> : " + listAll.size());
		
		if(listAll.size() > 0) {
			 model.addAttribute("listAll", listAll);
			 return "mem/springMemSelectAll";
		}
		
		return "mem/springMemForm";
	}
	
	// 회원 수정/삭제  조회
	// @RequestMapping(value="memSelect", method=RequestMethod.POST)
	@GetMapping("memSelect")
	public String memSelect(SpringMemberVO mvo, Model model) {	
		logger.info("SpringMemberController memSelect 함수 진입 >>> :");		
		logger.info("SpringMemberController memSelect mvo.getMnum()) >>> : " + mvo.getMnum());		
		
		List<SpringMemberVO> listS = springMemberService.memberSelect(mvo);
		logger.info("SpringMemberController memSelect listS.size() >>> : " + listS.size());
		
		if (listS.size() == 1) { 
			model.addAttribute("listS", listS);
			return "mem/springMemSelect";
		}		
		return "mem/springMemForm";
	}
	
	// 회원정보 수정하기 
	@RequestMapping(value="memUpdate", method=RequestMethod.POST)
	public String boardUpdate(HttpServletRequest req, SpringMemberVO mvo, Model model) {
		logger.info("SpringMemberController boardUpdate 함수 진입 >>> :");
		
		// 이메일
		String memail = req.getParameter("memail");
		String memail1 = req.getParameter("memail1");						
		memail = memail.concat("@").concat(memail1);
		mvo.setMemail(memail);		
		// 주소 : 우편번호
		mvo.setMzonecode(req.getParameter("mzonecode"));		
		// 주소 : 도로명 주소						
		String mroadaddress = req.getParameter("mroadaddress");
		String mroadaddressdetail = req.getParameter("mroadaddressdetail");						
		mroadaddress = mroadaddress.concat("@").concat(mroadaddressdetail);
		mvo.setMroadaddress(mroadaddress);		
		// 주소 : 지번 주소 
		mvo.setMjibunaddress(req.getParameter("mjibunaddress"));
		
		logger.info("SpringMemberController boardUpdate bvo.getSbnum() >>> : " + mvo.getMnum());
		
		int nCnt = springMemberService.memberUpdate(mvo);
		logger.info("SpringMemberController boardUpdate nCnt >>> : " + nCnt);
		
		if (nCnt > 0) { return "mem/springMemUpdate";}
		return "mem/springMemForm";
	}
	
	// 회원정보 삭제하기
	@RequestMapping(value="memDelete", method=RequestMethod.POST)
	public String memUpdate(SpringMemberVO mvo, Model model) {
		logger.info("SpringMemberController memDelete 함수 진입 >>> :");
		
		logger.info("SpringMemberController memDelete mvo.getMnum() >>> : " + mvo.getMnum());		
		int nCnt = springMemberService.memberDelete(mvo);
		logger.info("SpringMemberController memDelete nCnt >>> : " + nCnt);
		
		if (nCnt > 0) { return "mem/springMemDelete";}
		return "mem/springMemForm";
	}
	
	// 아이디 중복 체크하기
	@RequestMapping(value="memIdCheck", method=RequestMethod.POST)
	@ResponseBody
	public Object memIdCheck(SpringMemberVO mvo) {
		logger.info("SpringMemberController memIdCheck 함수 진입 >>> :");		
		logger.info("SpringBoardController memIdCheck mvo.getMid() >>> : " + mvo.getMid());			
		
		List<SpringMemberVO> list = springMemberService.memberIdCheck(mvo);			
		logger.info("SpringBoardController memIdCheck list.size() >>> : " + list.size());
		
		String msg = "";		
		if (list.size() == 0) {msg = "ID_YES";}  
		else { msg = "ID_NO";}  
		
		return msg;		
	}
	}
