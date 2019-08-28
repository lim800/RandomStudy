package web.spring.testcall;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Hello {
	@RequestMapping(value = "/hello")
	public ModelAndView hello() {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("./test/testjspcall");
		modelAndView.addObject("greeting", getHello());

		return modelAndView;
	}

	private String getHello() {
		String greeting = null;
		LocalDateTime localDateTime = null;
		@SuppressWarnings("static-access")
		int hours = localDateTime.now().getHour();

		if (hours >= 1 && hours <= 12) {
			greeting = "Good Morning";
		} else if (hours >= 12 && hours <= 16) {
			greeting = "Good Afternoon";
		} else if (hours >= 16 && hours <= 21) {
			greeting = "Good Evening";
		} else if (hours >= 21 && hours <= 24) {
			greeting = "Good Night";
		}

		return greeting;
	}

}
