package lz.controller;

import bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lz.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/find/{id}")
    public User findUserById(@PathVariable("id") Integer id) {
        return userService.getUserById(id);
    }
    @GetMapping("/findAll")
    public List<User> findUserById(){
        return userService.getAllUser();
    }
}
