package com.ruoyi.recruit.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 学生简历信息对象 recruit_resume
 *
 * @author ruoyi
 * @date 2021-04-07
 */
public class RecruitResume extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 用户ID */
    @Excel(name = "用户ID")
    private Long userId;

    /** 用户账号 */
    @Excel(name = "用户账号")
    private String userName;

    /** 性别 */
    @Excel(name = "性别")
    private String sex;

    /** 民族 */
    @Excel(name = "民族")
    private String minority;

    /** 身高 */
    @Excel(name = "身高")
    private String height;

    /** 体重 */
    @Excel(name = "体重")
    private String weight;

    /** 政治面貌 */
    @Excel(name = "政治面貌")
    private String politicalOutlook;

    /** 最高学历 */
    @Excel(name = "最高学历")
    private String highestEducation;

    /** 健康状况 */
    @Excel(name = "健康状况")
    private String health;

    /** 求职意向 */
    @Excel(name = "求职意向")
    private String jobIntention;

    /** 出生年月 */
    @Excel(name = "出生年月")
    private String birthday;

    /** 照片 */
    @Excel(name = "照片")
    private String photo;

    /** 所学专业 */
    @Excel(name = "所学专业")
    private String major;

    /** 现居住地 */
    @Excel(name = "现居住地")
    private String currentResidence;

    /** 通讯地址 */
    @Excel(name = "通讯地址")
    private String postalAddress;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String phone;

    /** 邮箱 */
    @Excel(name = "邮箱")
    private String email;

    /** 所获奖项 */
    @Excel(name = "所获奖项")
    private String awards;

    /** 专业课程 */
    @Excel(name = "专业课程")
    private String professionalCourses;

    /** 自我评价 */
    @Excel(name = "自我评价")
    private String selfEvaluation;

    /** 简历附件 */
    @Excel(name = "简历附件")
    private String url;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public Long getUserId()
    {
        return userId;
    }
    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getUserName()
    {
        return userName;
    }
    public void setSex(String sex)
    {
        this.sex = sex;
    }

    public String getSex()
    {
        return sex;
    }
    public void setMinority(String minority)
    {
        this.minority = minority;
    }

    public String getMinority()
    {
        return minority;
    }
    public void setHeight(String height)
    {
        this.height = height;
    }

    public String getHeight()
    {
        return height;
    }
    public void setWeight(String weight)
    {
        this.weight = weight;
    }

    public String getWeight()
    {
        return weight;
    }
    public void setPoliticalOutlook(String politicalOutlook)
    {
        this.politicalOutlook = politicalOutlook;
    }

    public String getPoliticalOutlook()
    {
        return politicalOutlook;
    }
    public void setHighestEducation(String highestEducation)
    {
        this.highestEducation = highestEducation;
    }

    public String getHighestEducation()
    {
        return highestEducation;
    }
    public void setHealth(String health)
    {
        this.health = health;
    }

    public String getHealth()
    {
        return health;
    }
    public void setJobIntention(String jobIntention)
    {
        this.jobIntention = jobIntention;
    }

    public String getJobIntention()
    {
        return jobIntention;
    }
    public void setBirthday(String birthday)
    {
        this.birthday = birthday;
    }

    public String getBirthday()
    {
        return birthday;
    }
    public void setPhoto(String photo)
    {
        this.photo = photo;
    }

    public String getPhoto()
    {
        return photo;
    }
    public void setMajor(String major)
    {
        this.major = major;
    }

    public String getMajor()
    {
        return major;
    }
    public void setCurrentResidence(String currentResidence)
    {
        this.currentResidence = currentResidence;
    }

    public String getCurrentResidence()
    {
        return currentResidence;
    }
    public void setPostalAddress(String postalAddress)
    {
        this.postalAddress = postalAddress;
    }

    public String getPostalAddress()
    {
        return postalAddress;
    }
    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getPhone()
    {
        return phone;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getEmail()
    {
        return email;
    }
    public void setAwards(String awards)
    {
        this.awards = awards;
    }

    public String getAwards()
    {
        return awards;
    }
    public void setProfessionalCourses(String professionalCourses)
    {
        this.professionalCourses = professionalCourses;
    }

    public String getProfessionalCourses()
    {
        return professionalCourses;
    }
    public void setSelfEvaluation(String selfEvaluation)
    {
        this.selfEvaluation = selfEvaluation;
    }

    public String getSelfEvaluation()
    {
        return selfEvaluation;
    }
    public void setUrl(String url)
    {
        this.url = url;
    }

    public String getUrl()
    {
        return url;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("userId", getUserId())
                .append("userName", getUserName())
                .append("sex", getSex())
                .append("minority", getMinority())
                .append("height", getHeight())
                .append("weight", getWeight())
                .append("politicalOutlook", getPoliticalOutlook())
                .append("highestEducation", getHighestEducation())
                .append("health", getHealth())
                .append("jobIntention", getJobIntention())
                .append("birthday", getBirthday())
                .append("photo", getPhoto())
                .append("major", getMajor())
                .append("currentResidence", getCurrentResidence())
                .append("postalAddress", getPostalAddress())
                .append("phone", getPhone())
                .append("email", getEmail())
                .append("awards", getAwards())
                .append("professionalCourses", getProfessionalCourses())
                .append("selfEvaluation", getSelfEvaluation())
                .append("url", getUrl())
                .toString();
    }
}
