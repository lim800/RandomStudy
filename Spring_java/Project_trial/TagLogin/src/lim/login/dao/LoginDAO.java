package lim.login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import lim.login.model.LoginDTO;

public class LoginDAO {
	public LoginDTO getUserLogin(String id, String pass) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		LoginDTO loginDTO = null;
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mysql");
			connection = dataSource.getConnection();
			System.out.println(connection);

			String sql = "select * from taglogin ";
			sql += " where id=? and pass=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, id);
			System.out.println("아이디 " + id);
			preparedStatement.setString(2, pass);
			System.out.println("패스워드 " + pass);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				loginDTO = new LoginDTO();
				loginDTO.setId(resultSet.getString("id"));
				System.out.println(resultSet.getString("id"));
				loginDTO.setPass(resultSet.getString("pass"));
				loginDTO.setName(resultSet.getString("name"));
				loginDTO.setAge(resultSet.getInt("age"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return loginDTO;
	}

}
