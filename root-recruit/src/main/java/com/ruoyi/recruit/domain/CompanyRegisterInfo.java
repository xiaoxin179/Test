package com.ruoyi.recruit.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.common.core.domain.entity.SysUser;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * 企业注册信息对象
 *
 * @author root
 * @date 2021-02-20
 */
@Data
public class CompanyRegisterInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    private SysUser user;
    private RecruitCompanyInfo companyInfo;
}
