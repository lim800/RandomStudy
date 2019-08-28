package lachata.spring.jj.dept_service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dept.action.dept_action.Action;
import dept.dao.dept_dao.Dept_DAO;
import dept.dto.dept_dto.DeptDTO;
import dept.model.dept_model.ActionCommand;

public class Dept_select_deptselect implements Action{

	@Override
	public ActionCommand execute(HttpServletRequest request, HttpServletResponse respson) {
		//ArrayList<DeptDTO> arrayList = new ArrayList<DeptDTO>();

		aaaaaDAO dept_DAO = new aaaaaDAO();
		DeptDTO selectDTO = new DeptDTO();
		
		
		int name = Integer.parseInt(request.getParameter("deptno"));
		//�??�� 번호 �??��?�� ?��?��?�� select 메서?�� ?��?��
		selectDTO = dept_DAO.select(name);
		// �??��?�� ?��?�� ?��?��?�� view?��?���?�? ?��?��?��?�� ?��?��
		
		
		ActionCommand actionCommand = new ActionCommand();
		actionCommand.setRedirect(true);
		actionCommand.setPath("./Select/Select_View.jsp?deptno=" + selectDTO.getDeptno() + "&dname="
				+ selectDTO.getDname() + "&loc=" + selectDTO.getLoc());
		
		return actionCommand;
	}

}
