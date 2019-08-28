package lachata.spring.jj.dept_dao;

import java.util.HashMap;
import java.util.List;


import lachata.spring.jj.dept_dto.DeptDTO;


public interface Dept_DAO {

	public List<DeptDTO> SelectAll();
	

	int Insert(HashMap<String, Object> hashmap); 
	

	
}