package com.ruoyi.recruit.mapper;

import java.util.List;
import com.ruoyi.recruit.domain.RecruitPosition;

/**
 * 招聘岗位Mapper接口
 * 
 * @author ruoyi
 * @date 2021-03-25
 */
public interface RecruitPositionMapper 
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
     * 删除招聘岗位
     * 
     * @param id 招聘岗位ID
     * @return 结果
     */
    public int deleteRecruitPositionById(Long id);

    /**
     * 批量删除招聘岗位
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteRecruitPositionByIds(Long[] ids);
}
