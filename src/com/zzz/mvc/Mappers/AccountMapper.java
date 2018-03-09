package com.zzz.mvc.Mappers;

import com.zzz.mvc.entities.Account;
import com.zzz.mvc.exceptions.CanNotAddAccountException;
import com.zzz.mvc.exceptions.CanNotDeleteAccountException;
import com.zzz.mvc.exceptions.CanNotEditAccountException;
import com.zzz.mvc.exceptions.CanNotQueryAccountException;

public interface AccountMapper {
    void addOneAccount(Account newAccount) throws CanNotAddAccountException;

    void deleteOneAccountById(String Account_id) throws CanNotDeleteAccountException;

    void editAccountInfo(Account newUser) throws CanNotEditAccountException;

    Account queryAccountInfoById(String Account_id) throws CanNotQueryAccountException;

    Account queryAccountInfoByIdAndPassword(String Account_id, String Account_password) throws CanNotQueryAccountException;
}
