package com.zzz.mvc.handlers;

import com.zzz.mvc.Mappers.AccountMapper;
import com.zzz.mvc.entities.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
@RequestMapping("/Account")
public class AccountHandler {
    private ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
            "com/zzz/mvc/config/Spring/applicationContext.xml");

    private AccountMapper accountMapper = applicationContext.getBean(AccountMapper.class);

    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public String register(Account account){
        accountMapper.addOneAccount(account);
        return "redirect:/Account/zzz";
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.GET)
    public String goForSignUp(Map<String, Object> map){
        map.put("Account", new Account());
        return "signUpPage";
    }



    @RequestMapping("zzz")
    public String start(){
        return "signInPage";
    }
}
