package com.zzz.mvc.handlers;

import com.zzz.mvc.Mappers.AccountMapper;
import com.zzz.mvc.entities.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
@RequestMapping(value = "/Account")
public class AccountHandler {

    private ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
            "com/zzz/mvc/config/Spring/spring-mybatis-dao.xml");

    @Autowired
    private AccountMapper accountMapper;

    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public String register(Account account) {
        accountMapper = applicationContext.getBean(AccountMapper.class);
        accountMapper.addOneAccount(account);
        return "signInPage";
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.GET)
    public String goForRegister(Map<String, Object> map) {
        System.out.println("go fot register");
        map.put("newAccount", new Account());
        return "signUpPage";
    }

    @RequestMapping("/signIn")
    public String signIn() {
        return "signInPage";
    }
}
