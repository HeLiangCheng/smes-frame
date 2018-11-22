package com.hlc.styd.smes.api.service;

import com.hlc.styd.smes.api.dto.UserDto;

import java.util.List;

/**
 * Created by Liang on 2018/11/21.
 */
public interface UserService {

    int saveorupdate(UserDto user);

    int deleteUser(int id);

    UserDto findById(int id);

    List<UserDto> findByUser(UserDto user);

    int count(UserDto user);
}
