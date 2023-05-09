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
	}//useHttpServlet
	
	@GetMapping("/data_send/use_model.do")
	public String useModel( Model model ) {
		//Service ��ü�κ��� View ���������� ����� ������ �ް� �Է¹��� model ��ü�� �����͸� ����
		DataService ds = new DataService();
		List<DataDomain> list = ds.searchMember();
		
		model.addAttribute("data", list);
		model.addAttribute("msg", "�� �������̽��� ����� ��");
		
		
		//view �������� ��ȯ
		return "view_data/use_request";
	}//useModel
	
	//ModelAndView�� ����� ������ method�� ��Ȳ���� �ݵ�� ModelAndView�̾�� �Ѵ�.
	@GetMapping("/data_send/use_model_and_view.do")
	public ModelAndView useModelAndView(  ) {
		//Service ��ü�κ��� View ���������� ����� ������ �ް� �Է¹��� model ��ü�� �����͸� ����
		DataService ds = new DataService();
		List<DataDomain> list = ds.searchMember();
		
		//1. ModelAndView ����
		ModelAndView mav = new ModelAndView();
		//2. view ��������� �����͸� �����Ѵ�.
		
		mav.setViewName("view_data/use_request");
		mav.addObject("data", list);
		mav.addObject("msg", "modelandview ��ü�� ����� ��");
		
		
		//ModelAndView ��ȯ
		return mav;
	}//useModel
	
	
}
