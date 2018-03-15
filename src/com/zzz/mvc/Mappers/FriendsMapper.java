package com.zzz.mvc.Mappers;

import com.zzz.mvc.entities.Account;
import com.zzz.mvc.entities.FellowRequestVo;
import com.zzz.mvc.entities.MasterAndFan;

import java.util.List;

public interface FriendsMapper {

    List<Account> selectAllFriendsById(Integer Fans_id);
    void deleteAMaster(MasterAndFan masterAndFan);
    List<Integer> selectAllFriendsIds(Integer Fans_id);
    void fellowOneAccountByMasterId(FellowRequestVo fellowRequest);
}
