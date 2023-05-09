package kr.co.sist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RedirectController {
	
	//.do를 redirect로 요청
	@GetMapping("/redirect_do.do")
	public String redirectDo(){
		
		// return "sub_folder.do"; ViewResolver를 통해서 요청하기 때문에 
		//WEB-INF/views/sub_folder.do.jsp의 형식으로 만들어진다.
		return "redirect:sub_folder.do";
		//viewResolver를 거치지 않고 .do를 직접 호출하도록 만들어야한다..
	}
	
	@GetMapping("/redirect_jsp.do")
	public String redirectJsp(){
		
		//webapp 폴더 하위에 존재하는 jsp는 viewResolver를 거치지 않고
		//호출되어야한다.
		return "redirect:data_send/main.jsp";
	}
}
