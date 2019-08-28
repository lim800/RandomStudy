package lim.a.b.select;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import lim.a.b.dao.DAO;
import lim.a.b.dto.DTO;


public class Select {

	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("classpath:/template/DBtemplate.xml");
		DAO dao = (DAO) context.getBean(DAO .class);
		DTO dto = (DTO) context.getBean(DTO .class);
		dto = dao.select(50);
		if (dto == null) {
			System.out.println("출력할 데이터가 없습니다.");
		} else {
			System.out.println(dto);
		}
	}
}
