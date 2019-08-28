package lim.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanConcall {
	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("in/bean.xml");
		
		BeanCon beanCon = (BeanCon)applicationContext.getBean("beanCon");
		
		beanCon.name("홍길동");
		
		
		
	}
}
