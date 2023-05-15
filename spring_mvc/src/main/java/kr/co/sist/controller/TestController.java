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
		
		
		//SpringContainer ����
		//������ ���� ��Ű���� �ְų� �ٸ� ��Ű���� �־��� �� ���.
		//ApplicationContext ac = new ClassPathXmlApplicationContext("/WEB-INF/spring/root-context.xml");
		//������ hdd�� �ٸ� ��ο� ��ġ�� �� ���( ���� ��� ���)
		//Servlet�̳� JSP�� ����� �� �����ϴ� ������ ���� ��θ� ���
		//ServletContext�� ��� > getReadPath�� ���
		
		ApplicationContext ac = new FileSystemXmlApplicationContext("C:/Users/user/git/sangyongSpring/spring_mvc/src/main/webapp/WEB-INF/spring/root-context.xml");
		//Service ���
		TestService ts = ac.getBean(TestService.class);
		// Service ��ü�� �����ϴ� method ���
		System.out.println("������ ���� ���� ��ü�� �޼���" + ts.search());
		
		return "get";
	}

}
