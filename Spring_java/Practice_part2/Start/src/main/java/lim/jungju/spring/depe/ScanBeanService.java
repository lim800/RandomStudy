package lim.jungju.spring.depe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScanBeanService {
@Autowired
	ScanBean scanBean;

	@Override
	public String toString() {
		return "Dear " + scanBean;
	}
	
}
