package lim.jungju.spring.depe;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class ScanBeanCall {

	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("insert/bean2.xml");
		ScanBeanService scanBeanService = (ScanBeanService) context.getBean("scanBeanService");
		System.out.println(scanBeanService);
	}

}
