package lim.jungju.spring.aop.log;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;



@Service
@Aspect
public class LoggingAspect {
	private Log log = LogFactory.getLog(getClass());
	@Pointcut("execution(public*lim.jungju.spring.aop.log..*write(..))")
	public void loggingTarget() {
		
	}
	@Around("loggingTarget()")
	
	public void logging(ProceedingJoinPoint proceedingJoinPoint)throws Throwable{
		log.info("기록시작");
		proceedingJoinPoint.proceed();
		log.info("기록종료");
	}
	
	
	
}
