package a.b.c.com.login.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import a.b.c.com.common.GoogleMailSend;
import a.b.c.com.common.K_Session;
import a.b.c.com.common.PasswordUtil;
import a.b.c.com.login.service.SpringLoginService;
import a.b.c.com.login.vo.TempAuthNumVO;
import a.b.c.com.login.vo.TempPwVO;
import a.b.c.com.mem.vo.SpringMemberVO;


@Controller
public class SpringLoginController {
	Logger logger = Logger.getLogger(SpringLoginController.class);
	
	private SpringLoginService springLoginService;
	
	//생성자 오토와이어드
	@Autowired(required=false)
	public SpringLoginController(SpringLoginService springLoginService) {
		this.springLoginService = springLoginService;
	}
	
	//로그인 입력 폼
	@GetMapping("loginForm")
	public String loginForm() {
		logger.info("SpringLoginController loginForm() 함수 진입 >>> : ");
		return "login/springLoginForm";
	}

	//로그인
	@PostMapping("login")
	public String login(HttpServletRequest req, SpringMemberVO mvo, Model model) {
		logger.info("SpringLoginController login() 함수 진입 >>> : ");
		SpringMemberVO.printVO(mvo);
		
		List<SpringMemberVO > listLogin = springLoginService.loginCheck(mvo);
		logger.info("SpringLoginController login listLogin.size() >>> : " +listLogin.size());
		
		if(listLogin.size() == 1) {

			K_Session ks = K_Session.getInstance();
			String KID = ks.getSession(req);
			
			if(KID != null && KID.contentEquals(listLogin.get(0).getMid())) {
				logger.info("SpringLoginController login >>> 로그인 중 >>> : 다른 페이지로 이동하기 >>> : " + KID);
				model.addAttribute("listLogin",listLogin);
				return "main/mainPage";
			}else {
				ks.setSession(req,mvo.getMid());
				logger.info("SpringLoginController login >>> : 세션부여 하기 >>> : " + mvo.getMid());
				
				model.addAttribute("listLogin",listLogin);
				return "login/springLogin";
			}
		}
		return "login/springLoginForm";
	}
	
	
	//로그아웃
	@GetMapping("logout")
	public String logout(HttpServletRequest req, SpringMemberVO mvo, Model model) {
				logger.info("SpringLoginController loginout() 함수 진입 >>> : ");
				SpringMemberVO.printVO(mvo);
				
				K_Session ks = K_Session.getInstance();
				String KID = ks.getSession(req);
				return "login/springLogout";
	}
	
	//이메일로 아이디 찾기 폼
	//아이디찾기 입력 폼
	@GetMapping("idFindForm")
	public String idFind() {
		logger.info("SpringLoginController idFind() 함수 진입 >>> : ");
		return "login/springIdFindForm";
	}
	
	//이메일 확인해서 아이디 찾기
	@GetMapping("email_authentication")
	public String email_authentication(SpringMemberVO mvo, TempAuthNumVO tvo, Model model) {	
		logger.info("SpingLoginController email_authentication() 함수 진입 >>> : ");
		
		List<SpringMemberVO> listEmail = springLoginService.emailCheck(mvo);
		logger.info("SpingLoginController email_authentication listEmail.size() >>> : " + listEmail.size());
		
		// 이메일이 확인되면 인증번호를 이메일로 인증번호 리턴하기 
		if (listEmail.size() == 1) {
			
			// 인증번호 만들기 
			String email_authentication_num = PasswordUtil.randomPW(6);
			logger.info("SpingLoginController email_authentication email_authentication_num >>> : " + email_authentication_num);
			
			// 인증번호를 테이블에 입력하기 TEMP_AUTH_NUM
			tvo.setAuthnum(email_authentication_num);
			int authNumCnt = springLoginService.tempAuthNumInsert(tvo);
			
			// 인증번호가 TEMP_AUTH_NUM 입력되면 이메일 전송하기 
			// 이메일 전송 성공 여부는 ??? 
			if (authNumCnt == 1) {
				// TEMP_AUTH_NUM 테이블에 입력 성공된 인증번호 로 메일 보내기 
				email_authentication_num = tvo.getAuthnum();
				
				String mailSubject = "naver";
				String sendMail = "es928691dh@gmail.com";
				String sendPw = "ldh@7370jy!";
				String reviceMail = mvo.getMemail();
				String sendMsg = email_authentication_num;
				
				GoogleMailSend gms = new GoogleMailSend();
				gms.googleMailSend(mailSubject, sendMail, sendPw, reviceMail, sendMsg);
			
				//model.addAttribute("authentication_num", email_authentication_num);
				return "login/springIdEmailCheck";
			}
		}		
		return "login/springLoginForm";
	}
	//인증번호 받아서 아이디 확인하기
	@GetMapping("idFind")
	public String idFind(SpringMemberVO mvo, TempAuthNumVO tvo, Model model) {
		logger.info("SpringLoginfController idFind() 함수 진입 >>> : ");
		SpringMemberVO.printVO(mvo);
		TempAuthNumVO.printVO(tvo);
		
		mvo.setTempauthmemail(tvo.getMemail());
		mvo.setTempauthnum(tvo.getAuthnum());
		List<SpringMemberVO> listIdFind = springLoginService.emailIdFind(mvo);
		logger.info("SpringLoginController idFind listIdFind.size() >>> : " + listIdFind.size());
		
		if(listIdFind.size() == 1) {
			model.addAttribute("listIdFind", listIdFind);
			return "login/springIdFindOK";
		}
		return "login/springIdFindForm";
	}
	//이메일로 아이디 찾기 끝
	//아이디로 비번 찾기 시작
	//비번 찾기 입력폼
	@GetMapping("pwFindForm")
	public String pwFindForm() {
		logger.info("SpringLoginController pwFind() 함수 진입 >>> : ");
		return "login/springPwFindForm";
	}
	
	//아이디 찾기
	@GetMapping("pwIdFind")
	public String pwIdFind(SpringMemberVO mvo, Model model) {
		logger.info("SpringLogindController pwIdFind() 함수 진입 >>> : ");
		
		List<SpringMemberVO> listPwId = springLoginService.pwIdCheck(mvo);
		logger.info("SpringLoginController pwIdFind listPwId.size() >>> : "+ listPwId.size());
		
		return "login/springPwTemp";
	}
	
	//아이디, 이메일 확인해서 임시비밀번호 받기
	@GetMapping("id_email_authentication")
	public String id_authentcation(SpringMemberVO mvo, TempPwVO tvo, Model model) {
		logger.info("SpringLogindController id_authentication() 함수 진입 >>> : ");
		
		//아이디 이메일 체크하기
		List<SpringMemberVO> listIdEmail = springLoginService.pwEmailCheck(mvo);
		logger.info("SpringLoginController id_authentication listIdEmail.size() >>> : " + listIdEmail.size());
		
		if(listIdEmail.size() == 1) {
			
			//임시 비밀번호(8자)만들기
			String temp_pw_num = PasswordUtil.randomPW(8);
			logger.info("SpringLoginController id_authentication temp_pw_num >>> : " + temp_pw_num);
			
			//임시 비밀번호 TEMP_PW 테이블에 입력하기
			tvo.setPtemppw(temp_pw_num);
			int tempPwCnt = springLoginService.tempPwInsert(tvo);
			logger.info("SpringLoginController id_authentication tempPwCnt() >>> : " + tempPwCnt);
			
			//입력 성공하면 임시 비밀번호 이메일 보내기
			//메일 성공여부는 ??? 
			if (tempPwCnt == 1) {
				//TEMP_AUTH_NUM 테이블에 입력 성공된 인증번호로 메일 보내기
				temp_pw_num = tvo.getPtemppw();
				
				String mailSubject = "";
				String sendMail = "";
				String sendPw = "";
				String reviceMail = "";
				String sendMsg = "";
				
				GoogleMailSend gms = new GoogleMailSend();
				gms.googleMailSend(mailSubject, sendMail, sendPw, reviceMail, sendMsg);
				
				//idFind에 메시지 띄우기
				model.addAttribute("temp_pw_num", temp_pw_num);
				return "login/springPwEmailCheck";
				
			}
		}
		return "";
	}
	
	//임시비밀번호로 새 비밀번호 만들기
	@GetMapping("pwCreateForm")
	public String pwCreateForm(SpringMemberVO mvo, TempPwVO tvo, Model model) {
		logger.info("SpringLoginController pwCreateForm() 함수 진입 >>> : ");
		
		return "login/springPwCreateForm";
	}
	
	//아이디로 비번찾기 끝
}
