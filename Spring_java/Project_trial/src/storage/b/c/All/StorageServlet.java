package storage.b.c.All;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/StorageServlet")
public class StorageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		 
		int deptno = Integer.parseInt( request.getParameter("deptno"));
		String dname = request.getParameter("dname");
		String loc = request.getParameter("loc");
		
		//System.out.println(deptno);System.out.println(dname);System.out.println(loc);

		StorageDTO dto = new StorageDTO();
		dto.setDeptno(deptno);
		dto.setDname(dname);
		dto.setLoc(loc);
		
		
		StorageDAO inputDAO = new StorageDAO();
		int count = inputDAO.input(deptno, dname, loc);
		response.sendRedirect("./storage/ViewStorage.jsp?cnt=" + count);

	}
}
