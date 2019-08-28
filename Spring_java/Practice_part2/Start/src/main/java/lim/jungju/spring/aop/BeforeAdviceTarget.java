package lim.jungju.spring.aop;

import org.springframework.stereotype.Service;

@Service
public class BeforeAdviceTarget {
	public void call() {
		System.out.println("call 메서드를 호출한다.");
	}

}
