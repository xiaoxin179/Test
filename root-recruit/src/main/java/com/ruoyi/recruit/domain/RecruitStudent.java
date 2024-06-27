package com.ruoyi.recruit.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 学生个人信息对象 recruit_student
 * 
 * @author ruoyi
 * @date 2021-04-03
 */
public class RecruitStudent extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 所在院系 */
    @Excel(name = "所在院系")
    private String dept;

    /** 所在班级 */
    @Excel(name = "所在班级")
    private String stuClass;

    /** 学号 */
    @Excel(name = "学号")
    private String code;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 性别 */
    @Excel(name = "性别")
    private String sex;

    /** 身高 */
    @Excel(name = "身高")
    private BigDecimal height;

    /** 体重 */
    @Excel(name = "体重")
    private BigDecimal weight;

    /** 年龄 */
    @Excel(name = "年龄")
    private Long age;

    /** 身份证号 */
    @Excel(name = "身份证号")
    private String identityCard;

    /** 家庭住址 */
    @Excel(name = "家庭住址")
    private String address;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String tel;

    /** 邮箱 */
    @Excel(name = "邮箱")
    private String email;

    /** 所学专业 */
    @Excel(name = "所学专业")
    private String major;

    /** 求职意向 */
    @Excel(name = "求职意向")
    private String jobIntent;

    /** 掌握技能 */
    @Excel(name = "掌握技能")
    private String skill;

    /** 所获奖项 */
    @Excel(name = "所获奖项")
    private String award;

    /** 自我评价 */
    @Excel(name = "自我评价")
    private String selfEvaluation;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setDept(String dept) 
    {
        this.dept = dept;
    }

    public String getDept() 
    {
        return dept;
    }
    public void setStuClass(String stuClass) 
    {
        this.stuClass = stuClass;
    }

    public String getStuClass() 
    {
        return stuClass;
    }
    public void setCode(String code) 
    {
        this.code = code;
    }

    public String getCode() 
    {
        return code;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setSex(String sex) 
    {
        this.sex = sex;
    }

    public String getSex() 
    {
        return sex;
    }
    public void setHeight(BigDecimal height) 
    {
        this.height = height;
    }

    public BigDecimal getHeight() 
    {
        return height;
    }
    public void setWeight(BigDecimal weight) 
    {
        this.weight = weight;
    }

    public BigDecimal getWeight() 
    {
        return weight;
    }
    public void setAge(Long age) 
    {
        this.age = age;
    }

    public Long getAge() 
    {
        return age;
    }
    public void setIdentityCard(String identityCard) 
    {
        this.identityCard = identityCard;
    }

    public String getIdentityCard() 
    {
        return identityCard;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setTel(String tel) 
    {
        this.tel = tel;
    }

    public String getTel() 
    {
        return tel;
    }
    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getEmail() 
    {
        return email;
    }
    public void setMajor(String major) 
    {
        this.major = major;
    }

    public String getMajor() 
    {
        return major;
    }
    public void setJobIntent(String jobIntent) 
    {
        this.jobIntent = jobIntent;
    }

    public String getJobIntent() 
    {
        return jobIntent;
    }
    public void setSkill(String skill) 
    {
        this.skill = skill;
    }

    public String getSkill() 
    {
        return skill;
    }
    public void setAward(String award) 
    {
        this.award = award;
    }

    public String getAward() 
    {
        return award;
    }
    public void setSelfEvaluation(String selfEvaluation) 
    {
        this.selfEvaluation = selfEvaluation;
    }

    public String getSelfEvaluation() 
    {
        return selfEvaluation;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("dept", getDept())
            .append("stuClass", getStuClass())
            .append("code", getCode())
            .append("name", getName())
            .append("sex", getSex())
            .append("height", getHeight())
            .append("weight", getWeight())
            .append("age", getAge())
            .append("identityCard", getIdentityCard())
            .append("address", getAddress())
            .append("tel", getTel())
            .append("email", getEmail())
            .append("major", getMajor())
            .append("jobIntent", getJobIntent())
            .append("skill", getSkill())
            .append("award", getAward())
            .append("selfEvaluation", getSelfEvaluation())
            .toString();
    }
}
