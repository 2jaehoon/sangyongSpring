package kr.co.sist.service;

import java.util.List;

import kr.co.sist.dao.TestDAO;

public class TestService {
	private TestDAO tDAO;
	
	public TestService(TestDAO tDAO) {
		this.tDAO = tDAO;
		System.out.println("TestService 의존성 주입 받은 생성자");
	}

	public List<String> search(){
	List<String> list = null;
	list=tDAO.select();
	return list;
}//search
	


}//class
