package com.hlc.styd.smes.sb.dubbo.provider.service;

import com.hlc.styd.smes.sb.dubbo.api.IUserService;
import com.hlc.styd.smes.sb.dubbo.dto.UserDto;
import com.hlc.styd.smes.sb.dubbo.provider.dao.UserDao;
import com.hlc.styd.smes.sb.dubbo.provider.domain.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Liang on 2018/12/5.
 */
@Service("userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<UserDto> findAll() {
        List<User> userList = userDao.findAll();
        ArrayList<UserDto> userDtos = new ArrayList<UserDto>();
        for (User item : userList) {
            UserDto dto = new UserDto();
            BeanUtils.copyProperties(item, dto);
            userDtos.add(dto);
        }
        return userDtos;
    }

}
