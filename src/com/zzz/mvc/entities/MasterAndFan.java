package com.zzz.mvc.entities;

public class MasterAndFan {
    private Integer Master_id;
    private Integer Fans_id;

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

    @Override
    public String toString() {
        return "MasterAndFan{" +
                "Master_id=" + Master_id +
                ", Fans_id=" + Fans_id +
                '}';
    }
}
