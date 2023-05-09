package kr.co.sist.param;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.sist.vo.LoginVO;
import kr.co.sist.vo.ParamVO;
import kr.co.sist.vo.RequestParamVO;

@Controller //요청, web parameter, 관계 유지, 객체 사용, view 페이지명 응답
public class ParameterController {

	//사용자가 값을 입력하기 위한 HTML Form Control을 가지고 있는 페이지로 이동하기 위한 요청
	@RequestMapping( value="/use_http_servlet", method =GET )
	public String paramForm() {
		return "parameter_form";
	}//paramForm
	
	//사용자가 입력한 값을 HttpServletRequest로 받기 위한 요청
	// HttpServletRequest를 사용하면 POJO가 아니므로 권장하지 않는다.
	@RequestMapping(value = "/parameter_form_process.do", method = {GET, POST})
	public String paramFormProcess( HttpServletRequest request, Model model ) throws UnsupportedEncodingException {
		
		request.setCharacterEncoding("UTF-8"); //한글 처리
		//동작 조건 : request 객체가 사용되기 전에 
		
		//이름이 유일
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String addr = request.getParameter("addr");
		String domain = request.getParameter("domain");
		String info = request.getParameter("info");
		//이름 중복
		String[] hobby = request.getParameterValues("hobby");
		
		//입력값에 유효성 검증
		//관계유지객체 사용
		
		//입력된 파라메터를 VO에 설정 : 데이터를 하나로 묶어서 사용 => 관리의 편의성
		ParamVO pVO = new ParamVO(name, addr, domain, info, Integer.parseInt(age), hobby);
		
		
		model.addAttribute("data", pVO);
		
		System.out.println("입력받은 값 : " + pVO);
		
		//Service 객체에 전달
		
		
		return "parameter_result";
	}//paramFormProcess
	
	
	//사용자가 입력한 값을 HttpServletRequest로 받기 위한 요청
	@RequestMapping( value="/single_param.do", method =GET )
	public String singleParamForm() {
		return "parameter_form2";
	}//singleParamForm
	
	
	//단일형으로 web parameter 받기
	//DispatcherServlet에서 parameter를 받은 후 호출될 method의 매개변수로 할당해준다.
	//주의 : html form control명과 매개변수명이 같아야 입력된다.
	//단점 : method header가 지저분해진다.
	//장점 : HttpServletRequest를 사용하지 않아도 된다. POJO
	       // 기본형 데이터형을 사용하면 casting하여 입력해준다. => 문제를 앉고 있다.
	@RequestMapping(value = "/parameter_form_process2.do", method = POST)
	public String singleParamFormProcess(
			/* HttpServletRequest request, */String name, int age, String addr, String domain,String info, String[] hobby, Model model ) throws UnsupportedEncodingException  {
		
		/*
		 * request.setCharacterEncoding("UTF-8"); //한글 처리 //동작 조건 : request 객체가 사용되기 전에
		 */		
		
		//입력값에 유효성 검증
		//관계유지객체 사용
		
		//입력된 파라메터를 VO에 설정 : 데이터를 하나로 묶어서 사용 => 관리의 편의성
		ParamVO pVO = new ParamVO(name, addr, domain, info, age, hobby);
		
		
		model.addAttribute("data", pVO);
		
		System.out.println("입력받은 값 : " + pVO);
		
		//Service 객체에 전달
		
		
		return "parameter_result";
	}//singleParamFormProcess
	
	
	//사용자가 입력한 값을 HttpServletRequest로 받기 위한 요청
		@RequestMapping( value="/vo_param.do", method =GET )
		public String voParamForm() {
			return "parameter_vo_form";
		}//voParamForm
	
	
		/**
		 * VO를 사용한 web parameter 처리
		 * 주의 : HTML Form Control의 명과 VO instance 변수의 이름이 같아야 입력된다.
		 * @param pVO
		 * @param model
		 * @return
		 */
		@RequestMapping(value = "/parameter_vo_form_process.do", method = POST)
		public String voParamFormProcess(ParamVO pVO, Model model )  {
			
		
			
			//입력값에 유효성 검증
			//관계유지객체 사용
			
			//입력된 파라메터를 VO에 설정 : 데이터를 하나로 묶어서 사용 => 관리의 편의성
			
			
			model.addAttribute("data", pVO);
			
			System.out.println("입력받은 값 : " + pVO);
			
			//Service 객체에 전달
			
			
			return "parameter_result";
		}//singleParamFormProcess
		
		//@RequestParam의 사용
		//web은  web parameter를 문자열로만 전달하는데, DispatcherServlet에서
		//String을 기본형으로 변경해 넣어준다. 이떄 parameter가 없는 경우를 대비해서
		// @RequestParam를 선언한다.
		@GetMapping("/use_request_param.do")
		public String useReqParam(String name,
				@RequestParam(defaultValue = "1") int age) {
			System.out.println("useReqParam : " + name + " / " + age);
			return "req_result";
		}
		
		//Framework이 객체를 생성할 떄에는 기본 생성자를 사용하고
		//값을 넣을 떄에는 setter method를 사용한다.
		@GetMapping("/use_request_param2.do")
		public String useVoReqParam(RequestParamVO rpVO) {
			System.out.println("useReqParam : " + rpVO.getName() + " / " + rpVO.getAge());
			return "req_result";
		}
		
		@RequestMapping( value="/login_process.do", method =GET )
		public String loginForm(LoginVO lVO) {
			System.out.println("lVO : " + lVO.getId() + " / " + lVO.getPassword());
			return "login_result";
		}
		
		//views에 하위 폴더를 만들고 jsp를 구분하여 저장할 때.
		@GetMapping("/sub_folder.do")
		public String subFolder() {
		return "sub/test";
		}
		
		
}//class
