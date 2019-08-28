package hyeon.board.smboard.model;

import java.sql.Date;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class BoardVO {
	private int num;
	private String name;
	private String pass;
	private String subject;
	private String content;
	private MultipartFile filename;
	private String attached_file;
	private int answer_num;
	private int answer_lev;
	private int answer_seq;
	private int read_count;
	private Date write_date;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
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

	public String getAttached_file() {
		return attached_file;
	}

	public MultipartFile getFilename() {
		return filename;
	}

	public void setFilename(MultipartFile filename) {
		this.filename = filename;
	}

	public void setAttached_file(String attached_file) {
		this.attached_file = attached_file;
	}

	public int getAnswer_num() {
		return answer_num;
	}

	public void setAnswer_num(int answer_num) {
		this.answer_num = answer_num;
	}

	public int getAnswer_lev() {
		return answer_lev;
	}

	public void setAnswer_lev(int answer_lev) {
		this.answer_lev = answer_lev;
	}

	public int getAnswer_seq() {
		return answer_seq;
	}

	public void setAnswer_seq(int answer_seq) {
		this.answer_seq = answer_seq;
	}

	public int getRead_count() {
		return read_count;
	}

	public void setRead_count(int read_count) {
		this.read_count = read_count;
	}

	public Date getWrite_date() {
		return write_date;
	}

	public void setWrite_date(Date write_date) {
		this.write_date = write_date;
	}

}
