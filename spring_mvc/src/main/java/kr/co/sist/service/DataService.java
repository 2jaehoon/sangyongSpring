package kr.co.sist.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import kr.co.sist.domain.DataDomain;

public class DataService {
	public List<DataDomain> searchMember(){
		List<DataDomain> list = new ArrayList<DataDomain>();
		
		list.add(new DataDomain("À±»óÁØ", "sangjun@test.com"));
		list.add(new DataDomain("È²ÃæÃæ", "chung@daum.net"));
		list.add(new DataDomain("±è°æÅÂ", "tae@naver.com"));
		list.add(new DataDomain("ÀÌÀçÈÆ", "chungyeon@google.com"));
		
		if( new Random().nextBoolean() ){
			list.add(new DataDomain("±è±Ô¹Ì", "kim@google.com"));
		}
		if( new Random().nextBoolean() ){
			list.add(new DataDomain("¸ğ¹Î°æ", "momo@nate.com"));
		}
		
		return list;
	}//searchMember
}//class
