package lim.jungju.spring.depe;

public class BynamejavaCall {
	
	public static void main(String[] args) {
		
		BynameDTO bynameDTO = new BynameDTO();
		bynameDTO.setName("홍길동");
		bynameDTO.setAge("33");
		
		BynameBean bynameBean = new BynameBean();
		bynameBean.setBynameDTO(bynameDTO);
		System.out.println(bynameBean.getBynameDTO());
		
	}

}
