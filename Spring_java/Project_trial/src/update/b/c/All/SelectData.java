package update.b.c.All;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbcp2.BasicDataSource;

/**
 * Servlet implementation class SelectData
 */
@WebServlet("/SelectData")
public class SelectData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		response.setContentType("text/html; charset=UTF-8");
		PreparedStatement preparedStatement = null;
		Connection connection =null;
		ResultSet resultSet = null;
		Context context;
		ArrayList<UpdateDTO> arrayList = new ArrayList<UpdateDTO>();
		try {
			context = new InitialContext();
			BasicDataSource basicDataSource = (BasicDataSource) context.lookup("java:comp/env/jdbc/OracleDB");
			try {
				connection = basicDataSource.getConnection();			
				System.out.println(connection);
				String sql = "select * from dept ";
				sql += " where deptno = ?";
				preparedStatement = connection.prepareStatement(sql);	
				preparedStatement.setInt(1, deptno);
				resultSet = preparedStatement.executeQuery();
				
				while(resultSet.next()) {
					UpdateDTO dto = new UpdateDTO();
					dto.setDeptno( resultSet.getInt("deptno")); 
				    dto.setDname(resultSet.getString("dname")); 
					dto.setLoc(resultSet.getString("loc")) ;
					System.out.println(resultSet.getString("loc"));
					arrayList.add(dto);
				}
			} catch (SQLException e) {
				//out.println("해당 부서번호가 없습니다.");
				e.printStackTrace();
			}
		} catch (NamingException e) {
			e.printStackTrace();
		}finally{			
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		request.setAttribute("ddd", arrayList);
		RequestDispatcher dispatcher =  request.getRequestDispatcher("./send.jsp");
		dispatcher.forward(request, response);		

	
	}
}
