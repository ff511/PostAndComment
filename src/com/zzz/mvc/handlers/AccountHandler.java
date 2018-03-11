package com.zzz.mvc.handlers;

import com.zzz.mvc.Mappers.AccountMapper;
import com.zzz.mvc.entities.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Map;

@Controller
@RequestMapping("/Account")
public class AccountHandler {
    private ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
            "com/zzz/mvc/config/Spring/applicationContext.xml");

    private AccountMapper accountMapper = applicationContext.getBean(AccountMapper.class);

    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public String register(@Valid Account account, BindingResult bindingResult,
                           Map<String, Object> map) {
        if (bindingResult.getErrorCount() > 0) {

            for (FieldError error : bindingResult.getFieldErrors()) {
                System.out.println(error.getDefaultMessage());
            }
            map.put("newAccount", new Account());
            return "signUpPage";
        }

        accountMapper.addOneAccount(account);
        return "redirect:/Account/zzz";
    }


    @RequestMapping(value = "/signUp", method = RequestMethod.GET)
    public String goForSignUp(Map<String, Object> map) {
        map.put("newAccount", new Account());
        return "signUpPage";
    }

    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
    public String signIn(Account account,
                         Map<String, Object> map) {
        String account_id = account.getAccount_id();
        try {
            Account real = accountMapper.queryAccountInfoById(account_id);
            if (real.getAccount_password().equals(account.getAccount_password())) {
                map.put("name", real.getAccount_name());
                map.put("email", real.getAccount_id());
                return "personalPage";
            } else {
                return "redirect:/Account/zzz";
            }
        } catch (NullPointerException npe) {
            return "redirect:/Account/zzz";
        }
    }

    @RequestMapping("zzz")
    public String start(Map<String, Object> map) {
        map.put("Account", new Account());
        return "signInPage";
    }
}
