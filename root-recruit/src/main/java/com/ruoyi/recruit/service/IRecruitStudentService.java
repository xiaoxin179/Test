package com.ruoyi.recruit.service;

import java.util.List;
import com.ruoyi.recruit.domain.RecruitStudent;

/**
 * 学生个人信息Service接口
 * 
 * @author ruoyi
 * @date 2021-04-03
 */
public interface IRecruitStudentService 
{
    /**
     * 查询学生个人信息
     * 
     * @param id 学生个人信息ID
     * @return 学生个人信息
     */
    public RecruitStudent selectRecruitStudentById(Long id);

    /**
     * 查询学生个人信息列表
     * 
     * @param recruitStudent 学生个人信息
     * @return 学生个人信息集合
     */
    public List<RecruitStudent> selectRecruitStudentList(RecruitStudent recruitStudent);

    /**
     * 新增学生个人信息
     * 
     * @param recruitStudent 学生个人信息
     * @return 结果
     */
    public int insertRecruitStudent(RecruitStudent recruitStudent);

    /**
     * 修改学生个人信息
     * 
     * @param recruitStudent 学生个人信息
     * @return 结果
     */
    public int updateRecruitStudent(RecruitStudent recruitStudent);

    /**
     * 批量删除学生个人信息
     * 
     * @param ids 需要删除的学生个人信息ID
     * @return 结果
     */
    public int deleteRecruitStudentByIds(Long[] ids);

    /**
     * 删除学生个人信息信息
     * 
     * @param id 学生个人信息ID
     * @return 结果
     */
    public int deleteRecruitStudentById(Long id);
}
