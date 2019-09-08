package cn.jacken.service.Impl;

import cn.jacken.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {
    @Autowired
    private UserMapper  userMapper;
    public  void insert(String  name){
        userMapper.insert(name);
    }
}
