package com.ruoyi.recruit.mapper;

import java.util.List;
import com.ruoyi.recruit.domain.RecruitDelivery;

/**
 * 简历投递信息Mapper接口
 * 
 * @author ruoyi
 * @date 2021-04-03
 */
public interface RecruitDeliveryMapper 
{
    /**
     * 查询简历投递信息
     * 
     * @param id 简历投递信息ID
     * @return 简历投递信息
     */
    public RecruitDelivery selectRecruitDeliveryById(Long id);

    /**
     * 查询简历投递信息列表
     * 
     * @param recruitDelivery 简历投递信息
     * @return 简历投递信息集合
     */
    public List<RecruitDelivery> selectRecruitDeliveryList(RecruitDelivery recruitDelivery);

    /**
     * 新增简历投递信息
     * 
     * @param recruitDelivery 简历投递信息
     * @return 结果
     */
    public int insertRecruitDelivery(RecruitDelivery recruitDelivery);

    /**
     * 修改简历投递信息
     * 
     * @param recruitDelivery 简历投递信息
     * @return 结果
     */
    public int updateRecruitDelivery(RecruitDelivery recruitDelivery);

    /**
     * 删除简历投递信息
     * 
     * @param id 简历投递信息ID
     * @return 结果
     */
    public int deleteRecruitDeliveryById(Long id);

    /**
     * 批量删除简历投递信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteRecruitDeliveryByIds(Long[] ids);
}
