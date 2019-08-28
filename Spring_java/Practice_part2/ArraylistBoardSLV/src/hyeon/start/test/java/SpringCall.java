package hyeon.start.test.java;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringCall {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("injection/bean_injection.xml");
		ParameterBean parameterBean = context.getBean("parameterBean", ParameterBean.class);
		parameterBean.msg();
	}
}
