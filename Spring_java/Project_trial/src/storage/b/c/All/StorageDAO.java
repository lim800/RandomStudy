package storage.b.c.All;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class StorageDAO
{
	
	public int input(int deptno , String dname , String loc) {
	
	
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	int count = 0;
	try {
		Context context = new InitialContext();
		DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/oracledb");
		connection = dataSource.getConnection();
		String sql = "insert into dept (deptno,dname,loc) ";
		sql += " values (?,?,?)";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, deptno);
		preparedStatement.setString(2, dname);
		preparedStatement.setString(3, loc);
		count = preparedStatement.executeUpdate();
		
		if (count >0 ) {
			connection.commit();
		}else {
			connection.rollback();
		}
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	

	
	return count; 
	
	}
	
	
	

}
