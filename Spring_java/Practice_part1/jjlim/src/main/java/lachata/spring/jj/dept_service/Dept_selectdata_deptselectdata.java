package lachata.spring.jj.dept_service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbcp2.BasicDataSource;

import dept.action.dept_action.Action;
import dept.dto.dept_dto.DeptDTO;
import dept.model.dept_model.ActionCommand;

public class Dept_selectdata_deptselectdata implements Action{

	@Override
	public ActionCommand execute(HttpServletRequest request, HttpServletResponse respson) {
		
		
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		ResultSet resultSet = null;
		Context context;
		ArrayList<DeptDTO> arrayList = new ArrayList<DeptDTO>();
		try {
			context = new InitialContext();
			BasicDataSource basicDataSource = (BasicDataSource) context.lookup("java:comp/env/jdbc/db");
			try {
				connection = basicDataSource.getConnection();
				System.out.println(connection);
				String sql = "select * from dept ";
				sql += " where deptno = ?";
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, deptno);
				resultSet = preparedStatement.executeQuery();

				while (resultSet.next()) {
					DeptDTO DeptDTO = new DeptDTO();
					DeptDTO.setDeptno(resultSet.getInt("deptno"));
					DeptDTO.setDname(resultSet.getString("dname"));
					DeptDTO.setLoc(resultSet.getString("loc"));
					System.out.println(resultSet.getString("loc"));
					arrayList.add(DeptDTO);
				}
			} catch (SQLException e) {

				e.printStackTrace();
			}
		} catch (NamingException e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}

		request.setAttribute("ddd", arrayList);
		
		ActionCommand actionCommand = new ActionCommand();
		actionCommand.setRedirect(false);
		actionCommand.setPath("./Updatedata/send.jsp");
		
		return actionCommand;
	}

}
