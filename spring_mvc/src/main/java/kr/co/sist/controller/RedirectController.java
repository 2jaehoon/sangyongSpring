package kr.co.sist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RedirectController {
	
	//.do�� redirect�� ��û
	@GetMapping("/redirect_do.do")
	public String redirectDo(){
		
		// return "sub_folder.do"; ViewResolver�� ���ؼ� ��û�ϱ� ������ 
		//WEB-INF/views/sub_folder.do.jsp�� �������� ���������.
		return "redirect:sub_folder.do";
		//viewResolver�� ��ġ�� �ʰ� .do�� ���� ȣ���ϵ��� �������Ѵ�..
	}
	
	@GetMapping("/redirect_jsp.do")
	public String redirectJsp(){
		
		//webapp ���� ������ �����ϴ� jsp�� viewResolver�� ��ġ�� �ʰ�
		//ȣ��Ǿ���Ѵ�.
		return "redirect:data_send/main.jsp";
	}
}
