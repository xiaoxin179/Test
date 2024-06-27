package com.ruoyi.recruit.service;

import java.util.List;
import com.ruoyi.recruit.domain.RecruitPosition;

/**
 * 招聘岗位Service接口
 * 
 * @author ruoyi
 * @date 2021-03-25
 */
public interface IRecruitPositionService 
{
    /**
     * 查询招聘岗位
     * 
     * @param id 招聘岗位ID
     * @return 招聘岗位
     */
    public RecruitPosition selectRecruitPositionById(Long id);

    /**
     * 查询招聘岗位列表
     * 
     * @param recruitPosition 招聘岗位
     * @return 招聘岗位集合
     */
    public List<RecruitPosition> selectRecruitPositionList(RecruitPosition recruitPosition);

    /**
     * 新增招聘岗位
     * 
     * @param recruitPosition 招聘岗位
     * @return 结果
     */
    public int insertRecruitPosition(RecruitPosition recruitPosition);

    /**
     * 修改招聘岗位
     * 
     * @param recruitPosition 招聘岗位
     * @return 结果
     */
    public int updateRecruitPosition(RecruitPosition recruitPosition);

    /**
     * 批量删除招聘岗位
     * 
     * @param ids 需要删除的招聘岗位ID
     * @return 结果
     */
    public int deleteRecruitPositionByIds(Long[] ids);

    /**
     * 删除招聘岗位信息
     * 
     * @param id 招聘岗位ID
     * @return 结果
     */
    public int deleteRecruitPositionById(Long id);
}
