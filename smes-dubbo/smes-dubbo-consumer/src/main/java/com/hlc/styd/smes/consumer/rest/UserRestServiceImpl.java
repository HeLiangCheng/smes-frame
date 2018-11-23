package com.hlc.styd.smes.consumer.rest;

import org.springframework.stereotype.Service;
import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.hlc.styd.smes.api.dto.UserDto;
import com.hlc.styd.smes.api.rest.UserRestService;
import com.hlc.styd.smes.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by Liang on 2018/11/23.
 * 使用dubbo服务提供REST服务
 */

@Path("rest")
//@Consumes({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML, MediaType.APPLICATION_FORM_URLENCODED })
//@Produces({ ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8 })
@Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
@Produces({ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8})
@Service("userRestService")
public class UserRestServiceImpl implements UserRestService {

    @Autowired
    UserService userService;


    @Path("/user/{id}")
    @GET
    public UserDto getUserById(@PathParam("id") int id) {
        return userService.findById(id);
    }

    @Path("/user")
    @POST
    public void insertUser(@RequestBody UserDto user) {
        userService.saveorupdate(user);
    }

    @Path("/user/{id}")
    @DELETE
    public void deleteUser(@PathParam("id") int id) {
        userService.deleteUser(id);
    }

}
