package delete.b.c.All;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.commons.dbcp2.BasicDataSource;

public class Dept_DAO {
	
	public ArrayList<DeptDTO> select() {
		Connection connection = null;

		ArrayList<DeptDTO> arrayList = new ArrayList<DeptDTO>();
		String sql = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			Context context = new InitialContext();
			BasicDataSource basicDataSource = (BasicDataSource) context.lookup("java:comp/env/jdbc/db");
			try {
				connection = basicDataSource.getConnection();
				System.out.println(connection);
				sql = "select * from dept";
				preparedStatement = connection.prepareStatement(sql);
				System.out.println(sql);
				resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					DeptDTO deptDTO = new DeptDTO();
					int deptno = resultSet.getInt("deptno");
					String dname = resultSet.getString("dname");
					String loc = resultSet.getString("loc");
					deptDTO.setDeptno(deptno);
					deptDTO.setDname(dname);
					deptDTO.setLoc(loc);
					arrayList.add(deptDTO);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
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
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return arrayList;
	}
	
	public int delete(int deptno) {
		Connection connection = null;
		String sql = null;
		PreparedStatement preparedStatement = null;

		int count = 0;
		
		try {
			Context context = new InitialContext();
			BasicDataSource basicDataSource = (BasicDataSource) context.lookup("java:comp/env/jdbc/db");
			try {
				connection = basicDataSource.getConnection();
				System.out.println(connection);
				sql = "delete from dept where deptno = " + deptno;
				preparedStatement = connection.prepareStatement(sql);
				System.out.println(sql);
				count = preparedStatement.executeUpdate();



			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					preparedStatement.close();
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
		return count;

	}

}
