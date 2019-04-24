package customerservice.service;

import bean.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value ="producer-service")
public interface RestService {


    @GetMapping("/find/{id}")
    User getUserById(@PathVariable("id") Integer id);



    @GetMapping("/findAll")
    List<User> getAllUser();
}
