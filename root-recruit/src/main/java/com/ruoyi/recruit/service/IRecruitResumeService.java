package com.ruoyi.recruit.service;

import java.util.List;
import com.ruoyi.recruit.domain.RecruitResume;

/**
 * 学生简历信息Service接口
 * 
 * @author ruoyi
 * @date 2021-04-03
 */
public interface IRecruitResumeService 
{
    /**
     * 查询学生简历信息
     * 
     * @param id 学生简历信息ID
     * @return 学生简历信息
     */
    public RecruitResume selectRecruitResumeById(Long id);

    /**
     * 查询学生简历信息列表
     * 
     * @param recruitResume 学生简历信息
     * @return 学生简历信息集合
     */
    public List<RecruitResume> selectRecruitResumeList(RecruitResume recruitResume);

    /**
     * 新增学生简历信息
     * 
     * @param recruitResume 学生简历信息
     * @return 结果
     */
    public int insertRecruitResume(RecruitResume recruitResume);

    /**
     * 修改学生简历信息
     * 
     * @param recruitResume 学生简历信息
     * @return 结果
     */
    public int updateRecruitResume(RecruitResume recruitResume);

    /**
     * 批量删除学生简历信息
     * 
     * @param ids 需要删除的学生简历信息ID
     * @return 结果
     */
    public int deleteRecruitResumeByIds(Long[] ids);

    /**
     * 删除学生简历信息信息
     * 
     * @param id 学生简历信息ID
     * @return 结果
     */
    public int deleteRecruitResumeById(Long id);
}
