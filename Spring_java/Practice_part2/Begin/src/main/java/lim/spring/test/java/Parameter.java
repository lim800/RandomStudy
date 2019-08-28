package lim.spring.test.java;

public class Parameter {
	private String name;

	public Parameter() {
	}
	
	public int insert() {
		System.out.println("insert calling");
		return 0;
	}
	
	public void delete() {
		System.out.println("삭제호출");
	}

}
