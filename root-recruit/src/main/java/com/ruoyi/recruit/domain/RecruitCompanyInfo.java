package com.ruoyi.recruit.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 企业信息对象 recruit_company_info
 *
 * @author root
 * @date 2021-02-20
 */
public class RecruitCompanyInfo extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * $column.columnComment
     */
    private Long id;

    /** 公司名称 */
    @Excel(name = "公司名称")
    private String name;

    /** 公司地址 */
    @Excel(name = "公司地址")
    private String address;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String phonenumber;

    /** 公司LOGO */
    @Excel(name = "公司LOGO")
    private String logo;

    /** 营业执照 */
    @Excel(name = "营业执照")
    private String license;

    /** 企业性质 */
    @Excel(name = "企业性质")
    private Integer nature;

    /** 企业描述 */
    @Excel(name = "企业描述")
    private String description;

    /** 审核状态 */
    @Excel(name = "审核状态")
    private Integer auditState;

    /** 是否热门 */
    @Excel(name = "是否热门")
    private Integer hot;
    private Long userId;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getAddress()
    {
        return address;
    }
    public void setPhonenumber(String phonenumber)
    {
        this.phonenumber = phonenumber;
    }

    public String getPhonenumber()
    {
        return phonenumber;
    }
    public void setLogo(String logo)
    {
        this.logo = logo;
    }

    public String getLogo()
    {
        return logo;
    }
    public void setLicense(String license)
    {
        this.license = license;
    }

    public String getLicense()
    {
        return license;
    }
    public void setNature(Integer nature)
    {
        this.nature = nature;
    }

    public Integer getNature()
    {
        return nature;
    }
    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getDescription()
    {
        return description;
    }
    public void setAuditState(Integer auditState)
    {
        this.auditState = auditState;
    }

    public Integer getAuditState()
    {
        return auditState;
    }
    public void setHot(Integer hot)
    {
        this.hot = hot;
    }

    public Integer getHot()
    {
        return hot;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("name", getName())
                .append("address", getAddress())
                .append("phonenumber", getPhonenumber())
                .append("logo", getLogo())
                .append("license", getLicense())
                .append("nature", getNature())
                .append("description", getDescription())
                .append("auditState", getAuditState())
                .append("hot", getHot())
                .toString();
    }
}
