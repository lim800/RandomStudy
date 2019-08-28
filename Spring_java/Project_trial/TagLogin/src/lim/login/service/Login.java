package lim.login.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lim.login.dao.LoginDAO;
import lim.login.model.LoginDTO;

@WebServlet("/Login.do")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Login() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		LoginDAO loginDAO = new LoginDAO();
		LoginDTO loginDTO = loginDAO.getUserLogin(id, pass);
		HttpSession session = request.getSession();
		if (loginDTO != null) {
			session.setAttribute("loginDTO", loginDTO);
			RequestDispatcher dispatcher = request.getRequestDispatcher("./session/loginSuccess.jsp");
			dispatcher.forward(request, response);
		} else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("아이디나 비밀번호가 틀렸습니다. <bt/> 다시 로그인을 클릭해 주세요.");
		}

	}

}
