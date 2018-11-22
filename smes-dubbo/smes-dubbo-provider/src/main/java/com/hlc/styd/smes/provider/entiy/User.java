package com.hlc.styd.smes.provider.entiy;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Liang on 2018/11/21.
 */
@Getter
@Setter
public class User implements Serializable {

    private Integer id;
    private String name;
    private String username;
    private String password;
    private String gander;
    private Date birthday;

}
