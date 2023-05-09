package kr.co.sist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DoChainController {
	
	//chainA�� ��û�Ǹ� chainB���� ����ó�� �� chainC�� ��û�ȴ�.
	@GetMapping("chain_a.do")
	public String chainA() {
		
		return "forward:chain_b.do";
	}//chainA
	
	//chainB�� ��û�Ǹ� chainB���� ����ó�� �� chainC�� ��û�ȴ�.
	@GetMapping("chain_b.do")
public String chainB() {
		
	return "forward:chain_c.do";
	}//chainB

	//chainC �۾��� chainB���� ����ó�� �� ��û�ȴ�.
	@GetMapping("chain_c.do")
public String chainC() {
	
	return "view_data/chain_result";
}//chainC

}
