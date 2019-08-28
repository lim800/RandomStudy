package lim.spring.test.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JsonGet {
	private static final Logger LOGGER = LoggerFactory.getLogger(JsonGet.class);
	
	@ResponseBody
	@RequestMapping(value = "/jsong", method = RequestMethod.GET, produces = "application/json")
	public List<Map<String, Object>> ajax_receive(){
		LOGGER.info("메서드 출력");
		
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		for(int i = 0; i <3; i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("name", "name" + i);
			map.put("id", "id" + i);
			list.add(map);
			
		}
		return list;
		
	}
	@RequestMapping("/ajaxgettest")
	public String ajax_request() {
		return "jsontextg";
	}
	
	
	
}
