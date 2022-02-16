package a.b.c.com.rboard.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import a.b.c.com.common.ChabunUtil;
import a.b.c.com.common.service.ChabunService;
import a.b.c.com.rboard.service.SpringRboardService;
import a.b.c.com.rboard.vo.SpringRboardVO;

@Controller
public class SpringRboardController {
	Logger logger = Logger.getLogger(SpringRboardController.class);

	@Autowired(required=false)
	private SpringRboardService springRboardService;
	
	@Autowired(required=false)
	private ChabunService chabunService;
	
	public SpringRboardController(  SpringRboardService springRboardService
								  ,	ChabunService chabunService) {
		this.springRboardService = springRboardService;
		this.chabunService = chabunService;
	}
	
	@RequestMapping(value="rboardForm", method= {RequestMethod.GET, RequestMethod.POST})
	public String rboardForm() {
		logger.info("SpringRboardController rboardForm >>> : ");
		return "rboard/springRboardForm";
	}
	
	//댓글 등록
	@RequestMapping( value="rboardInsert", method=RequestMethod.POST)
	@ResponseBody
	public String rboardInsert(SpringRboardVO rbvo) {
		logger.info("SpringRboardController rboardInsert >>> : ");
		logger.info("SpringRboardController rboardInsert rbvo.getSbnum() >>> : " + rbvo.getSbnum());
		logger.info("SpringRboardController rboardInsert rbvo.getRsbcontent() >>> : " + rbvo.getRsbcontent());
		
		String rsbnum = ChabunUtil.getRboardChabun("N", chabunService.getRboardChabun().getRsbnum());
		logger.info("SpringRboardController rboardInsert rsbnum >>> : " + rsbnum);
		
		rbvo.setRsbnum(rsbnum);
		int nCnt = springRboardService.rboardInsert(rbvo);
		logger.info("SpringRboardController rboardInsert nCnt >>> : " + nCnt);
		
		if(1 == nCnt) {return "GOOD";}
		else {return "BAD";}
	}
	
	//댓글 조회
	@RequestMapping(value="rboardSelect", method=RequestMethod.POST)
	@ResponseBody
	public String rboardSelect(SpringRboardVO rbvo) {
		logger.info("SpringRboardController rboardSelect >>> : ");
		logger.info("SpringRboardController rboardSelect rbvo.getRsbnum() >>> : " + rbvo.getRsbnum());
		
		List<SpringRboardVO> list = springRboardService.rboardSelect(rbvo);
		logger.info("RboardController rboardSelect _rbvo >>> : " + list);
		
		String listStr =    list.get(0).getRsbnum()
						+","+list.get(0).getRsbname()
						+","+list.get(0).getRsbcontent()
						+","+list.get(0).getRsbinsertdate();
		return listStr;
	}
	
	// 댓글 조회	
	@RequestMapping( value="rboardSelectAll", method=RequestMethod.POST, produces = "application/text; charset=utf-8")
	@ResponseBody
	public String rboardSelectAll(SpringRboardVO rbvo) {	
		logger.info("SpringRboardController rboardSelectAll() 함수진입 >>> : ");
		// rbvo.setSbnum("B0001");
		logger.info("SpringRboardController rboardSelectAll rbvo.getSbnum() >>> : " + rbvo.getSbnum());
		
		List<SpringRboardVO> list  = springRboardService.rboardSelectAll(rbvo);
		logger.info("SpringRboardController rboardSelectAll _rbvo >>> : " + list);
		
		String ss = "";
		String listStr = "";
		for (int i=0; i < list.size(); i++) {
			SpringRboardVO _rbvo = list.get(i);
			String s0 = _rbvo.getRsbnum();
			String s1 = _rbvo.getRsbname();
			String s2 = _rbvo.getRsbcontent();
			String s3 = _rbvo.getRsbinsertdate();
			ss = s0+","+s1+","+s2+","+s3;
			listStr += ss+"&";
		}
		return listStr;
	}
	
	//댓글 삭제
	@RequestMapping(value="rboardDelete", method=RequestMethod.POST)
	@ResponseBody
	public String rboardDelete(SpringRboardVO rbvo) {
		logger.info("SpringRboardController rboardDelete >>> : ");
		logger.info("SpringRboardController rboardDelete rbvo.getRsbnum() >>> : " + rbvo.getRsbnum());
		
		int nCnt = springRboardService.rboardDelete(rbvo);
		logger.info("SpringRboardController rboardDelete nCnt >>> : " + nCnt);
		
		if(1 == nCnt) {return "GOOD";}
		else {return "BAD";}
	}
}
