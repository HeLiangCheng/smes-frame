package com.hlc.styd.smes.frame.sb.multidatasource.domain.primary;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by Liang on 2018/11/28.
 * 第一数据源实体类
 */
@Data
@Entity
@Table(name ="company" )
public class CompanyPrimary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "address",nullable = false)
    private String address;

    @Column(name = "telphone",nullable = false)
    private String telphone;

}
