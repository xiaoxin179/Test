package com.ruoyi.recruit.service;

import java.util.List;
import com.ruoyi.recruit.domain.RecruitCategory;


public interface IRecruitCategoryService
{
    /**
     * 查询岗位分类
     *
     * @param id 岗位分类ID
     * @return 岗位分类
     */
    public RecruitCategory selectRecruitCategoryById(Long id);

    /**
     * 查询岗位分类列表
     *
     * @param recruitCategory 岗位分类
     * @return 岗位分类集合
     */
    public List<RecruitCategory> selectRecruitCategoryList(RecruitCategory recruitCategory);

    /**
     * 新增岗位分类
     *
     * @param recruitCategory 岗位分类
     * @return 结果
     */
    public int insertRecruitCategory(RecruitCategory recruitCategory);

    /**
     * 修改岗位分类
     *
     * @param recruitCategory 岗位分类
     * @return 结果
     */
    public int updateRecruitCategory(RecruitCategory recruitCategory);

    /**
     * 批量删除岗位分类
     *
     * @param ids 需要删除的岗位分类ID
     * @return 结果
     */
    public int deleteRecruitCategoryByIds(Long[] ids);

    /**
     * 删除岗位分类信息
     *
     * @param id 岗位分类ID
     * @return 结果
     */
    public int deleteRecruitCategoryById(Long id);

    List<RecruitCategory> selectBigCategoryList(RecruitCategory recruitCategory);
}
