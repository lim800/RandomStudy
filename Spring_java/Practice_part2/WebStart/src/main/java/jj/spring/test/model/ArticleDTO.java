package jj.spring.test.model;

import org.springframework.stereotype.Component;

@Component
public class ArticleDTO {
	private String title;
	private String content;
	private int number;
	
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	@Override
	public String toString() {
		return "ArticleDTO [title=" + title + ", content=" + content + ", number=" + number + "]";
	}

}
