package lachata.spring.jj.dept_service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dept.action.dept_action.Action;
import dept.dao.dept_dao.Dept_DAO;
import dept.dto.dept_dto.DeptDTO;
import dept.model.dept_model.ActionCommand;

public class Dept_insert_deptinsert implements Action{

	@Override
	public ActionCommand execute(HttpServletRequest request, HttpServletResponse respson) {
		
				int deptno = Integer.parseInt(request.getParameter("deptno"));
				String dname = request.getParameter("dname");
				String loc = request.getParameter("loc");
				
				DeptDTO dto = new DeptDTO();
				dto.setDeptno(deptno);
				dto.setDname(dname);
				dto.setLoc(loc);
				
				aaaaaDAO dept_DAO = new aaaaaDAO();
				int count = dept_DAO.Input(deptno, dname, loc);
	

				ActionCommand actionCommand = new ActionCommand();
				actionCommand.setRedirect(true);
				actionCommand.setPath("./Insert/Insertview.jsp?cnt=" + count);
				
				return actionCommand;
	}

}
