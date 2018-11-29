package com.hlc.styd.smes.frame.sb.redis;

import com.hlc.styd.smes.frame.sb.entity.Db_User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by Liang on 2018/11/29.
 */
@Service
public class RedisUserService {

    @Autowired
    private RedisTemplate<String, Db_User> redisTemplate;

    public void save(Db_User user) {
        redisTemplate.opsForValue().set("redis_db_user", user);
    }

    public Db_User get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

}
