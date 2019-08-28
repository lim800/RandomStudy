package lachata.spring.jj.dept_controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import lachata.spring.jj.dept_action.Action;
import lachata.spring.jj.dept_model.ActionCommand;
import lachata.spring.jj.dept_service.Dept_insert_deptinsert;
import lachata.spring.jj.dept_service.Dept_select_deptselect;
import lachata.spring.jj.dept_service.Dept_select_deptselectAll;


@WebServlet("*.do")
public class DeptFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeptFrontController() {
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String requestURI = request.getRequestURI();
		String ContextPath = request.getContextPath();
		String pathURI = requestURI.substring(ContextPath.length());
		ActionCommand actionCommand = null;
		Action action = null;

		if (pathURI.equals("/SelectAllDAO.do")) {
			action = new Dept_select_deptselectAll();

			try {
				actionCommand = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (pathURI.equals("/SelectDAO.do")) {

			action = new Dept_select_deptselect();

			try {
				actionCommand = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (pathURI.equals("/Insertdata.do")) {

			action = new Dept_insert_deptinsert();

			try {
				actionCommand = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (pathURI.equals("/Selectlist.do")) {

			action = new Dept_selectlist_deptselectlist();

			try {
				actionCommand = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (pathURI.equals("/SelectData.do")) {

			action = new Dept_selectdata_deptselectdata();

			try {
				actionCommand = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (pathURI.equals("/UpdateData.do")) {

			action = new Dept_update_deptupdate();

			try {
				actionCommand = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (pathURI.equals("/Dept_select.do")) {

			action = new Dept_delete_deptdelete();

			try {
				actionCommand = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}else if (pathURI.equals("/Dept_delete.do")) {

			action = new Dept_deletedata_deptdeletedata();

			try {
				actionCommand = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}


		if (actionCommand != null) {
			if (actionCommand.isRedirect()) {
				response.sendRedirect(actionCommand.getPath());
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(actionCommand.getPath());
				dispatcher.forward(request, response);
			}
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		service(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		service(request, response);

	}

}
