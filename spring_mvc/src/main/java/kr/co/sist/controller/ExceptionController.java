package kr.co.sist.controller;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExceptionController {
	
	//method에서 발생된 예외는 DIspatcherServlet이 잡아서 만들어진 예외페이지로 
	//이동하여 에러메시지를 보여준다. => 내가 만든 페이지에서 예외를 보여주고 싶다.
	//=> @ExceptionHandler를 사용
	@GetMapping("/test_exception.do")
	public String testException() throws ClassNotFoundException {
		
		if( new Random().nextBoolean() ) {
			throw new ClassNotFoundException("클래스가 없습니다.");
			
		}
		
		return "exception/success";
		
		
	}//testException
	
	//1. annotation 설정(처리할 예외클래스와 동일한 클래스 설정)
	@ExceptionHandler(ClassNotFoundException.class)
	//2. method가 M.A.V를 반환하고 예외를 매개변수로 설정
	public ModelAndView exceptionProcess(ClassNotFoundException cnfe ) {
		ModelAndView mav = new ModelAndView();
		//3. 예외 처리
		cnfe.printStackTrace();
		//4. 예외가 발생했을 때 보여줄 페이지 명을 설정
		mav.setViewName("exception/fail");
		mav.addObject("msg", "이것은 예외가 발생했을 때 보여줄 메시지입니다.");
		mav.addObject("simple_msg", cnfe.getMessage());
		
		
		return mav;
		
	}
	
	

}
