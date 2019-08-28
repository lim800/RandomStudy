package lachata.spring.jj.dept_dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

import dept.dto.dept_dto.DeptDTO;
public class aaaaaDAO {
	
	public ArrayList<DeptDTO> selectAll() {  
		Connection connection = null; 

		ArrayList<DeptDTO> arrayList = new ArrayList<DeptDTO>(); 
		String sql = null;
		PreparedStatement preparedStatement = null; 
		ResultSet resultSet = null;
		try {
			Context context = new InitialContext(); 
			BasicDataSource basicDataSource = (BasicDataSource) context.lookup("java:comp/env/jdbc/db"); //Ïª§ÎÑ•?Öò ?? Íµ¨ÌòÑ?ùÑ ?úÑ?ï¥ ?Ñ§?†ï 
			try {
				connection = basicDataSource.getConnection(); 
				sql = "select * from dept";
				//
				preparedStatement = connection.prepareStatement(sql);
				//resultset object?óê excuteQuery Î©îÏÑú?ìúÎ•? ?Ç¨?ö©?ïò?ó¨ sqlÎ¨? Í≤∞Í≥º ???û•
				resultSet = preparedStatement.executeQuery();
				
				//Î∂??Ñú ?Öå?ù¥Î∏îÏóê Í¥??†® ?Ç¥?ö© deptDTO?óê ???û•
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

	//Î∂??Ñú Î≤àÌò∏?óê ?î∞?ùº?Ñú ?ç∞?ñ¥?Ñ∞ ?Ç≠?†ú Í∏∞Îä•
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
				// Î∂??Ñú Î≤àÌò∏?óê ?î∞?ùº?Ñú ?ç∞?ù¥?Ñ∞ ?Ç≠?†ú ÏøºÎ¶¨
				sql = "delete from dept where deptno = " + deptno;
				preparedStatement = connection.prepareStatement(sql);
				System.out.println(sql);
				count = preparedStatement.executeUpdate();
				
				//ÏøºÎ¶¨Î¨? ?ã§?ñâ?õÑ ?ã§?ñâ?ù¥ ?†ï?ÉÅ?†Å?úºÎ°? ?êò?óà?ã§Î©? commit?ùÑ ?ïòÍ≥? ?ïÑ?ãåÍ≤ΩÏö∞ Î°§Î∞±?ùÑ ?ï®
				if (count > 0) {
					connection.commit();
				} else {
					connection.rollback();
				}

			} catch (SQLException e) {
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
	
	//Î∂??Ñú Î≤àÌò∏Î°? ?Öå?ù¥Î∏? ?Ç¥?ö© Í≤??Éâ Í∏∞Îä•
	public DeptDTO select(int name) {
		DeptDTO DeptDTO = new DeptDTO();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/db");
			connection = dataSource.getConnection();
			String sql = "select deptno, dname, loc from dept ";
			sql += " where deptno = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, name);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				DeptDTO.setDeptno(resultSet.getInt("deptno"));
				DeptDTO.setDname(resultSet.getString("dname"));
				DeptDTO.setLoc(resultSet.getString("loc"));
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
		return DeptDTO;
	}

	
	// ?ã†Í∑úÎ??Ñú ?ì±Î°ùÍ∏∞?ä•
	public int Input(int deptno, String dname, String loc) {

		//ArrayList<DeptDTO> arrayList = new ArrayList<DeptDTO>();

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int count = 0;

		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/db");
			connection = dataSource.getConnection();
			String sql = "insert into dept (deptno,dname,loc) ";
			sql += " values (?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, deptno);
			preparedStatement.setString(2, dname);
			preparedStatement.setString(3, loc);
			count = preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;

	}

	
	//Í∏∞Ï°¥ Î∂??Ñú Î∂??ÑúÎ≤àÌò∏?óê ?î∞?ùº ?†ïÎ≥? ?àò?†ï Í∏∞Îä•
	public int update(int deptno, String dname, String loc) {
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		Context context;
		int count = 0;
		try {
			context = new InitialContext();
			BasicDataSource basicDataSource = (BasicDataSource) context.lookup("java:comp/env/jdbc/db");
			try {
				connection = basicDataSource.getConnection();
				System.out.println(connection);
				String sql = "update dept set dname = ?, loc = ? ";
				sql += " where deptno = ?";

				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, dname);
				preparedStatement.setString(2, loc);
				preparedStatement.setInt(3, deptno);
				count = preparedStatement.executeUpdate();

				if (count > 0) {
					connection.commit();
				} else {
					connection.rollback();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (NamingException e) {
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return count;
	}

}
