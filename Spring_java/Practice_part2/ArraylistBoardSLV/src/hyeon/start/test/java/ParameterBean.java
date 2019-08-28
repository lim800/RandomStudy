package hyeon.start.test.java;

public class ParameterBean {
	private Parameter parameter;

	public Parameter getParameter() {
		return parameter;
	}

	public void setParameter(Parameter parameter) {
		this.parameter = parameter;
	}

	public void msg() {
		parameter.insert();
		parameter.Delete();
	}

}
