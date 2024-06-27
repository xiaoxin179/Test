package com.ruoyi.recruit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.recruit.mapper.RecruitCategoryMapper;
import com.ruoyi.recruit.domain.RecruitCategory;
import com.ruoyi.recruit.service.IRecruitCategoryService;

import javax.annotation.Resource;

/**
 * 岗位分类Service业务层处理
 *
 * @author ruoyi
 * @date 2021-03-25
 */
@Service
public class RecruitCategoryServiceImpl implements IRecruitCategoryService {
    @Resource
    private RecruitCategoryMapper recruitCategoryMapper;

    /**
     * 查询岗位分类
     *
     * @param id 岗位分类ID
     * @return 岗位分类
     */
    @Override
    public RecruitCategory selectRecruitCategoryById(Long id) {
        return recruitCategoryMapper.selectRecruitCategoryById(id);
    }

    /**
     * 查询岗位分类列表
     *
     * @param recruitCategory 岗位分类
     * @return 岗位分类
     */
    @Override
    public List<RecruitCategory> selectRecruitCategoryList(RecruitCategory recruitCategory) {
        return recruitCategoryMapper.selectRecruitCategoryList(recruitCategory);
    }

    /**
     * 新增岗位分类
     *
     * @param recruitCategory 岗位分类
     * @return 结果
     */
    @Override
    public int insertRecruitCategory(RecruitCategory recruitCategory) {
        return recruitCategoryMapper.insertRecruitCategory(recruitCategory);
    }

    /**
     * 修改岗位分类
     *
     * @param recruitCategory 岗位分类
     * @return 结果
     */
    @Override
    public int updateRecruitCategory(RecruitCategory recruitCategory) {
        return recruitCategoryMapper.updateRecruitCategory(recruitCategory);
    }

    /**
     * 批量删除岗位分类
     *
     * @param ids 需要删除的岗位分类ID
     * @return 结果
     */
    @Override
    public int deleteRecruitCategoryByIds(Long[] ids) {
        return recruitCategoryMapper.deleteRecruitCategoryByIds(ids);
    }

    /**
     * 删除岗位分类信息
     *
     * @param id 岗位分类ID
     * @return 结果
     */
    @Override
    public int deleteRecruitCategoryById(Long id) {
        return recruitCategoryMapper.deleteRecruitCategoryById(id);
    }

    @Override
    public List<RecruitCategory> selectBigCategoryList(RecruitCategory recruitCategory) {
        return recruitCategoryMapper.selectBigCategoryList(recruitCategory);
    }
}
