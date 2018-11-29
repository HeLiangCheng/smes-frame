package com.hlc.styd.smes.frame.sb.redis;

import com.hlc.styd.smes.frame.sb.entity.Db_User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.net.UnknownHostException;

/**
 * Created by Liang on 2018/11/29.
 * 1. 引入redis相关的jar包，spring-boot-starter-data-redis
 * 2. 在配置文件中配置redis连接
 * 3. 配置redisconfig, 主要是初始化RedisTemplate
 * 4. 使用RedisTemplate操作reids数据库
 *
 */
@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<String, Db_User> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Db_User> template = new RedisTemplate<String, Db_User>();
        template.setConnectionFactory(redisConnectionFactory);
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new RedisObjectSerializer());
        return template;
    }

    @Bean
    @ConditionalOnMissingBean(StringRedisTemplate.class)
    public StringRedisTemplate stringRedisTemplate(
            RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
        StringRedisTemplate template = new StringRedisTemplate();
        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }
}
