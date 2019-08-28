package web.spring.testcall;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RequestParamController {
	@RequestMapping("/requestparama.do")
	public ModelAndView mappinga(@RequestParam("id") String id, @RequestParam(value="pass") int pass) {
		System.out.println("아이디: " + id + ", 패스워드: " + pass );
		return new ModelAndView("./test/parameter");
	}
	@RequestMapping("/requestparamb.do")
	public ModelAndView mappingb(@RequestParam(value="ids", required=false) String id, @RequestParam(value="pass", defaultValue = "1234") int pass) {
		System.out.println("아이디: " + id + ", 패스워드: " + pass );
		return new ModelAndView("./test/parameter");
	}
}
