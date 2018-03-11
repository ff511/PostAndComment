package com.zzz.mvc.entities;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class Account {

    @NotEmpty
    @Email
    private String Account_id;// 用email, required

    @NotEmpty
    private String Account_name;// required

    @NotEmpty
    private String Account_password;//required

    private String Account_address;

    public String getAccount_id() {
        return Account_id;
    }

    public void setAccount_id(String account_id) {
        Account_id = account_id;
    }

    public String getAccount_name() {
        return Account_name;
    }

    public void setAccount_name(String account_name) {
        Account_name = account_name;
    }

    public String getAccount_password() {
        return Account_password;
    }

    public void setAccount_password(String account_password) {
        Account_password = account_password;
    }

    public String getAccount_address() {
        return Account_address;
    }

    public void setAccount_address(String account_address) {
        Account_address = account_address;
    }

    @Override
    public String toString() {
        return "Account{" +
                "Account_id='" + Account_id + '\'' +
                ", Account_name='" + Account_name + '\'' +
                ", Account_password='" + Account_password + '\'' +
                ", Account_address='" + Account_address + '\'' +
                '}';
    }
}
