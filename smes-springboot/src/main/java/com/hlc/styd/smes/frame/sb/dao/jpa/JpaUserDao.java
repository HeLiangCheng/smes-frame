package com.hlc.styd.smes.frame.sb.dao.jpa;

import com.hlc.styd.smes.frame.sb.entity.JPA_User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Created by Liang on 2018/11/27.
 * JpaRepository : spring-jpa提供的默认实现
 * JpaSpecificationExecutor : 对spring-jpa提供的增强查询
 */
@Repository
public interface JpaUserDao extends JpaRepository<JPA_User,Integer>,JpaSpecificationExecutor<JPA_User> {


}
