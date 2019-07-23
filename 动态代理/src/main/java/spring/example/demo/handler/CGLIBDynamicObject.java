package spring.example.demo.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.InvocationHandler;

import java.lang.reflect.Method;

/**
 * 〈Spring AOP之CGLIB动态代理实现〉
 *
 * @author LZ
 * @create 2019/7/20
 * @since 1.0.0
 */
public class CGLIBDynamicObject implements InvocationHandler {
    private Logger logger = LoggerFactory.getLogger(CGLIBDynamicObject.class);

    private Object target;

    public CGLIBDynamicObject() {
    }

    /**
     * @param target
     * @return
     * @Description: 绑定对象，并生成代理对象
     * @Title: bind
     * @author OnlyMate
     * @Date 2018年9月11日 下午4:48:31
     */
    public Object bind(Object target) {
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        // 回调方法
        enhancer.setCallback(this);
        // 创建代理对象
        return enhancer.create();
    }


    @Override
    public Object invoke(Object arg0, Method arg1, Object[] arg2) throws Throwable {
        logger.info("CGLIBDynamicObject ==> invoke method : {}，{}，{}", arg0.getClass(), arg1.getName(),
                arg2.toString());
        arg1.invoke(target, arg2);
        return null;
    }
}
