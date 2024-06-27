package com.ruoyi.recruit.service;

import java.util.List;
import com.ruoyi.recruit.domain.RecruitLecture;

/**
 * 讲座申请Service接口
 *
 * @author ruoyi
 * @date 2021-04-03
 */
public interface IRecruitLectureService
{
    /**
     * 查询讲座申请
     *
     * @param id 讲座申请ID
     * @return 讲座申请
     */
    public RecruitLecture selectRecruitLectureById(Long id);

    /**
     * 查询讲座申请列表
     *
     * @param recruitLecture 讲座申请
     * @return 讲座申请集合
     */
    public List<RecruitLecture> selectRecruitLectureList(RecruitLecture recruitLecture);

    /**
     * 新增讲座申请
     *
     * @param recruitLecture 讲座申请
     * @return 结果
     */
    public int insertRecruitLecture(RecruitLecture recruitLecture);

    /**
     * 修改讲座申请
     *
     * @param recruitLecture 讲座申请
     * @return 结果
     */
    public int updateRecruitLecture(RecruitLecture recruitLecture);

    /**
     * 批量删除讲座申请
     *
     * @param ids 需要删除的讲座申请ID
     * @return 结果
     */
    public int deleteRecruitLectureByIds(Long[] ids);

    /**
     * 删除讲座申请信息
     *
     * @param id 讲座申请ID
     * @return 结果
     */
    public int deleteRecruitLectureById(Long id);

    List<RecruitLecture> myLectureList();

}
