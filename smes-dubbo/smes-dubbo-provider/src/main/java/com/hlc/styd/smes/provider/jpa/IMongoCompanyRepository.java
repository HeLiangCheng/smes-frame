package com.hlc.styd.smes.provider.jpa;

import com.hlc.styd.smes.api.mongo.MongoCompanyDto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Liang on 2018/11/26.
 */
@Repository
public interface IMongoCompanyRepository extends MongoRepository<MongoCompanyDto,Integer> {

    MongoCompanyDto findById(int id);

}
