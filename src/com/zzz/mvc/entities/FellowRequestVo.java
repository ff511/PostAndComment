package com.zzz.mvc.entities;

public class FellowRequestVo {

    private Integer Master_id;
    private Integer Fans_id;
    private String idFriends;

    public Integer getMaster_id() {
        return Master_id;
    }

    public void setMaster_id(Integer master_id) {
        Master_id = master_id;
    }

    public Integer getFans_id() {
        return Fans_id;
    }

    public void setFans_id(Integer fans_id) {
        Fans_id = fans_id;
    }

    public String getIdFriends() {
        return idFriends;
    }

    public void setIdFriends(String idFriends) {
        this.idFriends = idFriends;
    }

    @Override
    public String toString() {
        return "FellowRequestVo{" +
                "Master_id=" + Master_id +
                ", Fans_id=" + Fans_id +
                ", idFriends='" + idFriends + '\'' +
                '}';
    }
}
