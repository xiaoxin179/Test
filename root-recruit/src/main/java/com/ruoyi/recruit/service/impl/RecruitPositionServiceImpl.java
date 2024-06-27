package com.ruoyi.recruit.service.impl;

import java.util.List;

import com.ruoyi.recruit.mapper.RecruitCategoryMapper;
import com.ruoyi.recruit.mapper.RecruitCompanyInfoMapper;
import org.springframework.stereotype.Service;
import com.ruoyi.recruit.mapper.RecruitPositionMapper;
import com.ruoyi.recruit.domain.RecruitPosition;
import com.ruoyi.recruit.service.IRecruitPositionService;

import javax.annotation.Resource;

/**
 * 招聘岗位Service业务层处理
 *
 * @author ruoyi
 * @date 2021-03-25
 */
@Service
public class RecruitPositionServiceImpl implements IRecruitPositionService {
    @Resource
    private RecruitPositionMapper recruitPositionMapper;

    /**
     * 查询招聘岗位
     *
     * @param id 招聘岗位ID
     * @return 招聘岗位
     */
    @Override
    public RecruitPosition selectRecruitPositionById(Long id) {
        return recruitPositionMapper.selectRecruitPositionById(id);
    }

    /**
     * 查询招聘岗位列表
     *
     * @param recruitPosition 招聘岗位
     * @return 招聘岗位
     */
    @Override
    public List<RecruitPosition> selectRecruitPositionList(RecruitPosition recruitPosition) {
        return recruitPositionMapper.selectRecruitPositionList(recruitPosition);
    }

    /**
     * 新增招聘岗位
     *
     * @param recruitPosition 招聘岗位
     * @return 结果
     */
    @Override
    public int insertRecruitPosition(RecruitPosition recruitPosition) {
        return recruitPositionMapper.insertRecruitPosition(recruitPosition);
    }

    /**
     * 修改招聘岗位
     *
     * @param recruitPosition 招聘岗位
     * @return 结果
     */
    @Override
    public int updateRecruitPosition(RecruitPosition recruitPosition) {
        return recruitPositionMapper.updateRecruitPosition(recruitPosition);
    }

    /**
     * 批量删除招聘岗位
     *
     * @param ids 需要删除的招聘岗位ID
     * @return 结果
     */
    @Override
    public int deleteRecruitPositionByIds(Long[] ids) {
        return recruitPositionMapper.deleteRecruitPositionByIds(ids);
    }

    /**
     * 删除招聘岗位信息
     *
     * @param id 招聘岗位ID
     * @return 结果
     */
    @Override
    public int deleteRecruitPositionById(Long id) {
        return recruitPositionMapper.deleteRecruitPositionById(id);
    }
}
