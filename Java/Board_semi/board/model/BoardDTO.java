package lim.board.model;

public class BoardDTO {

	private int num;
	private String id;
	private String passwd;
	private String subject;
	private String content;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override // 검증용
	public String toString() {
		return "BoardDTO [num=" + num + ", id=" + id + ", passwd=" + passwd + ", subject=" + subject + ", content="
				+ content + "]";
	}

}
