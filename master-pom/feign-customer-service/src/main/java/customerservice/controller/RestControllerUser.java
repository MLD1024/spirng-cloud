package customerservice.controller;

import bean.User;
import customerservice.service.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RequestMapping("/rest/user")
@RestController
public class RestControllerUser {

    @Autowired
    private RestService restService;

    @GetMapping("/find/{id}")
    public User restfindUserById(@PathVariable("id") Integer id) {
        return restService.getUserById(id);
    }
    @GetMapping("/findAll")
    public List<User> restfindUserAll(){
        return restService.getAllUser();
    }
}