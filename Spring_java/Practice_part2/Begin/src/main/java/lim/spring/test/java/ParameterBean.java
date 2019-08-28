package lim.spring.test.java;

public class ParameterBean {
	
	private Parameter parameter;
	
	public ParameterBean() {
		
	}

	public ParameterBean(Parameter parameter) {
		this.parameter = parameter;
	}
	
	public void msg() {
		parameter.insert();
		parameter.delete();
		
	}
	

}
