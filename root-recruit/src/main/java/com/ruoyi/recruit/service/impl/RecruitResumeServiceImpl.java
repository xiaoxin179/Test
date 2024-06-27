package com.ruoyi.recruit.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.recruit.mapper.RecruitResumeMapper;
import com.ruoyi.recruit.domain.RecruitResume;
import com.ruoyi.recruit.service.IRecruitResumeService;

/**
 * 学生简历信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-04-03
 */
@Service
public class RecruitResumeServiceImpl implements IRecruitResumeService 
{
    @Autowired
    private RecruitResumeMapper recruitResumeMapper;

    /**
     * 查询学生简历信息
     * 
     * @param id 学生简历信息ID
     * @return 学生简历信息
     */
    @Override
    public RecruitResume selectRecruitResumeById(Long id)
    {
        return recruitResumeMapper.selectRecruitResumeById(id);
    }

    /**
     * 查询学生简历信息列表
     * 
     * @param recruitResume 学生简历信息
     * @return 学生简历信息
     */
    @Override
    public List<RecruitResume> selectRecruitResumeList(RecruitResume recruitResume)
    {
        return recruitResumeMapper.selectRecruitResumeList(recruitResume);
    }

    /**
     * 新增学生简历信息
     * 
     * @param recruitResume 学生简历信息
     * @return 结果
     */
    @Override
    public int insertRecruitResume(RecruitResume recruitResume)
    {
        return recruitResumeMapper.insertRecruitResume(recruitResume);
    }

    /**
     * 修改学生简历信息
     * 
     * @param recruitResume 学生简历信息
     * @return 结果
     */
    @Override
    public int updateRecruitResume(RecruitResume recruitResume)
    {
        return recruitResumeMapper.updateRecruitResume(recruitResume);
    }

    /**
     * 批量删除学生简历信息
     * 
     * @param ids 需要删除的学生简历信息ID
     * @return 结果
     */
    @Override
    public int deleteRecruitResumeByIds(Long[] ids)
    {
        return recruitResumeMapper.deleteRecruitResumeByIds(ids);
    }

    /**
     * 删除学生简历信息信息
     * 
     * @param id 学生简历信息ID
     * @return 结果
     */
    @Override
    public int deleteRecruitResumeById(Long id)
    {
        return recruitResumeMapper.deleteRecruitResumeById(id);
    }
}
