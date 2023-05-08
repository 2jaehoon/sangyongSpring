package kr.co.sist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//HandlerMapper�� ã�� �� �ֵ��� annotation�� ����
@Controller
public class MethodController {

	//URL�� method���� ó���� �� �ֵ��� annotation�� ����
	// @RequestMapping( value = "/get.do", method =RequestMethod.GET )//value���� ��ũ�� ����ϸ� /WEB-INF/views/(���ϰ�)�� ���� �⺻���� �̵������ ������
	@GetMapping("/get.do")
	public String getProcess() {
		
		//view�� �� JSP�� (ViewResolver�� prefix�� suffix�� �ٿ��� ã�´�.)
		//get�� ��ȯ�Ǹ�  /WEB-INF/views/get.jsp�� �ȴ�.
		return "get";
	}//getProcess
	
	//URL�� method���� ó���� �� �ֵ��� annotation�� ����
	// @RequestMapping( value = "/post.do", method =RequestMethod.POST )//value���� ��ũ�� ����ϸ� /WEB-INF/views/(���ϰ�)�� ���� �⺻���� �̵������ ������
	@PostMapping("/post.do")
	public String postProcess() {
		
		//view�� �� JSP�� (ViewResolver�� prefix�� suffix�� �ٿ��� ã�´�.)
				//post�� ��ȯ�Ǹ�  /WEB-INF/views/post.jsp�� �ȴ�.
		return "post";
	}//postProcess
	
	//method�� GET��İ� POST����� ��� ó���� �� �ֵ��� ����
	//method�� �迭�� ó���Ѵ�. 
	@RequestMapping(value = "/get_post.do", method = {RequestMethod.GET, RequestMethod.POST })
	public String getPost() {
		return "get_post";
	}//getPost
	
	//Spring MVC������ ��Ű������ URL�� �ݿ����� �ʱ� ������ ����� �۾���
	//���� ������ ������ �̸��� ����Ͽ� ��θ� �����.
	//@RequestMapping( value="/�������̸�/�������̸�" )
	
	@RequestMapping(value = "/work/path.do", method=RequestMethod.GET )
	public String path() {
		return "path";
	}
	
	//��û URL�� ���� JSP���� ���� ��� ��ȯ���� void�� ���� �� �ִ�.
	@RequestMapping(value = "/same_url.do", method=RequestMethod.GET )
	public void sameURL() {
	 System.out.println("sameURL method�� ȣ��");
	}
	
		
	
	
}//class
