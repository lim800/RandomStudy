package select.b.c.All;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SelectAllDAO")
public class SelectAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<SelectDTO> arrayList = new ArrayList<SelectDTO>();
		
		SelectAllDAO selectDAO = new SelectAllDAO();
		arrayList = selectDAO.select();
//		//get 방식만 가능함 // =? 를 추가하여 넘어가는 방법을 사용하면 String형태의 배열 형태처럼 전달하는것는 가능함 Arraylist는 안됨
//		response.sendRedirect("./Select/SelectAll_View.jsp"); 
//							

//		response.sendRedirect("./Select/SelectAll_View.jsp?deptno=" + resultSet);
		request.setAttribute("AllDept", arrayList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("./select/SelectAll_View.jsp");
		dispatcher.forward(request, response);
		
		
	}
}