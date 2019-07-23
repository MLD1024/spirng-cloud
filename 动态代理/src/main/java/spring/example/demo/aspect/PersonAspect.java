package spring.example.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 〈中国人〉
 *
 * @author LZ
 * @create 2019/7/20
 * @since 1.0.0
 */
@Aspect
@Component
public class PersonAspect {
    private Logger logger = LoggerFactory.getLogger(PersonAspect.class);

    @Pointcut("@annotation(spring.example.demo.aspect.PersonAnnotation)")
    public void pointCut() {

    }

    @Before("pointCut()")
    public void before(JoinPoint joinPoint) throws Throwable {
        logger.info("PersonAspect ==> before method : {}", joinPoint.getClass());

    }

    @After("pointCut()")
    public void after(JoinPoint joinPoint) {
        logger.info("PersonAspect ==> after method : {}", joinPoint.getClass());
    }
}
