package com.ruoyi.recruit.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.recruit.mapper.RecruitClassroomMapper;
import com.ruoyi.recruit.domain.RecruitClassroom;
import com.ruoyi.recruit.service.IRecruitClassroomService;

/**
 * 教室Service业务层处理
 * 
 * @author root
 * @date 2021-04-03
 */
@Service
public class RecruitClassroomServiceImpl implements IRecruitClassroomService 
{
    @Autowired
    private RecruitClassroomMapper recruitClassroomMapper;

    /**
     * 查询教室
     * 
     * @param id 教室ID
     * @return 教室
     */
    @Override
    public RecruitClassroom selectRecruitClassroomById(Long id)
    {
        return recruitClassroomMapper.selectRecruitClassroomById(id);
    }

    /**
     * 查询教室列表
     * 
     * @param recruitClassroom 教室
     * @return 教室
     */
    @Override
    public List<RecruitClassroom> selectRecruitClassroomList(RecruitClassroom recruitClassroom)
    {
        return recruitClassroomMapper.selectRecruitClassroomList(recruitClassroom);
    }

    /**
     * 新增教室
     * 
     * @param recruitClassroom 教室
     * @return 结果
     */
    @Override
    public int insertRecruitClassroom(RecruitClassroom recruitClassroom)
    {
        return recruitClassroomMapper.insertRecruitClassroom(recruitClassroom);
    }

    /**
     * 修改教室
     * 
     * @param recruitClassroom 教室
     * @return 结果
     */
    @Override
    public int updateRecruitClassroom(RecruitClassroom recruitClassroom)
    {
        return recruitClassroomMapper.updateRecruitClassroom(recruitClassroom);
    }

    /**
     * 批量删除教室
     * 
     * @param ids 需要删除的教室ID
     * @return 结果
     */
    @Override
    public int deleteRecruitClassroomByIds(Long[] ids)
    {
        return recruitClassroomMapper.deleteRecruitClassroomByIds(ids);
    }

    /**
     * 删除教室信息
     * 
     * @param id 教室ID
     * @return 结果
     */
    @Override
    public int deleteRecruitClassroomById(Long id)
    {
        return recruitClassroomMapper.deleteRecruitClassroomById(id);
    }
}
