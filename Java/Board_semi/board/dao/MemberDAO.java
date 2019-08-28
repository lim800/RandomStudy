package lim.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import lim.board.dbcp.Context;
import lim.board.model.MemberDTO;

public class MemberDAO {
//회원가입
	public void join(MemberDTO memberDTO) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Context context = new Context();
		String sql = null;
		try {
			DataSource dataSource = context.basicDataSource;
			connection = dataSource.getConnection();
			sql = "insert into member ";
			sql += " values (member_seq.nextval,?,?,?,?,?) ";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, memberDTO.getName());
			preparedStatement.setString(2, memberDTO.getId());
			preparedStatement.setString(3, memberDTO.getPasswd());
			preparedStatement.setInt(4, memberDTO.getAge());
			preparedStatement.setString(5, memberDTO.getEmail());
			int count = preparedStatement.executeUpdate();
			if (count > 0) {
				System.out.println("회원가입이 완료되었습니다.");
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
	}// 로그인

	public MemberDTO login(String id, String passwd) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		MemberDTO memberDTO = null;
		String sql = null;
		Context context = new Context();
		try {
			DataSource dataSource = context.basicDataSource;
			connection = dataSource.getConnection();
			sql = "select * from member ";
			sql += "where id=? and passwd=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, id);
			preparedStatement.setString(2, passwd);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String name = resultSet.getString("name");
				id = resultSet.getString("id");
				passwd = resultSet.getString("passwd");
				int age = resultSet.getInt("age");
				String email = resultSet.getString("email");
				memberDTO = new MemberDTO();
				memberDTO.setName(name);
				memberDTO.setId(id);
				memberDTO.setPasswd(passwd);
				memberDTO.setAge(age);
				memberDTO.setEmail(email);
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
		return memberDTO;
	}

//아이디 검색
	public boolean idUnique(String id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String sql = null;
		Context context = new Context();
		try {
			DataSource dataSource = context.basicDataSource;
			connection = dataSource.getConnection();
			sql = "select * from member ";
			sql += "where id=? ";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, id);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				id = resultSet.getString("id");
				System.out.print("중복된 아이디입니다. 다시 입력 해주세요. ");
				System.out.println();
				return false;
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
		return true;
	}

//회원 리스트
	public MemberDTO select() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String sql = null;
		MemberDTO memberDTO = null;
		try {
			Context context = new Context();
			DataSource dataSource = context.basicDataSource;
			connection = dataSource.getConnection();
			sql = "select num, name, id, passwd, age, email from member";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				memberDTO = new MemberDTO();
				String name = resultSet.getString("name");
				String id = resultSet.getString("id");
				String passwd = resultSet.getString("passwd");
				int age = resultSet.getInt("age");
				String email = resultSet.getString("email");
				memberDTO = new MemberDTO();
				memberDTO.setName(name);
				memberDTO.setId(id);
				memberDTO.setPasswd(passwd);
				memberDTO.setAge(age);
				memberDTO.setEmail(email);
			}
			resultSet.getRow();
			if (resultSet.getRow() == 0) {
				System.out.println("등록한 회원이 없습니다.");
			}
		} catch (Exception e) {
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
		return memberDTO;
	}

//회원 수정
	public MemberDTO update(String id, String passwd, String name, int age, String email) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = null;
		MemberDTO memberDTO = new MemberDTO();
		try {
			Context context = new Context();
			DataSource dataSource = context.basicDataSource;
			connection = dataSource.getConnection();
			sql = "update member set name = ?, passwd = ?, age =?, email =? ";
			sql += " where id = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, passwd);
			preparedStatement.setInt(3, age);
			preparedStatement.setString(4, email);
			preparedStatement.setString(5, id);
			preparedStatement.executeUpdate();
			System.out.println("회원정보를 수정하였습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return memberDTO;
	}

	// 회원 삭제
	public MemberDTO delete(String id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = null;
		MemberDTO memberDTO = new MemberDTO();
		try {
			Context context = new Context();
			DataSource dataSource = context.basicDataSource;
			connection = dataSource.getConnection();
			sql = "delete from member ";
			sql += " where id = ? ";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, id);
			preparedStatement.executeUpdate();
			System.out.println("회원을 삭제하였습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return memberDTO;
	}
}