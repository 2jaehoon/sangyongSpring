package kr.co.sist.vo;

import org.springframework.web.bind.annotation.RequestParam;

/**
 * Framework�� ��ü�� ������ ������ �⺻ �����ڸ� ����ϱ� ������ �����ڴ� 
 * �����ڸ� �������� �ʰ� getter method�� setter method�� �ۼ��Ѵ�.
 * 
 * �⺻���� ���ǵǴ� ��쿡�� @RequestParam�� setter�� �Ű����� �տ� �����Ѵ�. 
 * @author user
 *
 */
public class RequestParamVO {
	
	private String name;
	private int age;
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("setName : " + name);
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(@RequestParam(defaultValue = "1") int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "RequestParamVO [name=" + name + ", age=" + age + "]";
	}
	
	

}
