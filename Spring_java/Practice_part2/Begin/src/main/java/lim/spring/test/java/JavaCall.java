package lim.spring.test.java;

public class JavaCall {
	
	public static void main(String[] args) {
		
		Parameter parameter = new Parameter();
		ParameterBean parameterBean = new ParameterBean(parameter);
		parameterBean.msg();
	}

}
