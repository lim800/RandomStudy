package lim.a.b.dao;

import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lim.a.b.dto.DTO;

@Repository
public class DAO {
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public List<DTO> selectAll() {
		return sqlSessionTemplate.selectList("selectAll");
	}
	public void insert(DTO dto) {
		sqlSessionTemplate.insert("insert", dto); 
	}
	
	public DTO select(int deptno) {
		return sqlSessionTemplate.selectOne("select", deptno); 
	}
	
	public void update(DTO dto) {
		sqlSessionTemplate.update("update", dto); 
	}
	
	public void delete(int deptno) {
		sqlSessionTemplate.delete("delete", deptno); 
	}
	

//	public DAO() {
//		String resource = "configuration/Configuration.xml";
//		Reader reader = null;
//		try {
//			reader = Resources.getResourceAsReader(resource);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
//		try {
//			reader.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}

//	public List<DTO> selectAll() {
//		List<DTO> list = null;
//		SqlSession sqlSession = sqlSessionFactory.openSession(true);
//		try {
//			list = sqlSession.selectList("selectAll");
//		} finally {
//			sqlSession.close();
//		}
//		return list;
//	}

//	public void insert(DTO dto) {
//		SqlSession sqlSession = sqlSessionFactory.openSession(true);
//		sqlSession.insert("insert", dto);
//		sqlSession.close();
//	}
//
//	public DTO select(int deptno) {
//		DTO dto = null;
//		SqlSession sqlSession = sqlSessionFactory.openSession(true);
//		dto = sqlSession.selectOne("select", deptno);
//		sqlSession.close();
//		return dto;
//	}
//
//	public void update(DTO dto) {
//		SqlSession sqlSession = sqlSessionFactory.openSession(true);
//		sqlSession.update("update", dto);
//		sqlSession.close();
//	}
//
//	public void delete(int deptno) {
//		SqlSession sqlSession = sqlSessionFactory.openSession(true);
//		sqlSession.delete("delete", deptno);
//		sqlSession.close();
//	}

}
