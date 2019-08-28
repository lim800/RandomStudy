package lim.jungju.spring.db;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class ConnectCall {
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("dbxml/conDB.xml");
		ConncectDB conncectDB = (ConncectDB) context.getBean("conncectDB");
		conncectDB.insert();
	}
}
