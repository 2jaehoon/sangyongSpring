package kr.co.sist.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IncludeController {
	
	@GetMapping("/include_test.do")
	public String includeTest( HttpServletRequest request, Model model ) {
	
		model.addAttribute("connIp", request.getRemoteAddr());
		
		return "views_include";
	}

}//class
