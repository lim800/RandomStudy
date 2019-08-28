package hyeon.start.begin.scan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScanBeanService {
	@Autowired
	ScanBean scanBean;

	@Override
	public String toString() {
		return "친애하는 " + scanBean;
	}
}
