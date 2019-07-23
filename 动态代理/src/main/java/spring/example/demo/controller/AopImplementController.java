package spring.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.example.demo.component.American;
import spring.example.demo.component.Chinese;
import spring.example.demo.component.Person;
import spring.example.demo.handler.CGLIBDynamicObject;
import spring.example.demo.handler.JDKDynamicObject;

/**
 * 〈测试〉
 *
 * @author LZ
 * @create 2019/7/20
 * @since 1.0.0
 */
@RestController
public class AopImplementController {
    private Logger logger = LoggerFactory.getLogger(AopImplementController.class);

    @Autowired
    private Person chinese;
    @Autowired
    private American american;

    @GetMapping("/jdk")
    public String jdk() {
        JDKDynamicObject dsc1 = new JDKDynamicObject();
        Person person1 = (Person) dsc1.bind(new Chinese());
        person1.say("中国人说汉语");
        logger.info("AopImplementController ==> talk method : JDKDynamicObject {}", person1.getClass());
        return "success";

    }

    @GetMapping("/cglb")
    public String cglb() {
        //自定义CGLIB动态代理
        CGLIBDynamicObject dsm = new CGLIBDynamicObject();
        American american1 = (American) dsm.bind(new American());
        american1.say("American say english");
        logger.info("AopImplementController ==> talk method : CGLIBDynamicObject {}", american1.getClass());
        return "success";

    }

    @ResponseBody
    @GetMapping("/aop")
    public String talk() {
        chinese.say("中国人说汉语");
        american.say("American say english");

        logger.info("AopImplementController ==> talk method : {}", chinese.getClass());
        logger.info("AopImplementController ==> talk method : {}", american.getClass());
        return "success";
    }

}
