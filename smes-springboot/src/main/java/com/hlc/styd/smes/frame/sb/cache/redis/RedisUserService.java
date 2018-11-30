package com.hlc.styd.smes.frame.sb.cache.redis;

import com.hlc.styd.smes.frame.sb.dao.mybatis.UserMapper;
import com.hlc.styd.smes.frame.sb.entity.Db_User;
import com.hlc.styd.smes.frame.sb.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
  Redis缓存配置
  1.导入缓存配置相关jar包
  2.在需要缓存的类上添加注解标记
        @CacheConfig主要用于配置该类中会用到的一些缓存配置，我们查询的数据会存到cacheNames="ehusercahe"这个缓存对象中
  3.在缓存方法中添加
       配置函数的返回值加入到缓存中，查询的时候先从缓存中获取，如果不存在再去数据库中查询。
        @Cacheable：     标记在类或者方法上，标记在方法是表示该方法支持缓存，标记在类上表示该类的所有方法支持缓存。对于支持缓存的方法，Spring会在其被调用后将其返回值缓存起来，以保证下次利用同样的参数来执行该方法时可以直接从缓存中获取结果，而不需要再次执行该方法。通常用户查询方法
        @CachePut：     该注解标注的方法在执行前不会去检查缓存中是否存在之前执行过的结果，而是每次都会执行该方法，并将执行结果以键值对的形式存入指定的缓存中它每次都会调用函数，所以主要用于数据库新增和修改上。
        @CacheEvict：   该注解标注在需要清除缓存元素的方法或类上的。当标记在一个类上时表示其中所有的方法的执行都会触发缓存的清除操作，所以通常用在删除方法上，用来从缓存中移除相应数据。

  4.在spring boot中通过@EnableCaching注解自动化配置合适的缓存管理器。
        reids
        spring.chache.type强制指定缓存管理器。

 常见错误：
        CacheExpressionRootObject: 不能写成@Cacheable(key="findAll") 而应该写成@Cacheable(key="'findAll'")

 */
@CacheConfig(cacheNames="redisusercahe")
@Service("redisuserService")
public class RedisUserService implements IUserService<Db_User> {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CacheManager cacheManager;

    @CachePut(cacheNames = "redisusercahe",key = "#p0.id")
    @Override
    public void save(Db_User user) {
        userMapper.insert(user);
    }


    @CachePut(cacheNames = "redisusercahe",key = "#p0.id")
    @Override
    public void update(Db_User user) {
        userMapper.update(user);
    }


    @CacheEvict(cacheNames = "redisusercahe")
    @Override
    public void delete(Db_User user) {
        userMapper.deleteByKey(user.getId());
    }

    @Cacheable(key="'count'")
    @Override
    public int count(Db_User user) {
        return userMapper.count(user);
    }

    @Cacheable(key="'findAll'")
    @Override
    public List<Db_User> findAll() {
        return userMapper.selectAll();
    }

    @Cacheable(key="'findById'")
    @Override
    public Db_User findById(Integer id) {
        return userMapper.selectByKey(id);
    }

    @Cacheable(key="'findByCriteria'")
    @Override
    public List<Db_User> findByCriteria(Db_User user) {
        return null;
    }

    @Cacheable(key="'findByPage'")
    @Override
    public List<Db_User> findByPage(int pageindex, int pagesize, Db_User user) {
        HashMap<String, Object> param = new HashMap<String, Object>();
        param.put("pageindex", pageindex);
        param.put("pagesize", pagesize);
        return userMapper.selectByPage(param);
    }


}
