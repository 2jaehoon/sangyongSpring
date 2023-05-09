package kr.co.sist.domain;

public class DataDomain {
	private String name, email;

	public DataDomain() {
		
	}

	public DataDomain(String name, String email) {
		this.name = name;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "DataDomain [name=" + name + ", email=" + email + "]";
	}
	
	
}
