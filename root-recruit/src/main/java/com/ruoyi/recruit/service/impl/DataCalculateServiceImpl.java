package com.ruoyi.recruit.service.impl;

import com.ruoyi.recruit.domain.bo.CompanySumHC;
import com.ruoyi.recruit.mapper.CompanySumHCMapper;
import com.ruoyi.recruit.mapper.RecruitCategoryMapper;
import com.ruoyi.recruit.service.DataCalculateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author:XIAOXIN
 * @date:2024/06/21
 **/
@Service
public class DataCalculateServiceImpl implements DataCalculateService {
    @Resource
    private CompanySumHCMapper companySumHCManager;
    @Resource
    private RecruitCategoryMapper recruitCategoryMapper;
    @Override
    public List<CompanySumHC> getCompanySum() {
        return recruitCategoryMapper.getCompanySum();
    }

    @Override
    public List<CompanySumHC> getTop6() {
        return recruitCategoryMapper.getTop6();
    }
}
