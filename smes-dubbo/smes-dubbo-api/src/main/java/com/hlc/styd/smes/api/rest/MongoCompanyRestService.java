package com.hlc.styd.smes.api.rest;

import com.hlc.styd.smes.api.mongo.MongoCompanyDto;

import java.util.List;

/**
 * Created by Liang on 2018/11/26.
 */
public interface MongoCompanyRestService {

    List<MongoCompanyDto> getCompanyAll();

    MongoCompanyDto getCompanyById(int id);

    void insertCompany(MongoCompanyDto company);

    void deleteCompany(int id);

}
