package spring.example.demo.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 〈Spring AOP之JDK动态代理实现〉
 *
 * @author LZ
 * @create 2019/7/20
 * @since 1.0.0
 */
public class JDKDynamicObject implements InvocationHandler {
    private Logger logger = LoggerFactory.getLogger(JDKDynamicObject.class);

    private Object target;

    public JDKDynamicObject() {
    }

    /**
     * @Description: 绑定对象，并生成代理对象
     * @Title: bind
     * @author OnlyMate
     * @Date 2018年9月11日 下午4:48:31
     * @param target
     * @return
     */
    public Object bind(Object target) {
        this.target = target;
        // 取得代理对象
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        logger.info("JDKDynamicObject ==> invoke method : {}，{}，{}", proxy.getClass(), method.getName(), args.toString());
        method.invoke(target, args);
        return null;
    }
}
