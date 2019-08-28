package lim.jungju.test.java;

public class ApplicationContextBean {
	
	public void call(String name) {
		System.out.println("이름 : " + name);
		
	}
	public ApplicationContextBean() {
		System.out.println("ApplcationContextBean 생성자 호출");
	}

}
