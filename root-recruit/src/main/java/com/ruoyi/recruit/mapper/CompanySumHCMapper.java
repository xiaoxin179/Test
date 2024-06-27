package com.ruoyi.recruit.mapper;

import com.ruoyi.recruit.domain.bo.CompanySumHC;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author:XIAOXIN
 * @date:2024/06/21
 **/
@Repository
public interface CompanySumHCMapper {

    public List<CompanySumHC> getCompanySum();
}
