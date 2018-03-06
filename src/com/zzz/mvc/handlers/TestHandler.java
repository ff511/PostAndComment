package com.zzz.mvc.handlers;

import com.zzz.mvc.Mappers.UserMapper;
import com.zzz.mvc.entities.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class TestHandler {

    private ApplicationContext applicationContext;


    @RequestMapping("/test")
    public String test(Map<String, Object> map) {
        applicationContext = new ClassPathXmlApplicationContext(
                "com/zzz/mvc/config/Spring/applicationContext.xml");
        UserMapper userMapper = applicationContext.getBean(UserMapper.class);
        User u = userMapper.selectOneUser("00010");
        map.put("user", u);
        return "success";
    }
}
