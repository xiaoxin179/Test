package com.ruoyi.recruit.service.impl;

import java.util.List;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.recruit.domain.RecruitClassroom;
import com.ruoyi.recruit.mapper.RecruitClassroomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.recruit.mapper.RecruitLectureMapper;
import com.ruoyi.recruit.domain.RecruitLecture;
import com.ruoyi.recruit.service.IRecruitLectureService;

import javax.annotation.Resource;

/**
 * 讲座申请Service业务层处理
 *
 * @author ruoyi
 * @date 2021-04-03
 */
@Service
public class RecruitLectureServiceImpl implements IRecruitLectureService {
    @Autowired
    private RecruitLectureMapper recruitLectureMapper;
    @Resource
    private RecruitClassroomMapper classroomMapper;

    /**
     * 查询讲座申请
     *
     * @param id 讲座申请ID
     * @return 讲座申请
     */
    @Override
    public RecruitLecture selectRecruitLectureById(Long id) {
        return recruitLectureMapper.selectRecruitLectureById(id);
    }

    /**
     * 查询讲座申请列表
     *
     * @param recruitLecture 讲座申请
     * @return 讲座申请
     */
    @Override
    public List<RecruitLecture> selectRecruitLectureList(RecruitLecture recruitLecture) {
        return recruitLectureMapper.selectRecruitLectureList(recruitLecture);
    }

    /**
     * 新增讲座申请
     *
     * @param recruitLecture 讲座申请
     * @return 结果
     */
    @Override
    public int insertRecruitLecture(RecruitLecture recruitLecture) {
        RecruitClassroom classroom = new RecruitClassroom();
        classroom.setClassroom(recruitLecture.getClassroom());
        classroom.setOccupied(1);
        classroomMapper.updateOccupied(classroom);
        return recruitLectureMapper.insertRecruitLecture(recruitLecture);
    }

    /**
     * 修改讲座申请
     *
     * @param recruitLecture 讲座申请
     * @return 结果
     */
    @Override
    public int updateRecruitLecture(RecruitLecture recruitLecture) {
        return recruitLectureMapper.updateRecruitLecture(recruitLecture);
    }

    /**
     * 批量删除讲座申请
     *
     * @param ids 需要删除的讲座申请ID
     * @return 结果
     */
    @Override
    public int deleteRecruitLectureByIds(Long[] ids) {
        //先查出
        for (Long id : ids) {
            RecruitLecture lecture = recruitLectureMapper.selectRecruitLectureById(id);

            RecruitClassroom classroom = new RecruitClassroom();
            classroom.setClassroom(lecture.getClassroom());
            classroom.setOccupied(0);
            classroomMapper.updateOccupied(classroom);
        }
        return recruitLectureMapper.deleteRecruitLectureByIds(ids);
    }

    /**
     * 删除讲座申请信息
     *
     * @param id 讲座申请ID
     * @return 结果
     */
    @Override
    public int deleteRecruitLectureById(Long id) {
        RecruitLecture lecture = recruitLectureMapper.selectRecruitLectureById(id);

        RecruitClassroom classroom = new RecruitClassroom();
        classroom.setClassroom(lecture.getClassroom());
        classroom.setOccupied(0);
        classroomMapper.updateOccupied(classroom);

        return recruitLectureMapper.deleteRecruitLectureById(id);
    }

    @Override
    public List<RecruitLecture> myLectureList() {
        Long userId = SecurityUtils.getLoginUser().getUser().getUserId();
        return recruitLectureMapper.myLectureList(userId);
    }
}
