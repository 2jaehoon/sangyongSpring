package kr.co.sist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DoChainController {
	
	//chainA가 요청되면 chainB에서 업무처리 후 chainC를 요청된다.
	@GetMapping("chain_a.do")
	public String chainA() {
		
		return "forward:chain_b.do";
	}//chainA
	
	//chainB가 요청되면 chainB에서 업무처리 후 chainC를 요청된다.
	@GetMapping("chain_b.do")
public String chainB() {
		
	return "forward:chain_c.do";
	}//chainB

	//chainC 작업은 chainB에서 업무처리 후 요청된다.
	@GetMapping("chain_c.do")
public String chainC() {
	
	return "view_data/chain_result";
}//chainC

}
