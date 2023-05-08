package kr.co.sist.vo;

import org.springframework.web.bind.annotation.RequestParam;

/**
 * Framework이 객체를 생성할 때에는 기본 생성자만 사용하기 때문에 개발자는 
 * 생성자를 정의하지 않고 getter method와 setter method만 작성한다.
 * 
 * 기본형이 정의되는 경우에는 @RequestParam을 setter의 매개변수 앞에 정의한다. 
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
