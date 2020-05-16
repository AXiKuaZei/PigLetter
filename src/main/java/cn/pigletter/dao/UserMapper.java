package cn.pigletter.dao;

import cn.pigletter.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    void insertNewUser(User user);
    User selectUserByName(String name);

}
