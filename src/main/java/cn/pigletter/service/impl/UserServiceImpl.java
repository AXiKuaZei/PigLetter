package cn.pigletter.service.impl;

import cn.pigletter.dao.UserMapper;
import cn.pigletter.model.User;
import cn.pigletter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User selectUserByName(String username) {
        return userMapper.selectUserByName(username);
    }

    @Override
    public void insertNewUser(User user) {
        userMapper.insertNewUser(user);
    }

    @Override
    public boolean containsUser(String username) {
        return selectUserByName(username)!=null;
    }
}
