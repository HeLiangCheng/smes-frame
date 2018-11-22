package com.hlc.styd.smes.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Liang on 2018/11/22.
 */
@Getter
@Setter
public class UserDto implements Serializable{
    private Integer id;
    private String name;
    private String username;
    private String password;
    private String gander;
    private Date birthday;
}
