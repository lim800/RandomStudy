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
		//Î∂??Ñú Î≤àÌò∏ Í≤??Éâ?ùÑ ?úÑ?ïò?ó¨ select Î©îÏÑú?ìú ?ù¥?ö©
		selectDTO = dept_DAO.select(name);
		// Í≤??Éâ?ù¥ ?Åù?Çú ?Ç¥?ö©?ùÑ view?éò?ù¥Ïß?Î°? ?†Ñ?Ü°?ïò?ó¨ ?ôï?ù∏
		
		
		ActionCommand actionCommand = new ActionCommand();
		actionCommand.setRedirect(true);
		actionCommand.setPath("./Select/Select_View.jsp?deptno=" + selectDTO.getDeptno() + "&dname="
				+ selectDTO.getDname() + "&loc=" + selectDTO.getLoc());
		
		return actionCommand;
	}

}
