package lim.jungju.spring.aop.log;

import org.springframework.stereotype.Service;

@Service
public class LoggingWriteArticleServiceImplement implements LoggingWriteArticleService {

	@Override
	public void write(LoggingArticle loggingArticle) {
		System.out.println("write메서드 실행");
	}

}
