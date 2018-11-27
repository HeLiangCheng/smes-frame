package com.hlc.styd.smes.api.service;

import com.hlc.styd.smes.api.mongo.MongoCompanyDto;

import java.util.List;

/**
 * Created by Liang on 2018/11/26.
 */
public interface MongoCompanyService {

    void saveOrUpdate(MongoCompanyDto company);

    void delete(MongoCompanyDto company);

    MongoCompanyDto findById(int id);

    List<MongoCompanyDto> findAll();

}
