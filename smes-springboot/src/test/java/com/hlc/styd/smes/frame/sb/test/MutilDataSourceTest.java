package com.hlc.styd.smes.frame.sb.test;

import com.hlc.styd.smes.frame.sb.multidatasource.dto.CompanyDto;
import com.hlc.styd.smes.frame.sb.service.ICompanyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by Liang on 2018/11/28.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MutilDataSourceTest {

    @Autowired
    private ICompanyService companyService;

    @Test
    public void test1() {
        CompanyDto dto = new CompanyDto();
        dto.setName("测试主数据源");
        dto.setAddress("四川成都");
        dto.setTelphone("16519834343");
        companyService.save(dto);
    }


    @Test
    public void test2() {
        List<CompanyDto> companyDtos = companyService.findAll();
        companyDtos.forEach(t->{
            System.out.println(t.toString());
        });
    }

}
