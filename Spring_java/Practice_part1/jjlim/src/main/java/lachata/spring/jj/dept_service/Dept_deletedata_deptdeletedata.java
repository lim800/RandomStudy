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
		//?‚­? œ?•  deptno ? •ë³´ë?? ë°›ì•„?˜´
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		// ë°›ì•„?˜¨ deptnoë¥? ë°”íƒ•?œ¼ë¡? deleteë©”ì„œ?“œ ?‹¤?–‰
		int count = dept_DAO.delete(deptno);
		// ?‹¤?–‰?•œ ?‚´?š©?˜ ?‹¤?Œ¨?—¬ë¶?ë¥? view ?˜?´ì§?ë¡? ? „?†¡

		ActionCommand actionCommand = new ActionCommand();
		actionCommand.setRedirect(false);
		actionCommand.setPath("./Deletedata/delete_view.jsp?cnt=" + count);
		
		return actionCommand;
		
		
	}

}
