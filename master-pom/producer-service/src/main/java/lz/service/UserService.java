package lz.service;

import bean.User;

import java.util.List;


public interface UserService {
    public User getUserById(int id);
    public List<User> getAllUser();
}
