package hyeon.start.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MessageConstCall {
	public static void main(String[] args) {

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("injection/bean_injection.xml");
		MessageConst messageConst = (MessageConst) applicationContext.getBean("messageConst");
		messageConst.name("존시나");
	}
}
