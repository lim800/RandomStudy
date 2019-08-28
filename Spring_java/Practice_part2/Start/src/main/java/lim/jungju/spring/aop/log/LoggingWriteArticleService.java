package lim.jungju.spring.aop.log;

import org.springframework.stereotype.Service;

@Service
public interface LoggingWriteArticleService {
	void write(LoggingArticle loggingArticle);
}
