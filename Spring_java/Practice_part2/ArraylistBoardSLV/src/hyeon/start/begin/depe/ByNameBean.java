package hyeon.start.begin.depe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;

public class ByNameBean {

	private ByNameDTO byNameDTO;

	public ByNameDTO getByNameDTO() {
		return byNameDTO;
	}

	@Autowired
	public void setByNameDTO(ByNameDTO byNameDTO) {
		this.byNameDTO = byNameDTO;
	}

}
