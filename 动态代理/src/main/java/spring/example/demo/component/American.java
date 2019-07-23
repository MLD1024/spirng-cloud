package spring.example.demo.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import spring.example.demo.aspect.PersonAnnotation;

/**
 * 〈美国人〉
 *
 * @author LZ
 * @create 2019/7/20
 * @since 1.0.0
 */
@Component
public class American {
    private Logger logger = LoggerFactory.getLogger(American.class);

    public American() {
        super();
        logger.info("American ==> American method : 正在生成一个American实例");
    }

    @PersonAnnotation(name = "American")//该注解是用来定义切点
    public String say(String name) {
        logger.info("American ==> say method : say {}", name);
        return name + " hello, CGLIB implement AOP";
    }

    public void eat(String food) {
        logger.info("American ==> eat method : eat {}", food);
    }

}