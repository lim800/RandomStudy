package lachata.spring.jj.dept_service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dept.action.dept_action.Action;
import dept.dao.dept_dao.Dept_DAO;
import dept.dto.dept_dto.DeptDTO;
import dept.model.dept_model.ActionCommand;

public class Dept_select_deptselectAll implements Action{

	@Override
	public ActionCommand execute(HttpServletRequest request, HttpServletResponse respson) {
		
		ArrayList<DeptDTO> arrayList = new ArrayList<DeptDTO>();

		aaaaaDAO dept_DAO = new aaaaaDAO();
		arrayList = dept_DAO.selectAll();

		request.setAttribute("AllDept", arrayList);
		
		ActionCommand actionCommand = new ActionCommand();
		actionCommand.setRedirect(false);
		actionCommand.setPath("./Select/SelectAll_View.jsp");
		
		return actionCommand;
	}

}
