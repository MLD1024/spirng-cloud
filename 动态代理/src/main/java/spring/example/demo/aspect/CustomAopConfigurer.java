package spring.example.demo.aspect;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 〈自动扫描使用了aspectj注解的类〉
 *
 * @author LZ
 * @create 2019/7/20
 * @since 1.0.0
 */
@Configuration
@ComponentScan("spring.example")
@EnableAspectJAutoProxy//开启AspectJ注解
public class CustomAopConfigurer {
}
