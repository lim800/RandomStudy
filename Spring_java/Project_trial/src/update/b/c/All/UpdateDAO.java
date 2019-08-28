package update.b.c.All;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbcp2.BasicDataSource;

/**
 * Servlet implementation class DAO
 */
@WebServlet("/UpdateDAO")
public class UpdateDAO extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public UpdateDAO() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		String dname = request.getParameter("dname");
		String loc = request.getParameter("loc");
		PreparedStatement preparedStatement = null;
		Connection connection =null;
		Context context;
		int count = 0;
		try {
			context = new InitialContext();
			BasicDataSource basicDataSource = (BasicDataSource) context.lookup("java:comp/env/jdbc/OracleDB");
			//System.out.println(basicDataSource);
			try {
				connection = basicDataSource.getConnection();
				System.out.println(connection);
				String	sql = "update dept set dname = ?, loc = ? ";
				sql += " where deptno = ?";
				
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, dname);
				preparedStatement.setString(2, loc);
				preparedStatement.setInt(3, deptno);
				count = preparedStatement.executeUpdate();	
				
				if (count >0 ) {
					connection.commit();
				}else {
					connection.rollback();
				}
		
			} catch (SQLException e) {
				//out.println("해당 부서번호가 없습니다.");
				e.printStackTrace();
			}
		} catch (NamingException e) {
			e.printStackTrace();
		}finally{			
			try {				
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		response.sendRedirect("./update/view.jsp?cnt=" + count);
	
		
	}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
