package com.hlc.styd.smes.frame.sb.service.impl;

import com.hlc.styd.smes.frame.sb.dao.jpa.JpaUserDao;
import com.hlc.styd.smes.frame.sb.entity.JPA_User;
import com.hlc.styd.smes.frame.sb.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import javax.persistence.criteria.Predicate;
import java.util.Date;
import java.util.List;
import java.util.function.*;

/**
 * Created by Liang on 2018/11/28.
 */
@Service("jpaUserService")
public class JpaUserServiceImpl implements IUserService<JPA_User> {

    @Autowired(required = false)
    private JpaUserDao userJapDao;

    @Override
    public void save(JPA_User user) {
        userJapDao.save(user);
    }

    @Override
    public void update(JPA_User user) {
        userJapDao.save(user);
    }

    @Override
    public void delete(JPA_User user) {
        userJapDao.delete(user);
    }

    @Override
    public int count(JPA_User user) {
        Specification<JPA_User> spec = new Specification<JPA_User>() {
            @Nullable
            @Override
            public Predicate toPredicate(Root<JPA_User> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                Path<String> name = root.get("name");
                Path<String> username = root.get("username");
                Path<String> gander = root.get("gander");
                Path<Date> birthday = root.get("birthday");
                Predicate para1 = criteriaBuilder.like(name, "%" + user.getName() + "%");
                Predicate para2 = criteriaBuilder.like(username, "%" + user.getUsername() + "%");
                Predicate para3 = criteriaBuilder.equal(gander, user.getGander());
                Predicate para4 = criteriaBuilder.equal(birthday, user.getBirthday());
                Predicate param = criteriaBuilder.and(para1, para2, para3, para4);
                return param;
            }
        };
        return (int) userJapDao.count(spec);
    }

    @Override
    public List<JPA_User> findAll() {
        return userJapDao.findAll();
    }

    @Override
    public JPA_User findById(Integer id) {
        return userJapDao.findById(id).get();
    }

    @Override
    public List<JPA_User> findByCriteria(JPA_User user) {
        Specification<JPA_User> spec = new Specification<JPA_User>() {
            @Nullable
            @Override
            public Predicate toPredicate(Root<JPA_User> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                Path<String> name = root.get("name");
                Path<String> username = root.get("username");
                Path<String> gander = root.get("gander");
                Path<Date> birthday = root.get("birthday");
                Predicate para1 = criteriaBuilder.like(name, "%" + user.getName() + "%");
                Predicate para2 = criteriaBuilder.like(username, "%" + user.getUsername() + "%");
                Predicate para3 = criteriaBuilder.equal(gander, user.getGander());
                Predicate para4 = criteriaBuilder.equal(birthday, user.getBirthday());
                Predicate param = criteriaBuilder.and(para1, para2, para3, para4);
                return param;
            }
        };
        List<JPA_User> userList = userJapDao.findAll(spec);
        return userList;
    }

    @Override
    public List<JPA_User> findByPage(int pageindex, int pagesize, JPA_User user) {
        Pageable pageable = new PageRequest(pageindex, pagesize);  //分页信息
        Specification<JPA_User> spec = new Specification<JPA_User>() {
            @Nullable
            @Override
            public Predicate toPredicate(Root<JPA_User> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                Path<String> name = root.get("name");
                Path<String> username = root.get("username");
                Path<String> gander = root.get("gander");
                Path<Date> birthday = root.get("birthday");
                Predicate para1 = criteriaBuilder.like(name, "%" + user.getName() + "%");
                Predicate para2 = criteriaBuilder.like(username, "%" + user.getUsername() + "%");
                Predicate para3 = criteriaBuilder.equal(gander, user.getGander());
                Predicate para4 = criteriaBuilder.equal(birthday, user.getBirthday());
                Predicate param = criteriaBuilder.and(para1, para2, para3, para4);
                return param;
            }
        };
        Page<JPA_User> pageuser = userJapDao.findAll(spec, pageable);
        return pageuser.getContent();
    }


}
