package kr.co.sist;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller // HandlerMapper 클래스가 검색하는 클래스
public class HelloController {

	@RequestMapping( value = "/hell.do", method =RequestMethod.GET )//value값의 링크를 사용하면 /WEB-INF/views/(리턴값)hello.jsp가 실행 기본적인 이동방식은 포워드
	public String hello() {
		return "hello";
	}

}
	