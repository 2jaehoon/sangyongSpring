package kr.co.sist.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.sist.domain.DataDomain;
import kr.co.sist.service.DataService;

@Controller
public class ViewDataController {

	//HttpServletRequest (scope 객체)를 사용하여 View로 데이터를 전달
	@GetMapping("/data_send/use_http_servlet_data.do")
	public String useHttpServlet( HttpServletRequest request ) {
		
		
		//web parameter 받기
		//유효성 검증
		//Service 객체로부터 View 페이지에서 사용할 데이터 받고 데이터를 설정
		DataService ds = new DataService();
		List<DataDomain> list = ds.searchMember();
		request.setAttribute("data", list);
		//view 페이지명 반환
		return "view_data/use_request";
	}//useHttpServlet
	
	@GetMapping("/data_send/use_model.do")
	public String useModel( Model model ) {
		//Service 객체로부터 View 페이지에서 사용할 데이터 받고 입력받은 model 객체에 데이터를 설정
		DataService ds = new DataService();
		List<DataDomain> list = ds.searchMember();
		
		model.addAttribute("data", list);
		model.addAttribute("msg", "모델 인터페이스를 사용한 값");
		
		
		//view 페이지명 반환
		return "view_data/use_request";
	}//useModel
	
	//ModelAndView를 사용할 때에는 method의 반황형이 반드시 ModelAndView이어야 한다.
	@GetMapping("/data_send/use_model_and_view.do")
	public ModelAndView useModelAndView(  ) {
		//Service 객체로부터 View 페이지에서 사용할 데이터 받고 입력받은 model 객체에 데이터를 설정
		DataService ds = new DataService();
		List<DataDomain> list = ds.searchMember();
		
		//1. ModelAndView 생성
		ModelAndView mav = new ModelAndView();
		//2. view 페이지명과 데이터를 설정한다.
		
		mav.setViewName("view_data/use_request");
		mav.addObject("data", list);
		mav.addObject("msg", "modelandview 객체를 사용한 값");
		
		
		//ModelAndView 반환
		return mav;
	}//useModel
	
	
}
