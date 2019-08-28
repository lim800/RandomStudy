package lachata.spring.jj.dept_service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dept.action.dept_action.Action;
import dept.dao.dept_dao.Dept_DAO;
import dept.model.dept_model.ActionCommand;

public class Dept_deletedata_deptdeletedata implements Action{

	@Override
	public ActionCommand execute(HttpServletRequest request, HttpServletResponse respson) {
		
		aaaaaDAO dept_DAO = new aaaaaDAO();
		//?��?��?�� deptno ?��보�?? 받아?��
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		// 받아?�� deptno�? 바탕?���? delete메서?�� ?��?��
		int count = dept_DAO.delete(deptno);
		// ?��?��?�� ?��?��?�� ?��?��?���?�? view ?��?���?�? ?��?��

		ActionCommand actionCommand = new ActionCommand();
		actionCommand.setRedirect(false);
		actionCommand.setPath("./Deletedata/delete_view.jsp?cnt=" + count);
		
		return actionCommand;
		
		
	}

}
