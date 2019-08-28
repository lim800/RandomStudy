package hyeon.start.begin.depe;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ByNameBeanCall {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("injection/bean_injection.xml");

		ByNameBean byNameBean = (ByNameBean) applicationContext.getBean("byNameBean");
		System.out.println(byNameBean.getByNameDTO());
	}
}
