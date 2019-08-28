package select.b.c.All;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class SelectAllDAO {

	public ArrayList<SelectDTO> select() {
		ArrayList<SelectDTO> arrayList = new ArrayList<SelectDTO>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/oracledb");
			connection = dataSource.getConnection();
			String sql = "select deptno, dname, loc from dept ";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				SelectDTO selectDTO = new SelectDTO(); // 여러개를 받아서 저장해야되기 떄문에
				selectDTO.setDeptno(resultSet.getInt("deptno"));
				selectDTO.setDname(resultSet.getString("dname"));
				selectDTO.setLoc(resultSet.getString("loc"));
				arrayList.add(selectDTO);
			}
		} catch (Exception e) {
			System.out.println("레코드가 존재하지 않습니다.");
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
			}
		} return arrayList;
	}
}
