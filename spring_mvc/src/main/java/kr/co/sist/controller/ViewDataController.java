package kr.co.sist.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
	}
}
