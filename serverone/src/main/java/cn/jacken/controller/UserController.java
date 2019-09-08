package cn.jacken.controller;

import cn.jacken.service.Impl.UserServiceImpl;
import cn.jacken.utils.HttpClientUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping
@RestController

public class UserController {
    @Autowired
    private UserServiceImpl userService;
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @RequestMapping("server1")
    public  String getUser(){
        HttpClientUtils.get("http://127.0.0.1:8082/server2");
        logger.info("server1 get server2 result is  success");
        return "server1 执行完成！";
    }

    @RequestMapping("/insert")
    public  String insert(String name){
        userService.insert(name);
        HttpClientUtils.get("http://127.0.0.1:8082/server2");
        int i=1/0;
        return "SUCCESS";
    }
}
