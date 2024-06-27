package com.ruoyi.recruit.service;

import java.util.List;
import com.ruoyi.recruit.domain.RecruitClassroom;

/**
 * 教室Service接口
 * 
 * @author root
 * @date 2021-04-03
 */
public interface IRecruitClassroomService 
{
    /**
     * 查询教室
     * 
     * @param id 教室ID
     * @return 教室
     */
    public RecruitClassroom selectRecruitClassroomById(Long id);

    /**
     * 查询教室列表
     * 
     * @param recruitClassroom 教室
     * @return 教室集合
     */
    public List<RecruitClassroom> selectRecruitClassroomList(RecruitClassroom recruitClassroom);

    /**
     * 新增教室
     * 
     * @param recruitClassroom 教室
     * @return 结果
     */
    public int insertRecruitClassroom(RecruitClassroom recruitClassroom);

    /**
     * 修改教室
     * 
     * @param recruitClassroom 教室
     * @return 结果
     */
    public int updateRecruitClassroom(RecruitClassroom recruitClassroom);

    /**
     * 批量删除教室
     * 
     * @param ids 需要删除的教室ID
     * @return 结果
     */
    public int deleteRecruitClassroomByIds(Long[] ids);

    /**
     * 删除教室信息
     * 
     * @param id 教室ID
     * @return 结果
     */
    public int deleteRecruitClassroomById(Long id);
}
