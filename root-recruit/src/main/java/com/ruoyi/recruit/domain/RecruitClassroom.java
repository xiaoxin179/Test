package com.ruoyi.recruit.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 教室对象 recruit_classroom
 * 
 * @author root
 * @date 2021-04-03
 */
public class RecruitClassroom extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 教室名 */
    @Excel(name = "教室名")
    private String classroom;

    /** 地点 */
    @Excel(name = "地点")
    private String place;

    /** 容纳人数 */
    @Excel(name = "容纳人数")
    private Integer capacity;

    /** 是否占用(0:没有占用，1:占用) */
    @Excel(name = "是否占用(0:没有占用，1:占用)")
    private Integer occupied;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setClassroom(String classroom) 
    {
        this.classroom = classroom;
    }

    public String getClassroom() 
    {
        return classroom;
    }
    public void setPlace(String place) 
    {
        this.place = place;
    }

    public String getPlace() 
    {
        return place;
    }
    public void setCapacity(Integer capacity) 
    {
        this.capacity = capacity;
    }

    public Integer getCapacity() 
    {
        return capacity;
    }
    public void setOccupied(Integer occupied) 
    {
        this.occupied = occupied;
    }

    public Integer getOccupied() 
    {
        return occupied;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("classroom", getClassroom())
            .append("place", getPlace())
            .append("capacity", getCapacity())
            .append("occupied", getOccupied())
            .toString();
    }
}
