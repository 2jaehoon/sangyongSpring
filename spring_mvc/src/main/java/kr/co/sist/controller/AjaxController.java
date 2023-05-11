package kr.co.sist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.sist.service.AjaxService;

@Controller
public class AjaxController {

	@GetMapping("/ajax/emp_ajax.do")
	public String searchEmp( int deptno, Model model ) {
		
		//Service 생성
		AjaxService as = new AjaxService();
		String jsonObj = as.empJsonObj(deptno);
		model.addAttribute("jsonObj", jsonObj);
		
		return "ajax/emp_ajax";
	}//searchEmp
	
	
	@ResponseBody
	@GetMapping("/ajax/emp_response_ajax.do")
	public String searchEmp2( int deptno, String name ) {
		System.out.println("웹 파라메터로 넘어온 이름 : " + name);
		
		//Service 생성
		AjaxService as = new AjaxService();
		String jsonObj = as.empJsonObj(deptno);

		
		return jsonObj;
	}
	
}//class
