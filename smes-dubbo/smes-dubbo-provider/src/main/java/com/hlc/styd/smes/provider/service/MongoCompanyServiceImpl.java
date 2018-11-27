package com.hlc.styd.smes.provider.service;

import com.hlc.styd.smes.api.mongo.MongoCompanyDto;
import com.hlc.styd.smes.api.service.MongoCompanyService;
import com.hlc.styd.smes.provider.jpa.IMongoCompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Liang on 2018/11/23.
 */
@Service("mongoCompanyService")
public class MongoCompanyServiceImpl  implements MongoCompanyService {

    @Autowired
    private IMongoCompanyRepository mongoCompanyRepository;

    public void saveOrUpdate(MongoCompanyDto company) {
        mongoCompanyRepository.save(company);
    }

    public void delete(MongoCompanyDto company) {
        mongoCompanyRepository.delete(company);
    }

    public MongoCompanyDto findById(int id) {
        MongoCompanyDto companyDto = mongoCompanyRepository.findById(id);
        return companyDto;
    }

    public List<MongoCompanyDto> findAll() {
        return mongoCompanyRepository.findAll();
    }


}
