package com.ruoyi.recruit.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.recruit.mapper.RecruitStudentMapper;
import com.ruoyi.recruit.domain.RecruitStudent;
import com.ruoyi.recruit.service.IRecruitStudentService;

/**
 * 学生个人信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-04-03
 */
@Service
public class RecruitStudentServiceImpl implements IRecruitStudentService 
{
    @Autowired
    private RecruitStudentMapper recruitStudentMapper;

    /**
     * 查询学生个人信息
     * 
     * @param id 学生个人信息ID
     * @return 学生个人信息
     */
    @Override
    public RecruitStudent selectRecruitStudentById(Long id)
    {
        return recruitStudentMapper.selectRecruitStudentById(id);
    }

    /**
     * 查询学生个人信息列表
     * 
     * @param recruitStudent 学生个人信息
     * @return 学生个人信息
     */
    @Override
    public List<RecruitStudent> selectRecruitStudentList(RecruitStudent recruitStudent)
    {
        return recruitStudentMapper.selectRecruitStudentList(recruitStudent);
    }

    /**
     * 新增学生个人信息
     * 
     * @param recruitStudent 学生个人信息
     * @return 结果
     */
    @Override
    public int insertRecruitStudent(RecruitStudent recruitStudent)
    {
        return recruitStudentMapper.insertRecruitStudent(recruitStudent);
    }

    /**
     * 修改学生个人信息
     * 
     * @param recruitStudent 学生个人信息
     * @return 结果
     */
    @Override
    public int updateRecruitStudent(RecruitStudent recruitStudent)
    {
        return recruitStudentMapper.updateRecruitStudent(recruitStudent);
    }

    /**
     * 批量删除学生个人信息
     * 
     * @param ids 需要删除的学生个人信息ID
     * @return 结果
     */
    @Override
    public int deleteRecruitStudentByIds(Long[] ids)
    {
        return recruitStudentMapper.deleteRecruitStudentByIds(ids);
    }

    /**
     * 删除学生个人信息信息
     * 
     * @param id 学生个人信息ID
     * @return 结果
     */
    @Override
    public int deleteRecruitStudentById(Long id)
    {
        return recruitStudentMapper.deleteRecruitStudentById(id);
    }
}
