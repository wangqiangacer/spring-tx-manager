package cn.jacken.service.Impl;

import cn.jacken.mapper.UserMapper;
import cn.jacken.utils.HttpClientUtils;
import com.codingapi.tx.annotation.TxTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl {
    @Autowired
    private UserMapper userMapper;
    @TxTransaction(isStart = true)
    @Transactional
    public  void insert(String  name){
        userMapper.insert(name);
        HttpClientUtils.get("http://127.0.0.1:8082/insert?name="+name);
        int i=1/0;
    }
}
