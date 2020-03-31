package cn.pigletter.dao;

import cn.pigletter.model.User;

public interface UserMapper {

    void insertNewUser(User user);
    User selectUserByName(String name);

}
