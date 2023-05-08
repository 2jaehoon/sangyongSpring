package kr.co.sist;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller // HandlerMapper Ŭ������ �˻��ϴ� Ŭ����
public class HelloController {

	@RequestMapping( value = "/hell.do", method =RequestMethod.GET )//value���� ��ũ�� ����ϸ� /WEB-INF/views/(���ϰ�)hello.jsp�� ���� �⺻���� �̵������ ������
	public String hello() {
		return "hello";
	}

}
	