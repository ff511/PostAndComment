package com.zzz.mvc.Mappers;

import com.zzz.mvc.entities.User;

public interface UserMapper {
    void addOneUser(User user);
    User selectOneUser(String id);
}
