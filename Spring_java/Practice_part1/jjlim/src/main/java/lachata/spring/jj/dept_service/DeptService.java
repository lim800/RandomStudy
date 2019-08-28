package lachata.spring.jj.dept_service;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lachata.spring.jj.dept_dao.Dept_DAO;
import lachata.spring.jj.dept_dto.DeptDTO;

@Service
public class DeptService implements Dept_DAO {

	@Autowired
	private SqlSessionTemplate sqlsessiontemplate;
	
	@Override
	public List<DeptDTO> SelectAll() {		
		
		return sqlsessiontemplate.selectList("selectAll");
	}

	@Override
	public int Insert(HashMap<String, Object> hashmap) {
		
		return sqlsessiontemplate.update("insert", hashmap);
	}



}
