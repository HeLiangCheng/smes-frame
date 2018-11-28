package com.hlc.styd.smes.frame.sb.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Liang on 2018/11/27.
 */
@Data
@Entity
@Table(name = "user")
public class JPA_User {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String gander;

    @Column(nullable = false)
    private Date birthday;

}
