package com.zzz.mvc.entities;

public class FriendSearchVo {
    private String Search_pattern;
    private Integer Fans_id;

    public String getSearch_pattern() {
        return Search_pattern;
    }

    public void setSearch_pattern(String search_pattern) {
        Search_pattern = search_pattern;
    }

    public Integer getFans_id() {
        return Fans_id;
    }

    public void setFans_id(Integer fans_id) {
        Fans_id = fans_id;
    }

    @Override
    public String toString() {
        return "FriendSearchVo{" +
                "Search_pattern='" + Search_pattern + '\'' +
                ", Fans_id=" + Fans_id +
                '}';
    }
}
