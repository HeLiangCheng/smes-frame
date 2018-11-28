package com.hlc.styd.smes.frame.sb.service.impl;

import com.hlc.styd.smes.frame.sb.multidatasource.domain.primary.CompanyPrimary;
import com.hlc.styd.smes.frame.sb.multidatasource.domain.secondary.CompanySecondary;
import com.hlc.styd.smes.frame.sb.multidatasource.dto.CompanyDto;
import com.hlc.styd.smes.frame.sb.multidatasource.repository.primary.CompanyPrimaryRepository;
import com.hlc.styd.smes.frame.sb.multidatasource.repository.secondary.CompanySecondaryRepository;
import com.hlc.styd.smes.frame.sb.service.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Liang on 2018/11/28.
 */
@Service
public class CompanyServiceImpl implements ICompanyService {

    @Autowired
    private CompanyPrimaryRepository companyPrimaryRepository;
    @Autowired
    private CompanySecondaryRepository companySecondaryRepository;

    @Override
    public void save(CompanyDto company) {
        CompanyPrimary companypri = new CompanyPrimary();
        companypri.setName(company.getName());
        companypri.setTelphone(company.getTelphone());
        companypri.setAddress(company.getAddress());
        companyPrimaryRepository.save(companypri);
    }

    @Override
    public void update(CompanyDto company) {
        CompanyPrimary companypri = new CompanyPrimary();
        companypri.setId(company.getId());
        companypri.setName(company.getName());
        companypri.setTelphone(company.getTelphone());
        companypri.setAddress(company.getAddress());
        companyPrimaryRepository.save(companypri);
    }

    @Override
    public void delete(CompanyDto company) {
        CompanyPrimary companypri = new CompanyPrimary();
        companypri.setId(company.getId());
        companypri.setName(company.getName());
        companypri.setTelphone(company.getTelphone());
        companypri.setAddress(company.getAddress());
        companyPrimaryRepository.delete(companypri);
    }

    @Override
    public List<CompanyDto> findAll() {
        List<CompanySecondary> companySecondlist = companySecondaryRepository.findAll();
        List<CompanyDto> companyDtoList = new ArrayList<>();
        companySecondlist.forEach(t -> {
            CompanyDto item = new CompanyDto();
            item.setId(t.getId());
            item.setName(t.getName());
            item.setAddress(t.getAddress());
            item.setTelphone(t.getTelphone());
            companyDtoList.add(item);
        });
        return companyDtoList;
    }

}
