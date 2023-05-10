package kr.co.sist.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import kr.co.sist.domain.DataDomain;
//@SessionAttributes("mId") //���ǿ� �� �ϳ��� ������ ��
@SessionAttributes({"mName", "mId", "mObj"}) //���ǿ� �� ������ ������ ��
@Controller
public class SessionController {

	//HttpSession�� ����� �� ����
	@GetMapping("/session_set.do")
	public String setSession( HttpSession session ) {
		session.setAttribute("id", "sang");
		session.setAttribute("name", "������");
		
		return "redirect:index.html";
	}
	
	//���ǿ� ������ �� Controller���� ���
	@GetMapping("/session_get.do")
	public String getSession( HttpSession session ) {
		
		String id = (String)session.getAttribute("id");
		String name = (String)session.getAttribute("name");
		
		System.out.println(id + " / " + name);
		
		return "session/get_value";
	}//getSession
	
	//���ǿ� ������ �� Controller���� ����
	@GetMapping("/session_remove.do")
	public String removeSession( HttpSession session ) {
		
		session.removeAttribute("id");
		session.removeAttribute("name");
		
		
		return "redirect:index.html";
	}//removeSession
	
	@GetMapping("/model_set.do")
	public String setModelSession(Model model) {
		
		model.addAttribute("mId", "kim");
		model.addAttribute("mName", "�����");
		model.addAttribute("mObj", new DataDomain("�̴ܱ�", "lee@test.com"));
		
		return "redirect:index.html";
	}//setModelSession
	
	//Spring version v4.x������ Model�� getAttribute method�� �������� �ʾұ� ������
	//���ǿ� ������ ���� ��� ���ؼ��� HttpSession ����ؾ���
	@GetMapping("/model_get.do")
	public String getModelSession(HttpSession session) {
		
		String id = (String)session.getAttribute("mId");
		String name = (String)session.getAttribute("mName");
		DataDomain dd = (DataDomain)session.getAttribute("mObj");
		
		System.out.println(id + " / " + name + " / " + dd.getName() + " / " + dd.getEmail() );
		
		return "session/get_model_value";
	}//getModelSession
	
	//Spirng 5.x���ʹ� Model�� getAttribute�� �߰��Ǿ� ���ǿ� ���� ���� ������ HttpSession��
	//������� �ʾƵ� �ȴ�.
	@GetMapping("/model_get2.do")
	public String getModelSession2(Model model) {
		
		String id = (String)model.getAttribute("mId");
		String name = (String)model.getAttribute("mName");
		DataDomain dd = (DataDomain)model.getAttribute("mObj");
		if(dd!=null) {
		System.out.println("Model ��� : " + id + " / " + name + " / " + dd.getName() + " / " + dd.getEmail() );
		};
		return "session/get_model_value";
	}//getModelSession2
	
	@GetMapping("/model_http_remove.do")
	public String removeModelHttpSession(HttpSession session) {
		
		session.removeAttribute("mId");
		session.removeAttribute("mName");
		session.removeAttribute("mObj");
		
		session.invalidate();
		
		System.out.println("removeModelHttpSession���� ���� ����");
		
		return "redirect:index.html";
	}//removeModelHttpSession
	
	//Model�� ���� �����ߴٸ� SessionStatus�� ����Ͽ� ���ǰ��� �����Ѵ�.
	@GetMapping("/model_remove.do")
	public String removeModelSession(SessionStatus ss) {
		
		ss.setComplete();//���ǿ� �����ϴ� ��� ���� �����ȴ�.
		
		System.out.println("removeModelSession���� ���� ����");
		
		return "redirect:index.html";
	}//removeModelSession
	
	//��Ű �ɱ� : ������ �ڵ带 �״�� ���
	@GetMapping("/add_cookie.do")
	public String addCookie( HttpServletResponse response ) {

		//1. ��Ű ����
		Cookie cookie = new Cookie("name", "Ȳ�濬");
		Cookie cookie2 = new Cookie("age", "26");
		//2. ���� �ð� ����
		cookie.setMaxAge(60*60*24*1);
		cookie2.setMaxAge(60*60*24*1);
		//3. ��� �ɱ�
		response.addCookie(cookie);
		response.addCookie(cookie2);
		
		return "redirect:index.html";
	}//addCookie
	
	//��Ű�� ������ �� ��� @CookieValue(value="��Ű�̸�", defaultValue="��Ű�� ���� �� ������ ��")
	@GetMapping("/get_cookie.do")
	public String getCookie( @CookieValue(value="name", defaultValue = "����") String name,
			@CookieValue(value="age", defaultValue = "24") String age, 
			Model model ) {
		
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		
		return "session/get_cookie";
	}//getCookie
	
	//��Ű ���� : ������ �ڵ带 �״�� ���
	@GetMapping("/remove_cookie.do")
	public String removeCookie( HttpServletResponse response ) {

		//1. ��Ű ����( ���� �������� )
		Cookie cookie = new Cookie("name", "");
		Cookie cookie2 = new Cookie("age", "");
		//2. ���� �ð� 0���� ����
		cookie.setMaxAge(0);
		cookie2.setMaxAge(0);
		//3. ��� �ɱ�
		response.addCookie(cookie);
		response.addCookie(cookie2);
		
		return "redirect:index.html";
	}//addCookie
	
}//class
