package com.hlc.styd.smes.frame.sb.mongodb;

import com.hlc.styd.smes.frame.sb.entity.Db_User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Liang on 2018/11/29.
 */
@Repository
public interface UserMongoRepository extends MongoRepository<Db_User, Integer> {

}
