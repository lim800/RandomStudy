package hyeon.start.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class MessageBeanCall {
	public static void main(String[] args) {
		// 설정 파일 호출
		// 스프링의 new 자바의 new를 안쓰기 위함 동작은 같은 동작을 한다.
		FileSystemResource fileSystemResource = new FileSystemResource(
				"src/main/resources/injection/bean_injection.xml");

		BeanFactory factory = new XmlBeanFactory(fileSystemResource);
		MessageBean messageBean = factory.getBean("MessageBeanKr", MessageBean.class);
		messageBean.Message("홍길동");

	}

}
