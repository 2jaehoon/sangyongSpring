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

@Controller //��û, web parameter, ���� ����, ��ü ���, view �������� ����
public class ParameterController {

	//����ڰ� ���� �Է��ϱ� ���� HTML Form Control�� ������ �ִ� �������� �̵��ϱ� ���� ��û
	@RequestMapping( value="/use_http_servlet", method =GET )
	public String paramForm() {
		return "parameter_form";
	}//paramForm
	
	//����ڰ� �Է��� ���� HttpServletRequest�� �ޱ� ���� ��û
	// HttpServletRequest�� ����ϸ� POJO�� �ƴϹǷ� �������� �ʴ´�.
	@RequestMapping(value = "/parameter_form_process.do", method = {GET, POST})
	public String paramFormProcess( HttpServletRequest request, Model model ) throws UnsupportedEncodingException {
		
		request.setCharacterEncoding("UTF-8"); //�ѱ� ó��
		//���� ���� : request ��ü�� ���Ǳ� ���� 
		
		//�̸��� ����
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String addr = request.getParameter("addr");
		String domain = request.getParameter("domain");
		String info = request.getParameter("info");
		//�̸� �ߺ�
		String[] hobby = request.getParameterValues("hobby");
		
		//�Է°��� ��ȿ�� ����
		//����������ü ���
		
		//�Էµ� �Ķ���͸� VO�� ���� : �����͸� �ϳ��� ��� ��� => ������ ���Ǽ�
		ParamVO pVO = new ParamVO(name, addr, domain, info, Integer.parseInt(age), hobby);
		
		
		model.addAttribute("data", pVO);
		
		System.out.println("�Է¹��� �� : " + pVO);
		
		//Service ��ü�� ����
		
		
		return "parameter_result";
	}//paramFormProcess
	
	
	//����ڰ� �Է��� ���� HttpServletRequest�� �ޱ� ���� ��û
	@RequestMapping( value="/single_param.do", method =GET )
	public String singleParamForm() {
		return "parameter_form2";
	}//singleParamForm
	
	
	//���������� web parameter �ޱ�
	//DispatcherServlet���� parameter�� ���� �� ȣ��� method�� �Ű������� �Ҵ����ش�.
	//���� : html form control��� �Ű��������� ���ƾ� �Էµȴ�.
	//���� : method header�� ������������.
	//���� : HttpServletRequest�� ������� �ʾƵ� �ȴ�. POJO
	       // �⺻�� ���������� ����ϸ� casting�Ͽ� �Է����ش�. => ������ �ɰ� �ִ�.
	@RequestMapping(value = "/parameter_form_process2.do", method = POST)
	public String singleParamFormProcess(
			/* HttpServletRequest request, */String name, int age, String addr, String domain,String info, String[] hobby, Model model ) throws UnsupportedEncodingException  {
		
		/*
		 * request.setCharacterEncoding("UTF-8"); //�ѱ� ó�� //���� ���� : request ��ü�� ���Ǳ� ����
		 */		
		
		//�Է°��� ��ȿ�� ����
		//����������ü ���
		
		//�Էµ� �Ķ���͸� VO�� ���� : �����͸� �ϳ��� ��� ��� => ������ ���Ǽ�
		ParamVO pVO = new ParamVO(name, addr, domain, info, age, hobby);
		
		
		model.addAttribute("data", pVO);
		
		System.out.println("�Է¹��� �� : " + pVO);
		
		//Service ��ü�� ����
		
		
		return "parameter_result";
	}//singleParamFormProcess
	
	
	//����ڰ� �Է��� ���� HttpServletRequest�� �ޱ� ���� ��û
		@RequestMapping( value="/vo_param.do", method =GET )
		public String voParamForm() {
			return "parameter_vo_form";
		}//voParamForm
	
	
		/**
		 * VO�� ����� web parameter ó��
		 * ���� : HTML Form Control�� ��� VO instance ������ �̸��� ���ƾ� �Էµȴ�.
		 * @param pVO
		 * @param model
		 * @return
		 */
		@RequestMapping(value = "/parameter_vo_form_process.do", method = POST)
		public String voParamFormProcess(ParamVO pVO, Model model )  {
			
		
			
			//�Է°��� ��ȿ�� ����
			//����������ü ���
			
			//�Էµ� �Ķ���͸� VO�� ���� : �����͸� �ϳ��� ��� ��� => ������ ���Ǽ�
			
			
			model.addAttribute("data", pVO);
			
			System.out.println("�Է¹��� �� : " + pVO);
			
			//Service ��ü�� ����
			
			
			return "parameter_result";
		}//singleParamFormProcess
		
		//@RequestParam�� ���
		//web��  web parameter�� ���ڿ��θ� �����ϴµ�, DispatcherServlet����
		//String�� �⺻������ ������ �־��ش�. �̋� parameter�� ���� ��츦 ����ؼ�
		// @RequestParam�� �����Ѵ�.
		@GetMapping("/use_request_param.do")
		public String useReqParam(String name,
				@RequestParam(defaultValue = "1") int age) {
			System.out.println("useReqParam : " + name + " / " + age);
			return "req_result";
		}
		
		//Framework�� ��ü�� ������ ������ �⺻ �����ڸ� ����ϰ�
		//���� ���� ������ setter method�� ����Ѵ�.
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
		
		//views�� ���� ������ ����� jsp�� �����Ͽ� ������ ��.
		@GetMapping("/sub_folder.do")
		public String subFolder() {
		return "sub/test";
		}
		
		
}//class
