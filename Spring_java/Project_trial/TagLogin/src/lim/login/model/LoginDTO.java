package lim.login.model;

public class LoginDTO {
	private String id;
	private String pass;
	private String name;
	private int age;

	public String getId() {
		return id;
	}

	public String getPass() {
		return pass;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
