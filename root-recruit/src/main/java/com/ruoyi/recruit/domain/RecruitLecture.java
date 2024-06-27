package com.ruoyi.recruit.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 讲座申请对象 recruit_lecture
 *
 * @author ruoyi
 * @date 2021-05-03
 */
public class RecruitLecture extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 公司名称 */
    @Excel(name = "公司名称")
    private String companyName;

    /** 公司地址 */
    @Excel(name = "公司地址")
    private String companyAddress;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String phone;

    /** 企业描述 */
    @Excel(name = "企业描述")
    private String description;

    /** 方向 */
    @Excel(name = "方向")
    private String direct;

    /** 宣讲座地点（教室名） */
    @Excel(name = "宣讲座地点", readConverterExp = "教=室名")
    private String classroom;

    /** 开讲座时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开讲座时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startTime;

    /** 审核状态 */
    @Excel(name = "审核状态")
    private Integer auditState;

    /** 申请类型 */
    @Excel(name = "申请类型")
    private Integer type;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setCompanyName(String companyName)
    {
        this.companyName = companyName;
    }

    public String getCompanyName()
    {
        return companyName;
    }
    public void setCompanyAddress(String companyAddress)
    {
        this.companyAddress = companyAddress;
    }

    public String getCompanyAddress()
    {
        return companyAddress;
    }
    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getPhone()
    {
        return phone;
    }
    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getDescription()
    {
        return description;
    }
    public void setDirect(String direct)
    {
        this.direct = direct;
    }

    public String getDirect()
    {
        return direct;
    }
    public void setClassroom(String classroom)
    {
        this.classroom = classroom;
    }

    public String getClassroom()
    {
        return classroom;
    }
    public void setStartTime(Date startTime)
    {
        this.startTime = startTime;
    }

    public Date getStartTime()
    {
        return startTime;
    }
    public void setAuditState(Integer auditState)
    {
        this.auditState = auditState;
    }

    public Integer getAuditState()
    {
        return auditState;
    }
    public void setType(Integer type)
    {
        this.type = type;
    }

    public Integer getType()
    {
        return type;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("companyName", getCompanyName())
                .append("companyAddress", getCompanyAddress())
                .append("phone", getPhone())
                .append("description", getDescription())
                .append("direct", getDirect())
                .append("classroom", getClassroom())
                .append("startTime", getStartTime())
                .append("auditState", getAuditState())
                .append("type", getType())
                .toString();
    }
}
