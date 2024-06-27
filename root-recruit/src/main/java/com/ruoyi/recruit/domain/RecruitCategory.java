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

import java.util.List;

/**
 * 岗位分类对象 recruit_category
 *
 * @author ruoyi
 * @date 2021-03-25
 */
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class RecruitCategory extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 分类名称 */
    @Excel(name = "分类名称")
    private String categoryName;

    /** 描述 */
    @Excel(name = "描述")
    private String description;

    /** 父ID */
    @Excel(name = "父ID")
    private Long parentId;

    private RecruitCategory parentCategory;
    private List<RecruitCategory> childCategoryList;

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("categoryName", getCategoryName())
            .append("description", getDescription())
            .append("parentId", getParentId())
            .toString();
    }
}
