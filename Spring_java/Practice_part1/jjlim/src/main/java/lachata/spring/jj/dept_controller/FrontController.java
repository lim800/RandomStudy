package lachata.spring.jj.dept_controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lachata.spring.jj.dept_dto.DeptDTO;
import lachata.spring.jj.dept_service.DeptService;

@Controller
public class FrontController {
	
	@Autowired
	private DeptService deptservice;
	
	@RequestMapping(value = "/SelectAllDAO")
	public String selectAll(HttpServletRequest request, HttpServletResponse response) {
		
		List<DeptDTO> list = deptservice.SelectAll();
		request.setAttribute("selectAll", list);
		return "/selectall/SelectAll_View";
	}
	
	@RequestMapping(value = "/InsertDAO")
	public String moveInsert() {
		
		return "/Insert/Insertdata";
	}
	
	@RequestMapping(value = "/InsertDAOO")
	public String Insert(HttpServletRequest request, HttpServletResponse response) {
		
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		String dname = request.getParameter("dname");
		String loc = request.getParameter("loc");
		
		HashMap<String, Object> hashmap = new HashMap<String, Object>(); 
		hashmap.put("deptno", deptno);
		hashmap.put("dname", dname);
		hashmap.put("loc", loc);
		
		
		int cnt = deptservice.Insert(hashmap);
		request.setAttribute("count", cnt);
		
		
		return "/Insert/Insertview";
	}
	
	@RequestMapping(value = "/Select")
	public String select(HttpServletRequest request, HttpServletResponse response) {
		
		List<DeptDTO> list = deptservice.Select();
		request.setAttribute("select", list);
		return "/selectall/SelectAll_View";
	}
	
	
}



