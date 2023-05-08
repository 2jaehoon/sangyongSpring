package kr.co.sist.vo;

import java.util.Arrays;

public class ParamVO {
	private String name, addr, domain, info;
	private int age;
	private String[] hobby;
	
	public ParamVO() {
		
	}

	public ParamVO(String name, String addr, String domain, String info, int age, String[] hobby) {
		this.name = name;
		this.addr = addr;
		this.domain = domain;
		this.info = info;
		this.age = age;
		this.hobby = hobby;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String[] getHobby() {
		return hobby;
	}

	public void setHobby(String[] hobby) {
		this.hobby = hobby;
	}

	@Override
	public String toString() {
		return "ParamVO [name=" + name + ", addr=" + addr + ", domain=" + domain + ", info=" + info + ", age=" + age
				+ ", hobby=" + Arrays.toString(hobby) + "]";
	}

	
	
	
}
