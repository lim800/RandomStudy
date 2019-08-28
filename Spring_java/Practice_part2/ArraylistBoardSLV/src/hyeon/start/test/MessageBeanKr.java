package hyeon.start.test;

public class MessageBeanKr implements MessageBean {

	@Override
	public void Message(String name) {
		System.out.println("안녕하세요. " + name);
	}

}
