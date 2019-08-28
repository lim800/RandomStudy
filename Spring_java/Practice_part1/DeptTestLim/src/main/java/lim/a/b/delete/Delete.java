package lim.a.b.delete;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import lim.a.b.dao.DAO;
import lim.a.b.dto.DTO;

public class Delete {

	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("classpath:/template/DBtemplate.xml");
		DAO dao = (DAO) context.getBean(DAO .class);
		DTO dto = (DTO) context.getBean(DTO .class);
		dto = dao.select(50);
		if (dto == null) {
			System.out.println("삭제할 데이터가 없습니다.");
		} else {
			dao.delete(50);
			List<DTO> list = dao.selectAll();
			for (DTO deptBean2 : list) {
				System.out.println(deptBean2);
			}
			System.out.println("데이터를 삭제했습니다.");
			list.clear();
		}
	}

}
