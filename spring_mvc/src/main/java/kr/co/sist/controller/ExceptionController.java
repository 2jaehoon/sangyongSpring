package kr.co.sist.controller;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExceptionController {
	
	//method���� �߻��� ���ܴ� DIspatcherServlet�� ��Ƽ� ������� ������������ 
	//�̵��Ͽ� �����޽����� �����ش�. => ���� ���� ���������� ���ܸ� �����ְ� �ʹ�.
	//=> @ExceptionHandler�� ���
	@GetMapping("/test_exception.do")
	public String testException() throws ClassNotFoundException {
		
		if( new Random().nextBoolean() ) {
			throw new ClassNotFoundException("Ŭ������ �����ϴ�.");
			
		}
		
		return "exception/success";
		
		
	}//testException
	
	//1. annotation ����(ó���� ����Ŭ������ ������ Ŭ���� ����)
	@ExceptionHandler(ClassNotFoundException.class)
	//2. method�� M.A.V�� ��ȯ�ϰ� ���ܸ� �Ű������� ����
	public ModelAndView exceptionProcess(ClassNotFoundException cnfe ) {
		ModelAndView mav = new ModelAndView();
		//3. ���� ó��
		cnfe.printStackTrace();
		//4. ���ܰ� �߻����� �� ������ ������ ���� ����
		mav.setViewName("exception/fail");
		mav.addObject("msg", "�̰��� ���ܰ� �߻����� �� ������ �޽����Դϴ�.");
		mav.addObject("simple_msg", cnfe.getMessage());
		
		
		return mav;
		
	}
	
	

}
