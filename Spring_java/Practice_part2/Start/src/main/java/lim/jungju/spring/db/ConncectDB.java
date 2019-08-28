package lim.jungju.spring.db;

import java.sql.Connection;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class ConncectDB {
	
	
//	DataSource dataSource;
//	@Inject
//	public void setDataSource(DataSource dataSource) {
//		this.dataSource = dataSource;
//	}
	@Inject
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void insert() {
		String sql = "insert into dept (deptno, dname, loc)";
		sql += " value(?,?,?)";
		jdbcTemplate.update(sql, 60, "홍길동", "부산");
		jdbcTemplate.update(sql, 60, "전우치", "서울");
	}



//	public void conn() {
//		Connection connection = null;
//		try {
//			connection = (Connection) dataSource.getConnection();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		System.out.println(connection);
//		
//	}
}
