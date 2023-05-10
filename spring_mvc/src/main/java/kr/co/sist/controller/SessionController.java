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
//@SessionAttributes("mId") //세션에 값 하나만 설정할 때
@SessionAttributes({"mName", "mId", "mObj"}) //세션에 값 여러개 설정할 때
@Controller
public class SessionController {

	//HttpSession을 사용한 값 설정
	@GetMapping("/session_set.do")
	public String setSession( HttpSession session ) {
		session.setAttribute("id", "sang");
		session.setAttribute("name", "윤상준");
		
		return "redirect:index.html";
	}
	
	//세션에 설정된 값 Controller에서 얻기
	@GetMapping("/session_get.do")
	public String getSession( HttpSession session ) {
		
		String id = (String)session.getAttribute("id");
		String name = (String)session.getAttribute("name");
		
		System.out.println(id + " / " + name);
		
		return "session/get_value";
	}//getSession
	
	//세션에 설정된 값 Controller에서 삭제
	@GetMapping("/session_remove.do")
	public String removeSession( HttpSession session ) {
		
		session.removeAttribute("id");
		session.removeAttribute("name");
		
		
		return "redirect:index.html";
	}//removeSession
	
	@GetMapping("/model_set.do")
	public String setModelSession(Model model) {
		
		model.addAttribute("mId", "kim");
		model.addAttribute("mName", "김경태");
		model.addAttribute("mObj", new DataDomain("이단군", "lee@test.com"));
		
		return "redirect:index.html";
	}//setModelSession
	
	//Spring version v4.x까지는 Model에 getAttribute method가 제공되지 않았기 때문에
	//세션에 설정된 값을 얻기 위해서는 HttpSession 사용해야함
	@GetMapping("/model_get.do")
	public String getModelSession(HttpSession session) {
		
		String id = (String)session.getAttribute("mId");
		String name = (String)session.getAttribute("mName");
		DataDomain dd = (DataDomain)session.getAttribute("mObj");
		
		System.out.println(id + " / " + name + " / " + dd.getName() + " / " + dd.getEmail() );
		
		return "session/get_model_value";
	}//getModelSession
	
	//Spirng 5.x부터는 Model에 getAttribute가 추가되어 세션에 값을 얻을 때에도 HttpSession을
	//사용하지 않아도 된다.
	@GetMapping("/model_get2.do")
	public String getModelSession2(Model model) {
		
		String id = (String)model.getAttribute("mId");
		String name = (String)model.getAttribute("mName");
		DataDomain dd = (DataDomain)model.getAttribute("mObj");
		if(dd!=null) {
		System.out.println("Model 사용 : " + id + " / " + name + " / " + dd.getName() + " / " + dd.getEmail() );
		};
		return "session/get_model_value";
	}//getModelSession2
	
	@GetMapping("/model_http_remove.do")
	public String removeModelHttpSession(HttpSession session) {
		
		session.removeAttribute("mId");
		session.removeAttribute("mName");
		session.removeAttribute("mObj");
		
		session.invalidate();
		
		System.out.println("removeModelHttpSession에서 세션 삭제");
		
		return "redirect:index.html";
	}//removeModelHttpSession
	
	//Model로 값을 설정했다면 SessionStatus를 사용하여 세션값을 삭제한다.
	@GetMapping("/model_remove.do")
	public String removeModelSession(SessionStatus ss) {
		
		ss.setComplete();//세션에 존재하는 모든 값이 삭제된다.
		
		System.out.println("removeModelSession에서 세션 삭제");
		
		return "redirect:index.html";
	}//removeModelSession
	
	//쿠키 심기 : 기존의 코드를 그대로 사용
	@GetMapping("/add_cookie.do")
	public String addCookie( HttpServletResponse response ) {

		//1. 쿠키 생성
		Cookie cookie = new Cookie("name", "황충연");
		Cookie cookie2 = new Cookie("age", "26");
		//2. 생존 시간 설정
		cookie.setMaxAge(60*60*24*1);
		cookie2.setMaxAge(60*60*24*1);
		//3. 쿠기 심기
		response.addCookie(cookie);
		response.addCookie(cookie2);
		
		return "redirect:index.html";
	}//addCookie
	
	//쿠키에 설정된 값 얻기 @CookieValue(value="쿠키이름", defaultValue="쿠키가 없을 때 설정될 값")
	@GetMapping("/get_cookie.do")
	public String getCookie( @CookieValue(value="name", defaultValue = "윤상") String name,
			@CookieValue(value="age", defaultValue = "24") String age, 
			Model model ) {
		
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		
		return "session/get_cookie";
	}//getCookie
	
	//쿠키 삭제 : 기존의 코드를 그대로 사용
	@GetMapping("/remove_cookie.do")
	public String removeCookie( HttpServletResponse response ) {

		//1. 쿠키 생성( 값이 ㅇ벗도록 )
		Cookie cookie = new Cookie("name", "");
		Cookie cookie2 = new Cookie("age", "");
		//2. 생존 시간 0으로 설정
		cookie.setMaxAge(0);
		cookie2.setMaxAge(0);
		//3. 쿠기 심기
		response.addCookie(cookie);
		response.addCookie(cookie2);
		
		return "redirect:index.html";
	}//addCookie
	
}//class
