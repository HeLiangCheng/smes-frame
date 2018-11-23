package com.hlc.styd.smes.api.rest;

import com.hlc.styd.smes.api.dto.UserDto;

/**
 * Created by Liang on 2018/11/23.
 */
public interface UserRestService {

    UserDto getUserById(int id);

    void insertUser(UserDto user);

    void deleteUser(int id);
}
