package lim.jungju.spring.aop.log;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


public class LoggingCall {
	public static void main(String[] args) {
	
	ApplicationContext context = new GenericXmlApplicationContext("insert/bean.xml");
	LoggingWriteArticleService loggingWriteArticleService = (LoggingWriteArticleService) context.getBean("loggingWriteArticleServiceImplement");
	LoggingArticle loggingArticle = (LoggingArticle) context.getBean("loggingArticle");
	loggingWriteArticleService.write(loggingArticle);
	
	}
}
