package com.ruoyi.recruit.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.system.domain.SysUserRole;
import com.ruoyi.system.mapper.SysUserMapper;
import com.ruoyi.system.mapper.SysUserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.recruit.mapper.RecruitCompanyInfoMapper;
import com.ruoyi.recruit.domain.RecruitCompanyInfo;
import com.ruoyi.recruit.service.IRecruitCompanyInfoService;

import javax.annotation.Resource;

/**
 * 企业信息Service业务层处理
 *
 * @author root
 * @date 2021-02-20
 */
@Service
public class RecruitCompanyInfoServiceImpl implements IRecruitCompanyInfoService {
    @Resource
    private RecruitCompanyInfoMapper recruitCompanyInfoMapper;
    @Resource
    private SysUserRoleMapper userRoleMapper;
    @Resource
    private SysUserMapper userMapper;

    /**
     * 查询企业信息
     *
     * @param id 企业信息ID
     * @return 企业信息
     */
    @Override
    public RecruitCompanyInfo selectRecruitCompanyInfoById(Long id) {
        return recruitCompanyInfoMapper.selectRecruitCompanyInfoById(id);
    }

    /**
     * 查询企业信息列表
     *
     * @param recruitCompanyInfo 企业信息
     * @return 企业信息
     */
    @Override
    public List<RecruitCompanyInfo> selectRecruitCompanyInfoList(RecruitCompanyInfo recruitCompanyInfo) {
        return recruitCompanyInfoMapper.selectRecruitCompanyInfoList(recruitCompanyInfo);
    }

    /**
     * 新增企业信息
     *
     * @param recruitCompanyInfo 企业信息
     * @return 结果
     */
    @Override
    public int insertRecruitCompanyInfo(RecruitCompanyInfo recruitCompanyInfo) {
        return recruitCompanyInfoMapper.insertRecruitCompanyInfo(recruitCompanyInfo);
    }

    /**
     * 修改企业信息
     *
     * @param recruitCompanyInfo 企业信息
     * @return 结果
     */
    @Override
    public int updateRecruitCompanyInfo(RecruitCompanyInfo recruitCompanyInfo) {
        Long userId = recruitCompanyInfo.getUserId();
        // 删除用户与角色关联
        userRoleMapper.deleteUserRoleByUserId(userId);
        // 新增用户与角色管理
        SysUserRole userRole = new SysUserRole();
        userRole.setUserId(userId);

        if (recruitCompanyInfo.getAuditState() == 2) {//通过
            userRole.setRoleId(100L);
        } else {//不是通过
            userRole.setRoleId(102L);
        }
        ArrayList<SysUserRole> arrayList = new ArrayList<>();
        arrayList.add(userRole);
        userRoleMapper.batchUserRole(arrayList);

        return recruitCompanyInfoMapper.updateRecruitCompanyInfo(recruitCompanyInfo);
    }

    /**
     * 批量删除企业信息
     *
     * @param ids 需要删除的企业信息ID
     * @return 结果
     */
    @Override
    public int deleteRecruitCompanyInfoByIds(Long[] ids) {
        return recruitCompanyInfoMapper.deleteRecruitCompanyInfoByIds(ids);
    }

    /**
     * 删除企业信息信息
     *
     * @param id 企业信息ID
     * @return 结果
     */
    @Override
    public int deleteRecruitCompanyInfoById(Long id) {
        return recruitCompanyInfoMapper.deleteRecruitCompanyInfoById(id);
    }
}
