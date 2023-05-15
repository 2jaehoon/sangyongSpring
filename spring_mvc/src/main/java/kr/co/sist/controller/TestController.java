package kr.co.sist.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.sist.service.TestService;

@Controller
public class TestController {
	
	@GetMapping("/di.do")
	public String diController( HttpServletRequest request ) {
		
		
		//SpringContainer 생성
		//파일이 같은 패키지에 있거나 다른 패키지에 있었을 때 사용.
		//ApplicationContext ac = new ClassPathXmlApplicationContext("/WEB-INF/spring/root-context.xml");
		//파일이 hdd의 다른 경로에 위치할 때 사용( 절대 경로 사용)
		//Servlet이나 JSP가 실행될 때 참조하는 파일의 실제 경로를 얻기
		//ServletContext를 얻고 > getReadPath를 사용
		
		ApplicationContext ac = new FileSystemXmlApplicationContext("C:/Users/user/git/sangyongSpring/spring_mvc/src/main/webapp/WEB-INF/spring/root-context.xml");
		//Service 얻기
		TestService ts = ac.getBean(TestService.class);
		// Service 객체가 제공하는 method 사용
		System.out.println("의존성 주입 받은 객체의 메서드" + ts.search());
		
		return "get";
	}

}
