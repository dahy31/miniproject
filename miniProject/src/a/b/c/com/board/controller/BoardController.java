package a.b.c.com.board.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //Controller가 있어야지 spring-servlet에서 읽을때 찾을 수 있음
public class BoardController {
	private Logger logger = Logger.getLogger(BoardController.class);

	@GetMapping("/topbar")
	public String topbar() {
		return "fragment/topbar";
	}
	
	@GetMapping("/footer")
	public String footer() {
		return "fragment/footer";
	}
	
	@GetMapping("/sidebar")
	public String sidebar() {
		return "fragment/sidebar";
	}
	
	@GetMapping("/login")
	public String login() {
		return "member/login";
	}
	
	@GetMapping("/register")
	public String register() {
		return "member/register";
	}
}
