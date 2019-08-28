package hyeon.start.begin.scan;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ConfigurationClassPostProcessor;
import org.springframework.context.support.GenericXmlApplicationContext;

public class ScanBeanCall {
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("injection/bean_injection.xml");
		ScanBeanService scanBeanService = (ScanBeanService) context.getBean("scanBeanService");
		System.out.println(scanBeanService);
	}
}
