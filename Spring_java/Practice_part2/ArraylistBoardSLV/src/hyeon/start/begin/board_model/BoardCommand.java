package hyeon.start.begin.board_model;

import org.springframework.stereotype.Component;

@Component
public class BoardCommand {
	// 데이터 베이스 컬럼과 일치한다.
	private String author;
	private String email;
	private String subject;
	private String content;
	private String passwd;

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	@Override
	public String toString() {
		return "BoardCommand [author=" + author + ", email=" + email + ", subject=" + subject + ", content=" + content
				+ ", passwd=" + passwd + "]";
	}

}
