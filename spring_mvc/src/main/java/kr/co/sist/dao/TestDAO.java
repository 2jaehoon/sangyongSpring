package kr.co.sist.dao;

import java.util.ArrayList;
import java.util.List;

public class TestDAO {
	
	public List<String> select(){
		List<String> list = new ArrayList<String>();
		
		list.add("Java SE");
		list.add("JDBC");
		list.add("Oracle DBMS");
		list.add("CSS");
		list.add("HTML");
		
		return list;
	}

}
