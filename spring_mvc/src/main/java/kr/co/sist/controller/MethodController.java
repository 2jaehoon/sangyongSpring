package kr.co.sist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//HandlerMapper가 찾을 수 있도록 annotation을 설정
@Controller
public class MethodController {

	//URL을 method에서 처리할 수 있도록 annotation을 설정
	// @RequestMapping( value = "/get.do", method =RequestMethod.GET )//value값의 링크를 사용하면 /WEB-INF/views/(리턴값)가 실행 기본적인 이동방식은 포워드
	@GetMapping("/get.do")
	public String getProcess() {
		
		//view를 할 JSP명 (ViewResolver가 prefix와 suffix를 붙여서 찾는다.)
		//get이 반환되면  /WEB-INF/views/get.jsp가 된다.
		return "get";
	}//getProcess
	
	//URL을 method에서 처리할 수 있도록 annotation을 설정
	// @RequestMapping( value = "/post.do", method =RequestMethod.POST )//value값의 링크를 사용하면 /WEB-INF/views/(리턴값)가 실행 기본적인 이동방식은 포워드
	@PostMapping("/post.do")
	public String postProcess() {
		
		//view를 할 JSP명 (ViewResolver가 prefix와 suffix를 붙여서 찾는다.)
				//post가 반환되면  /WEB-INF/views/post.jsp가 된다.
		return "post";
	}//postProcess
	
	//method가 GET방식과 POST방식을 모두 처리할 수 있도록 설정
	//method를 배열로 처리한다. 
	@RequestMapping(value = "/get_post.do", method = {RequestMethod.GET, RequestMethod.POST })
	public String getPost() {
		return "get_post";
	}//getPost
	
	//Spring MVC에서는 패키지명이 URL이 반영되지 않기 때문에 비슷한 작업을
	//묶을 때에는 가상의 이름을 사용하여 경로를 만든다.
	//@RequestMapping( value="/가상의이름/서비스할이름" )
	
	@RequestMapping(value = "/work/path.do", method=RequestMethod.GET )
	public String path() {
		return "path";
	}
	
	//요청 URL과 응답 JSP명이 같은 경우 반환형을 void로 만들 수 있다.
	@RequestMapping(value = "/same_url.do", method=RequestMethod.GET )
	public void sameURL() {
	 System.out.println("sameURL method가 호출");
	}
	
		
	
	
}//class
