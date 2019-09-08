package cn.jacken.controller;

import cn.jacken.service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping
@RestController
public class UserController {
    @Autowired
    private UserServiceImpl userService;
    @RequestMapping("server2")
    public  String getUser(){
        return "*********Server2  Starting ***********";
    }
    @RequestMapping("/insert")
    public  String insert(String name){
        userService.insert(name);
        return "SUCCESS";
    }
}
