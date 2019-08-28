package lim.jungju.spring.depe;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BynameCall {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("insert/bean.xml");
		BynameBean bynameBean = (BynameBean) context.getBean("bynameBean");
		System.out.println(bynameBean.getBynameDTO());
	}

}
