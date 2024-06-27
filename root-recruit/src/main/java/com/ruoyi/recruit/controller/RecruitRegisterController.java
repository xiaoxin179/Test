package com.ruoyi.recruit.controller;

import com.ruoyi.common.annotation.AnonymousAccess;
import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.recruit.domain.CompanyRegisterInfo;
import com.ruoyi.recruit.domain.RecruitCompanyInfo;
import com.ruoyi.recruit.service.IRecruitCompanyInfoService;
import com.ruoyi.system.service.ISysUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author xyh
 * @date 2021/2/20 22:41
 */

@RestController
@RequestMapping("/recruit/register")
public class RecruitRegisterController extends BaseController{
    @Resource
    private ISysUserService userService;

    @Resource
    private IRecruitCompanyInfoService companyInfoService;

    @PostMapping
    @AnonymousAccess
    public AjaxResult register(@RequestBody CompanyRegisterInfo companyRegisterInfo) {
        SysUser user = companyRegisterInfo.getUser();
        RecruitCompanyInfo companyInfo = companyRegisterInfo.getCompanyInfo();
        if (UserConstants.NOT_UNIQUE.equals(userService.checkUserNameUnique(user.getUserName()))) {
            return AjaxResult.error("新增用户'" + user.getUserName() + "'失败，登录账号已存在");
        } else if (StringUtils.isNotEmpty(user.getPhonenumber())
                && UserConstants.NOT_UNIQUE.equals(userService.checkPhoneUnique(user))) {
            return AjaxResult.error("新增用户'" + user.getUserName() + "'失败，手机号码已存在");
        } else if (StringUtils.isNotEmpty(user.getEmail())
                && UserConstants.NOT_UNIQUE.equals(userService.checkEmailUnique(user))) {
            return AjaxResult.error("新增用户'" + user.getUserName() + "'失败，邮箱账号已存在");
        }
        user.setUserType(UserConstants.COMPANY_USER);
        user.setPostIds(new Long[]{1L});
        user.setRoleIds(new Long[]{102L});
        user.setPassword(SecurityUtils.encryptPassword(user.getPassword()));
        companyInfo.setPhonenumber(user.getPhonenumber());
        int insertUser = userService.insertUser(user);
        System.out.println(user.getUserId());
        companyInfo.setUserId(user.getUserId());
        int insertCompany = companyInfoService.insertRecruitCompanyInfo(companyInfo);
        return toAjax(insertUser +insertCompany);
    }
}
