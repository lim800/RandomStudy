package lim.spring.test.java;

public class Begin {
	private static Begin begin;
	
	public static Begin getInstance() {
		if (begin==null) {
			begin = new Begin();
		}
		
		return begin;
	}
	private Begin() {
		System.out.println("Begin method calling");
		
	}
	
	public void getMess() {
		System.out.println("getMess method calling");
	}
	
	
	
}
