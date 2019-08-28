package lim.a.b.insert;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import lim.a.b.dao.DAO;
import lim.a.b.dto.DTO;

public class Insert {

	public static void main(String[] args) {
		try {
			ApplicationContext context = new GenericXmlApplicationContext("classpath:/template/DBtemplate.xml");
			DAO dao = (DAO) context.getBean(DAO .class);
			DTO dto = (DTO) context.getBean(DTO .class);
			dto.setDeptno(50);
			dto.setDname("홍길동");
			dto.setLoc("부산");
			dao.insert(dto);
			List<DTO> list = dao.selectAll();
			for (DTO deptBean2 : list) {
				System.out.println(deptBean2);
			}
			list.clear();
		} catch (Exception e) {
			System.out.println("입력할 데이터가 있습니다.");
		}
	}

}
