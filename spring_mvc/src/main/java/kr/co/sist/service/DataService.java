package kr.co.sist.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import kr.co.sist.domain.DataDomain;

public class DataService {
	public List<DataDomain> searchMember(){
		List<DataDomain> list = new ArrayList<DataDomain>();
		
		list.add(new DataDomain("������", "sangjun@test.com"));
		list.add(new DataDomain("Ȳ����", "chung@daum.net"));
		list.add(new DataDomain("�����", "tae@naver.com"));
		list.add(new DataDomain("������", "chungyeon@google.com"));
		
		if( new Random().nextBoolean() ){
			list.add(new DataDomain("��Թ�", "kim@google.com"));
		}
		if( new Random().nextBoolean() ){
			list.add(new DataDomain("��ΰ�", "momo@nate.com"));
		}
		
		return list;
	}//searchMember
}//class
