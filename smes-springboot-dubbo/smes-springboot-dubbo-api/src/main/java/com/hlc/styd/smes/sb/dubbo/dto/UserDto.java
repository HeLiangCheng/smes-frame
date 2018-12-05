package com.hlc.styd.smes.sb.dubbo.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Liang on 2018/11/30.
 */
@Data
public class UserDto implements Serializable{

    private Integer id;
    private String name;
    private String username;
    private String gander;
    private Date birthday;

}
