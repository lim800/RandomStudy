package lim.spring.test;

public class BeanCon {
	
	public BeanCon() {
		System.out.println("생성자 호출");
	}

	
	public void name(String name) {
		System.out.println(name + "호출한다.");
	}
}
