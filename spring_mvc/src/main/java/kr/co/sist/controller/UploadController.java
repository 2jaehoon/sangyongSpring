package kr.co.sist.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Controller
public class UploadController {

	@PostMapping("/upload_frm/upload_process.do")
	public String uploadProcess(HttpServletRequest request, Model model) {
		String movePage="";
		
		//1. ���� ���� ��� ���
		File saveDir = new File("C:/Users/user/git/sangyongSpring/spring_mvc/src/main/webapp/upload");
		
		int fileSize = 1024*1024*30;//30M
		
		try {
			MultipartRequest mr = new MultipartRequest(request, saveDir.getAbsolutePath(), fileSize, "UTF-8", new DefaultFileRenamePolicy() );
			//model�� �Ҵ�� ���� JSP���� ${ requestScope.uploader }���ȴ�. 
			model.addAttribute("uploader", mr.getParameter("uploader"));
			model.addAttribute("age", mr.getParameter("age"));
			model.addAttribute("fileName", mr.getFilesystemName("file"));
			model.addAttribute("oriFileName", mr.getOriginalFileName("file"));
			
			movePage = "upload/upload_result";
		} catch (IOException e) {
			movePage = "redirect:upload_frm/upload_err.html";
			e.printStackTrace();
		}
		
		return movePage;
	}
	
}
