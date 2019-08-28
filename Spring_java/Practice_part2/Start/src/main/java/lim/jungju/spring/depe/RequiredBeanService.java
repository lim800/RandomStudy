package lim.jungju.spring.depe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;

public class RequiredBeanService {
	RequiredBean requiredBean;

	public RequiredBean getRequiredBean() {
		return requiredBean;
	}

	@Autowired
	@Required
	public void setRequiredBean(RequiredBean requiredBean) {
		this.requiredBean = requiredBean;
	}
}
