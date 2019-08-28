package select.b.c.All;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class SelectDAO {

	public SelectDTO select(int name) {
		SelectDTO selectDTO = new SelectDTO();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
//	response.setContentType("text/html;charset=UTF-8");
//	PrintWriter out = response.getWriter();

		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/oracledb");
			connection = dataSource.getConnection();
			String sql = "select deptno, dname, loc from dept ";
			sql += " where deptno = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, name);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				selectDTO.setDeptno(resultSet.getInt("deptno"));
				selectDTO.setDname(resultSet.getString("dname"));
				selectDTO.setLoc(resultSet.getString("loc"));

//			out.println(deptno + " " + dname + " " + loc + "<br/>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
			}
		}
		return selectDTO;
	}
}
