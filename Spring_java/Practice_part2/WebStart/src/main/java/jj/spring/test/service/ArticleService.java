package jj.spring.test.service;

import org.springframework.stereotype.Service;

import jj.spring.test.model.ArticleDTO;

@Service 
public class ArticleService {
	public void writeArticle(ArticleDTO articleDTO) {
		System.out.println("글 등록: " + articleDTO);
	}
}
