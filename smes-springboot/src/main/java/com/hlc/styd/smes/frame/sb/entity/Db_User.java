package com.hlc.styd.smes.frame.sb.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Liang on 2018/11/27.
 */
@Data
public class Db_User implements Serializable {

    private Integer id;
    private String name;
    private String username;
    private String password;
    private String gander;
    private Date birthday;

}
