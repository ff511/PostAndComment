package com.zzz.mvc.handlers;

import com.zzz.mvc.Mappers.AccountMapper;
import com.zzz.mvc.Mappers.FriendsMapper;
import com.zzz.mvc.entities.Account;
import com.zzz.mvc.entities.FellowRequestVo;
import com.zzz.mvc.entities.MasterAndFan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping(value = "/Friend")
public class FriendHandler {

    private ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
            "com/zzz/mvc/config/Spring/applicationContext.xml");

    private AccountMapper accountMapper = applicationContext.getBean(AccountMapper.class);
    private FriendsMapper friendsMapper = applicationContext.getBean(FriendsMapper.class);


    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public String deleteAfriend(MasterAndFan masterAndFan,
                                Map<String, Object> map) {


        Integer fan_id = masterAndFan.getFans_id();
        friendsMapper.deleteAMaster(masterAndFan);

        Account real = accountMapper.queryAccountInfoById(fan_id);
        List<Account> allFriends = friendsMapper.selectAllFriendsById(fan_id);
        map.put("name", real.getAccount_name());
        map.put("email", real.getAccount_email());
        map.put("id", real.getAccount_id());
        map.put("friends", allFriends);
        return "personalPage";
    }

    @RequestMapping(value = "/friendSeePage/{Account_id}", method = RequestMethod.GET)
    public String goFriendSeePage(@PathVariable Integer Account_id,
                                  Map<String, String> map) {
        accountMapper = applicationContext.getBean(AccountMapper.class);

        Account friend = accountMapper.queryAccountInfoById(Account_id);
        map.put("name", friend.getAccount_name());
        map.put("email", friend.getAccount_email());

        return "friendSee/FriendSeePage";
    }

    @RequestMapping(value = "/fellow", method = RequestMethod.POST)
    public String fellow(FellowRequestVo fellowRequestVo,
                         Map<String, Object> map) {

        fellowRequestVo.setIdFriends(UUID.randomUUID().toString());
        friendsMapper = applicationContext.getBean(FriendsMapper.class);
        System.out.println(fellowRequestVo);

        friendsMapper.fellowOneAccountByMasterId(fellowRequestVo);
        Integer id = fellowRequestVo.getFans_id();  //current_Account_id
        Account real = accountMapper.queryAccountInfoById(id);
        List<Account> allFriends = friendsMapper.selectAllFriendsById(id);

        map.put("name", real.getAccount_name());
        map.put("email", real.getAccount_email());
        map.put("id", real.getAccount_id());
        map.put("friends", allFriends);
        return "personalPage";
    }
}
