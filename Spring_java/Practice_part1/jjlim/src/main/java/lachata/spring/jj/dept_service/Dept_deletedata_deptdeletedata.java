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
		//?­? ?  deptno ? λ³΄λ?? λ°μ?΄
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		// λ°μ?¨ deptnoλ₯? λ°ν?Όλ‘? deleteλ©μ? ?€?
		int count = dept_DAO.delete(deptno);
		// ?€?? ?΄?©? ?€?¨?¬λΆ?λ₯? view ??΄μ§?λ‘? ? ?‘

		ActionCommand actionCommand = new ActionCommand();
		actionCommand.setRedirect(false);
		actionCommand.setPath("./Deletedata/delete_view.jsp?cnt=" + count);
		
		return actionCommand;
		
		
	}

}
