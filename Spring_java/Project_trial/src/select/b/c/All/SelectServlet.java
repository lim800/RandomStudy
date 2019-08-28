package select.b.c.All;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SelectDAO")
public class SelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SelectDAO selectDAO = new SelectDAO();
		SelectDTO selectDTO = new SelectDTO();
//
//		response.setContentType("text/html;charset=UTF-8");
////		PrintWriter out = response.getWriter();

		int name = Integer.parseInt(request.getParameter("deptno"));

		selectDTO = selectDAO.select(name);

		response.sendRedirect("./select/Select_View.jsp?deptno=" + selectDTO.getDeptno() + "&dname="
				+ selectDTO.getDname() + "&loc=" + selectDTO.getLoc());
	}
}