package com.hlc.styd.smes.sb.dubbo.api;

import com.hlc.styd.smes.sb.dubbo.dto.UserDto;

import java.util.List;

/**
 * Created by Liang on 2018/11/30.
 */
public interface IUserService {

    List<UserDto> findAll();

}
