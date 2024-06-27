package com.ruoyi.recruit.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.utils.StringUtils;
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
 * 招聘岗位对象 recruit_position
 *
 * @author ruoyi
 * @date 2021-03-25
 */
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class RecruitPosition extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 职务名称
     */
    @Excel(name = "职务名称")
    private String name;

    /**
     * 要求
     */
    @Excel(name = "要求")
    private String requirement;

    /**
     * 工作城市
     */
    @Excel(name = "工作城市")
    private String workCity;

    /**
     * 联系电话
     */
    @Excel(name = "联系电话")
    private String phonenumber;

    /**
     * 发布时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "发布时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date releaseDate;

    /**
     * 截止日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "截止日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date validDate;

    /**
     * 招聘人数
     */
    @Excel(name = "招聘人数")
    private Integer quantity;

    /**
     * 状态
     */
    @Excel(name = "状态")
    private Integer status;

    /**
     * 审核状态
     */
    @Excel(name = "审核状态")
    private Integer auditState;

    /**
     * 最低薪资（单位k）
     */
    @Excel(name = "最低薪资", readConverterExp = "单位k")
    private Integer salaryUp;

    /**
     * 最高薪资（单位k）
     */
    @Excel(name = "最高薪资", readConverterExp = "单位k")
    private Integer salaryDown;

    /**
     * 是否热门
     */
    @Excel(name = "是否热门")
    private Integer hot;

    /**
     * 公司ID
     */
    @Excel(name = "公司ID")
    private Long companyId;

    /**
     * 分类ID
     */
    @Excel(name = "分类ID")
    private Long categoryId;

    private RecruitCategory category;

    private RecruitCompanyInfo company;


    private Long userId;

    public Integer getStatus() {
        //0是未结束1是结束
        if (StringUtils.isNull(validDate)) {
            return null;
        }
        status = new Date().after(validDate) ? 0 : 1;
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("name", getName())
                .append("requirement", getRequirement())
                .append("workCity", getWorkCity())
                .append("phonenumber", getPhonenumber())
                .append("releaseDate", getReleaseDate())
                .append("validDate", getValidDate())
                .append("quantity", getQuantity())
                .append("status", getStatus())
                .append("auditState", getAuditState())
                .append("salaryUp", getSalaryUp())
                .append("salaryDown", getSalaryDown())
                .append("hot", getHot())
                .append("companyId", getCompanyId())
                .append("categoryId", getCategoryId())
                .toString();
    }
}
