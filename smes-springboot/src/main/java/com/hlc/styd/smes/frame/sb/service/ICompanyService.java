package com.hlc.styd.smes.frame.sb.service;

import com.hlc.styd.smes.frame.sb.multidatasource.dto.CompanyDto;

import java.util.List;

/**
 * Created by Liang on 2018/11/28.
 */
public interface ICompanyService {

    void save(CompanyDto company);

    void update(CompanyDto company);

    void delete(CompanyDto company);

    List<CompanyDto> findAll();

}
