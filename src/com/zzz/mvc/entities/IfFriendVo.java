package com.zzz.mvc.entities;

public class IfFriendVo {
    private String Account_email;

    private String Account_name;

    private Integer relation;

    public String getAccount_email() {
        return Account_email;
    }

    public void setAccount_email(String account_email) {
        Account_email = account_email;
    }

    public String getAccount_name() {
        return Account_name;
    }

    public void setAccount_name(String account_name) {
        Account_name = account_name;
    }

    public Integer getRelation() {
        return relation;
    }

    public void setRelation(Integer relation) {
        this.relation = relation;
    }

    @Override
    public String toString() {
        return "IfFriendVo{" +
                "Account_email='" + Account_email + '\'' +
                ", Account_name='" + Account_name + '\'' +
                ", relation=" + relation +
                '}';
    }
}
