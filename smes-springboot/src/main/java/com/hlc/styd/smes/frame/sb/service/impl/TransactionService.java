package com.hlc.styd.smes.frame.sb.service.impl;

import com.hlc.styd.smes.frame.sb.dao.jdbc.IUserDao;
import com.hlc.styd.smes.frame.sb.entity.Db_User;
import com.hlc.styd.smes.frame.sb.multidatasource.repository.primary.CompanyPrimaryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.Date;

/**
 * Created by Liang on 2018/11/29.
 * springboot 事务处理的案例
 *
 */
@Service
public class TransactionService {

    @Autowired
    private IUserDao userDao;
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Transactional
    public void addUser() {
        try {
            Db_User user1 = new Db_User();
            user1.setName("事务1");
            user1.setUsername("事务1");
            user1.setGander("男");
            user1.setPassword("1234567");
            user1.setBirthday(new Date());
            userDao.save(user1);

            Db_User user2 = new Db_User();
            user2.setName("事务2");
            user2.setGander("男");
            user2.setPassword("1234562");
            user2.setBirthday(new Date());
            userDao.save(user2);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            //事务回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
    }

}
