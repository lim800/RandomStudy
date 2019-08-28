package lim.spring.test.java;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JsonTest {
	
	
	@RequestMapping("/ajaxT")
	public String ajax_request() {
		return "./ajax/jsonT";
	}

}
