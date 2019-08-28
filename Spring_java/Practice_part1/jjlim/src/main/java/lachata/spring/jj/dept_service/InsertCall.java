package lachata.spring.jj.dept_service;

public class InsertCall {
	public static void main(String[] args) {
		try {
			ApplicationContext context = new GenericXmlApplicationContext("classpath:/template/DBtemplate.xml");
			DeptDTO deptDTO = (DeptDTO) context.getBean("deptDTO");
			DeptDAO deptDAO = (DeptDAO) context.getBean("deptDAO");
			deptDTO.setDeptno(50);
			deptDTO.setDname("ȫ�浿");
			deptDTO.setLoc("�λ�");
			deptDAO.insert(deptDTO);
			List<DeptDTO> list = deptDAO.selectAll();
			for (DeptDTO deptDTO2 : list) {
				System.out.println(deptDTO2);
			}
			list.clear();
		} catch (Exception e) {
			System.out.println("�Է��� �����Ͱ� �ֽ��ϴ�.");
		}
	}
}