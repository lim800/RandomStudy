package lachata.spring.jj.dept_service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dept.action.dept_action.Action;
import dept.dao.dept_dao.Dept_DAO;
import dept.model.dept_model.ActionCommand;

public class Dept_update_deptupdate implements Action{

	@Override
	public ActionCommand execute(HttpServletRequest request, HttpServletResponse respson) {
		
		// ?„ ?ƒ?œ ë¶??„œ ?…Œ?´ë¸”ì˜ ?‚´?š©?„ send.jsp?—?„œ ê°????˜´
				int deptno = Integer.parseInt(request.getParameter("deptno"));
				String dname = request.getParameter("dname");
				String loc = request.getParameter("loc");
				aaaaaDAO dept_DAO = new aaaaaDAO();
				//?„ ?ƒ?•œ ë¶??„œ?˜ ? •ë³´ë?? ?ˆ˜? •?•¨
				int count = dept_DAO.update(deptno, dname, loc);
				//ë¶??„œ ? •ë³? ?ˆ˜? • ê²°ê³¼ë¥? viewë¡? ë³´ì—¬ì¤?
				
				ActionCommand actionCommand = new ActionCommand();
				actionCommand.setRedirect(true);
				actionCommand.setPath("./Updatedata/view.jsp?cnt=" + count);
				
				return actionCommand;
	}

}
