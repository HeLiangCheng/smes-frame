package com.hlc.styd.smes.provider.service;

import com.hlc.styd.smes.api.dto.UserDto;
import com.hlc.styd.smes.api.service.UserService;
import com.hlc.styd.smes.provider.dao.IUserDao;
import com.hlc.styd.smes.provider.entiy.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Liang on 2018/11/21.
 * 以dubbo服务的方式暴露服务
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private IUserDao userDao;

    public int saveorupdate(UserDto user) {
        User dbuser = new User();
        BeanUtils.copyProperties(user,dbuser);
        int result = -1;
        if (user.getId() == null) {
            result = userDao.save(dbuser);
        } else {
            result = userDao.update(dbuser);
        }
        return result;
    }

    public int deleteUser(int id) {
        return userDao.delete(id);
    }

    public UserDto findById(int id) {
        User dbuser = userDao.selectByKey(id);
        UserDto dto = new UserDto();
        BeanUtils.copyProperties(dbuser, dto);
        return dto;
    }

    public List<UserDto> findByUser(UserDto user) {
        //查询参数
        User dbuser = new User();
        BeanUtils.copyProperties(user, dbuser);
        //结果处理
        List<UserDto> dtolist = new ArrayList<UserDto>();
        List<User> dblist = userDao.selectList(dbuser);
        for (User item : dblist) {
            UserDto dtoitem = new UserDto();
            BeanUtils.copyProperties(item, dtoitem);
            dtolist.add(dtoitem);
        }
        return dtolist;
    }

    public int count(UserDto user) {
        //查询参数
        User dbuser = new User();
        BeanUtils.copyProperties(user, dbuser);
        return userDao.count(dbuser);
    }

}
