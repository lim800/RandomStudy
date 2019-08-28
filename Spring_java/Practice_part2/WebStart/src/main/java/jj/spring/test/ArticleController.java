package jj.spring.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jj.spring.test.model.ArticleDTO;
import jj.spring.test.service.ArticleService;

@Controller
@RequestMapping("/article")
public class ArticleController {
	@Autowired
	private ArticleService articleService;

//	public void setArticleService(ArticleService articleService) {
//		this.articleService = articleService;
//	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String form() {
		return "./article/articleform";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String submit(@ModelAttribute("write") ArticleDTO articleDTO) {
		articleService.writeArticle(articleDTO);
		return "./article/articleview";
	}

	

}
