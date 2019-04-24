package lz.mapper;


import bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface UserMapper {
    public User getUserById(int id);
    public List<User> getAllUser();
}
