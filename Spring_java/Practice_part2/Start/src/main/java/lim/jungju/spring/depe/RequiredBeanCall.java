package lim.jungju.spring.depe;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RequiredBeanCall {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("insert/RequiredBean.xml");
		RequiredBeanService requiredBeanService = (RequiredBeanService) context.getBean("requiredBeanService");
		RequiredBean requiredBean = requiredBeanService.requiredBean;
		System.out.println(requiredBean);
	}

}
