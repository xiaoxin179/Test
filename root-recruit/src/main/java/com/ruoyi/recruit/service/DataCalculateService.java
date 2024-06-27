package com.ruoyi.recruit.service;

import com.ruoyi.recruit.domain.bo.CompanySumHC;

import java.util.List;

//数据分析实现类
public interface DataCalculateService {
    /*
    查询每家公司放出来的岗位排行
     */
    public List<CompanySumHC> getCompanySum();
    /*
    查询岗位最多的六个城市
     */
    List<CompanySumHC> getTop6();
}
