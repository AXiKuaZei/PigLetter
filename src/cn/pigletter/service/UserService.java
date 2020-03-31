package cn.pigletter.service;

import cn.pigletter.model.User;

public interface UserService {

    User selectUserByName(String username);

    void insertNewUser(User user);

    boolean containsUser(String username);
}
