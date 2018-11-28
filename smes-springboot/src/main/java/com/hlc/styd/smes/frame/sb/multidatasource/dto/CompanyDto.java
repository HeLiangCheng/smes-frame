package com.hlc.styd.smes.frame.sb.multidatasource.dto;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by Liang on 2018/11/28.
 * 第一数据源实体类
 */
@Data
public class CompanyDto {

    private int id;

    private String name;

    private String address;

    private String telphone;

}
