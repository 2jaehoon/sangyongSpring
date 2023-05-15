package kr.co.sist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.sist.service.AnnService;

@Controller
public class AnnController {
	@Autowired(required = false)
	private AnnService as;
	
	@GetMapping("/ann.do")
	public String ann() {
		System.out.println("얻어온 이름 : " + as.nameData());
		return "get";
	}

}
