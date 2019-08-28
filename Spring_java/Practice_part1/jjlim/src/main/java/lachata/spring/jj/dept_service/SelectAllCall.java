package lachata.spring.jj.dept_service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import lachata.spring.jj.dept_dao.Dept_DAO;
import lachata.spring.jj.dept_dto.DeptDTO;

public class SelectAllCall {
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("classpath:/spring/root-context.xml");
		Dept_DAO dept_DAO = (Dept_DAO) context.getBean("dept_DAO");
		List<DeptDTO> list = dept_DAO.selectAll();
		if (list.isEmpty()) {
			System.out.println("출력할 데이터가 없습니다.");
		} else {
			for (DeptDTO deptDTO : list) {
				System.out.println(deptDTO);
			}
			list.clear();
		}
	}
}