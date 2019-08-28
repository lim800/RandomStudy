package lim.a.b.select;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import lim.a.b.dao.DAO;
import lim.a.b.dto.DTO;

public class SelectAll {
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("classpath:/template/DBtemplate.xml");
		DAO dao = (DAO) context.getBean(DAO .class);
		List<DTO> list = dao.selectAll();
		if (list.isEmpty()) {
			System.out.println("출력할 데이터가 없습니다.");
		} else {
			for (DTO dto : list) {
				System.out.println(dto);
			}
		}
		list.clear();
	}
}
