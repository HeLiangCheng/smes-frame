package com.hlc.styd.smes.consumer.rest;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.hlc.styd.smes.api.mongo.MongoCompanyDto;
import com.hlc.styd.smes.api.rest.MongoCompanyRestService;
import com.hlc.styd.smes.api.service.MongoCompanyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by Liang on 2018/11/26.
 */
@Path("rest")
@Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
@Produces({ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8})
@Service("companyRestService")
public class CompanyRestServiceImpl implements MongoCompanyRestService {

    @Autowired
    private MongoCompanyService mongoCompanyService;
    private Logger log = LoggerFactory.getLogger(getClass());

    @Path("/company")
    @GET
    public List<MongoCompanyDto> getCompanyAll() {
        return mongoCompanyService.findAll();
    }

    @Path("/company/{id}")
    @GET
    public MongoCompanyDto getCompanyById(@PathParam("id") int id) {
        log.info("获取当前公司信息：" + id);
        return mongoCompanyService.findById(id);
    }

    @Path("/company")
    @POST
    public void insertCompany(@RequestBody  MongoCompanyDto company) {
        mongoCompanyService.saveOrUpdate(company);
    }

    @Path("/company/{id}")
    @DELETE
    public void deleteCompany(@PathParam("id") int id) {
        MongoCompanyDto companyDto = mongoCompanyService.findById(id);
        mongoCompanyService.delete(companyDto);
    }

}
