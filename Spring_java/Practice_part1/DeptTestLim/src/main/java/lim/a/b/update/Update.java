package lim.a.b.update;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import lim.a.b.dao.DAO;
import lim.a.b.dto.DTO;

public class Update {

	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("classpath:/template/DBtemplate.xml");
		DAO dao = (DAO) context.getBean(DAO .class);
		DTO dto = (DTO) context.getBean(DTO .class);
		dto = dao.select(50);
		if (dto == null) {
			System.out.println("업데이트 할 데이터가 없습니다.");
		} else {
			dto.setDeptno(50);
			dto.setDname("홍길동");
			dto.setLoc("서울");
			dao.update(dto);
			List<DTO> list = dao.selectAll();
			for (DTO deptBean2 : list) {
				System.out.println(deptBean2);
			}
			list.clear();
		}
	}

}
