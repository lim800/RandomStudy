package lim.jungju.spring.depe;

public class RequiredBean {

	String username;
	int age;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "이름 : " + username + ", 나이 : " + age;
	}
}
