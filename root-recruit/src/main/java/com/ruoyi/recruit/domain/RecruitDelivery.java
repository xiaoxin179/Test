package com.ruoyi.recruit.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 简历投递信息对象 recruit_delivery
 *
 * @author ruoyi
 * @date 2021-04-22
 */
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class RecruitDelivery extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 用户ID */
    @Excel(name = "用户ID")
    private Long userId;

    /** 用户账号 */
    @Excel(name = "用户账号")
    private String userName;

    /** 岗位信息ID */
    @Excel(name = "岗位信息ID")
    private Long positionId;

    /** 岗位名称 */
    @Excel(name = "岗位名称")
    private String positionName;

    /** 投递状态 */
    @Excel(name = "投递状态")
    private Integer status;

    /** 公司ID */
    @Excel(name = "公司ID")
    private Long companyId;

    /** 公司名称 */
    @Excel(name = "公司名称")
    private String companyName;

    private RecruitCompanyInfo company;

    private RecruitPosition position;

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("userId", getUserId())
                .append("userName", getUserName())
                .append("positionId", getPositionId())
                .append("positionName", getPositionName())
                .append("status", getStatus())
                .append("companyId", getCompanyId())
                .append("companyName", getCompanyName())
                .toString();
    }
}
