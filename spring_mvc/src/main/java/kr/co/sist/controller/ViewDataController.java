package kr.co.sist.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.sist.domain.DataDomain;
import kr.co.sist.service.DataService;

@Controller
public class ViewDataController {

	//HttpServletRequest (scope ��ü)�� ����Ͽ� View�� �����͸� ����
	@GetMapping("/data_send/use_http_servlet_data.do")
	public String useHttpServlet( HttpServletRequest request ) {
		
		
		//web parameter �ޱ�
		//��ȿ�� ����
		//Service ��ü�κ��� View ���������� ����� ������ �ް� �����͸� ����
		DataService ds = new DataService();
		List<DataDomain> list = ds.searchMember();
		request.setAttribute("data", list);
		//view �������� ��ȯ
		return "view_data/use_request";
	}
}
