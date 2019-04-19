package lz.springmvc.demo.contrller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequestMapping("/test")
@RestController
public class SimpleTestExceptionContrller {


    @GetMapping("/{divisor}")
    public String test(@PathVariable("divisor") int divisor, HttpServletRequest request, HttpServletResponse response) {
        String s = "error";
        int code = 200;
        try {
            s = 100 / divisor + "";
        } catch (Exception e) {
            code = 500;
            e.printStackTrace();
        } finally {
//            response.setStatus(code);
            return s;

        }
    }
}
