package com.hlc.styd.smes.frame.sb.multidatasource.repository.primary;

import com.hlc.styd.smes.frame.sb.multidatasource.domain.primary.CompanyPrimary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Created by Liang on 2018/11/28.
 */
public interface CompanyPrimaryRepository extends JpaRepository<CompanyPrimary,Integer> ,JpaSpecificationExecutor<CompanyPrimary> {

}
