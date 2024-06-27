package com.ruoyi.recruit.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.recruit.mapper.RecruitDeliveryMapper;
import com.ruoyi.recruit.domain.RecruitDelivery;
import com.ruoyi.recruit.service.IRecruitDeliveryService;

/**
 * 简历投递信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-04-03
 */
@Service
public class RecruitDeliveryServiceImpl implements IRecruitDeliveryService 
{
    @Autowired
    private RecruitDeliveryMapper recruitDeliveryMapper;

    /**
     * 查询简历投递信息
     * 
     * @param id 简历投递信息ID
     * @return 简历投递信息
     */
    @Override
    public RecruitDelivery selectRecruitDeliveryById(Long id)
    {
        return recruitDeliveryMapper.selectRecruitDeliveryById(id);
    }

    /**
     * 查询简历投递信息列表
     * 
     * @param recruitDelivery 简历投递信息
     * @return 简历投递信息
     */
    @Override
    public List<RecruitDelivery> selectRecruitDeliveryList(RecruitDelivery recruitDelivery)
    {
        return recruitDeliveryMapper.selectRecruitDeliveryList(recruitDelivery);
    }

    /**
     * 新增简历投递信息
     * 
     * @param recruitDelivery 简历投递信息
     * @return 结果
     */
    @Override
    public int insertRecruitDelivery(RecruitDelivery recruitDelivery)
    {
        return recruitDeliveryMapper.insertRecruitDelivery(recruitDelivery);
    }

    /**
     * 修改简历投递信息
     * 
     * @param recruitDelivery 简历投递信息
     * @return 结果
     */
    @Override
    public int updateRecruitDelivery(RecruitDelivery recruitDelivery)
    {
        return recruitDeliveryMapper.updateRecruitDelivery(recruitDelivery);
    }

    /**
     * 批量删除简历投递信息
     * 
     * @param ids 需要删除的简历投递信息ID
     * @return 结果
     */
    @Override
    public int deleteRecruitDeliveryByIds(Long[] ids)
    {
        return recruitDeliveryMapper.deleteRecruitDeliveryByIds(ids);
    }

    /**
     * 删除简历投递信息信息
     * 
     * @param id 简历投递信息ID
     * @return 结果
     */
    @Override
    public int deleteRecruitDeliveryById(Long id)
    {
        return recruitDeliveryMapper.deleteRecruitDeliveryById(id);
    }
}
