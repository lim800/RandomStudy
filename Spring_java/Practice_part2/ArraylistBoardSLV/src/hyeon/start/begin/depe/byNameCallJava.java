package hyeon.start.begin.depe;

public class byNameCallJava {
	public static void main(String[] args) {

		ByNameDTO byNameDTO = new ByNameDTO();
		byNameDTO.setName("홍길동");
		byNameDTO.setAge("33");

		ByNameBean byNameBean = new ByNameBean();
		byNameBean.setByNameDTO(byNameDTO);
		System.out.println(byNameBean);
	}
}
