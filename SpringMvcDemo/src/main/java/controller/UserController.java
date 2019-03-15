package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author MND
 * @date 2019/3/15
 * @describe
 */
@Controller
public class UserController {

    @RequestMapping("/login")
    public  String toLogin(){

        return "login";
    }


    @RequestMapping("/")
    public  String Login(){

        return "login";
    }
}
