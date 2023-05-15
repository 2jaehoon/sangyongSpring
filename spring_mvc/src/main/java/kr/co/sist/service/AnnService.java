package kr.co.sist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.dao.AnnDAO;
import kr.co.sist.dao.TestDAO;

@Component
public class AnnService {
	
	@Autowired(required = false)
	private AnnDAO aDAO;
	
public String nameData() {
	return aDAO.getData();
}//nameData

}
