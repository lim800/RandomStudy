package lachata.spring.jj.dept_service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dept.action.dept_action.Action;
import dept.dao.dept_dao.Dept_DAO;
import dept.dto.dept_dto.DeptDTO;
import dept.model.dept_model.ActionCommand;

public class Dept_delete_deptdelete implements Action{

	@Override
	public ActionCommand execute(HttpServletRequest request, HttpServletResponse respson) {

		aaaaaDAO dept_DAO = new aaaaaDAO();
		//?†ÑÏ≤? ?Öå?ù¥Î∏? Íµ¨ÏÑ±?ùÑ Î≥¥Ïó¨Ï£ºÍ∏∞ ?úÑ?ï¥ select?ï®?àòÎ•? ?ç®?Ñú DTO ArrayList?òï?ÉúÎ°? ???û•
		ArrayList<DeptDTO> arrayList = dept_DAO.selectAll();
		//Î∂??Ñú ?Öå?ù¥Î∏? ?†ÑÏ≤? ?ç∞?ù¥?Ñ∞Î•? forward Î∞©Ïãù?úºÎ°? Deletedata/delete_send.jspÎ°? Î≥¥ÎÇ¥Ï§?
		request.setAttribute("dept", arrayList);
		
		ActionCommand actionCommand = new ActionCommand();
		actionCommand.setRedirect(false);
		actionCommand.setPath("./Deletedata/delete_send.jsp");
		
		return actionCommand;
		
		
		
	}

}
