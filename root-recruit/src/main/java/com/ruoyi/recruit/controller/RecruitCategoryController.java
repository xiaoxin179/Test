package com.ruoyi.recruit.controller;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.recruit.domain.RecruitCategory;
import com.ruoyi.recruit.service.IRecruitCategoryService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 岗位分类Controller
 *
 * @author ruoyi
 * @date 2021-03-25
 */
@RestController
@RequestMapping("/recruit/category")
public class RecruitCategoryController extends BaseController {
    @Autowired
    private IRecruitCategoryService recruitCategoryService;

    /**
     * 普通用户查询岗位分类列表
     */
    @GetMapping("/big")
    public TableDataInfo recruitList(RecruitCategory recruitCategory) {
        startPage();
        List<RecruitCategory> list = recruitCategoryService.selectBigCategoryList(recruitCategory);
        return getDataTable(list);
    }
    /**
     * 查询岗位分类列表
     */
    @PreAuthorize("@ss.hasPermi('recruit:category:list')")
    @GetMapping("/list")
    public TableDataInfo list(RecruitCategory recruitCategory) {
        startPage();
        List<RecruitCategory> list = recruitCategoryService.selectRecruitCategoryList(recruitCategory);
        return getDataTable(list);
    }

    /**
     * 导出岗位分类列表
     */
    @PreAuthorize("@ss.hasPermi('recruit:category:export')")
    @Log(title = "岗位分类", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(RecruitCategory recruitCategory) {
        List<RecruitCategory> list = recruitCategoryService.selectRecruitCategoryList(recruitCategory);
        ExcelUtil<RecruitCategory> util = new ExcelUtil<RecruitCategory>(RecruitCategory.class);
        return util.exportExcel(list, "category");
    }

    /**
     * 获取岗位分类详细信息
     */
    @PreAuthorize("@ss.hasPermi('recruit:category:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(recruitCategoryService.selectRecruitCategoryById(id));
    }

    /**
     * 新增岗位分类
     */
    @PreAuthorize("@ss.hasPermi('recruit:category:add')")
    @Log(title = "岗位分类", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RecruitCategory recruitCategory) {
        return toAjax(recruitCategoryService.insertRecruitCategory(recruitCategory));
    }

    /**
     * 修改岗位分类
     */
    @PreAuthorize("@ss.hasPermi('recruit:category:edit')")
    @Log(title = "岗位分类", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody RecruitCategory recruitCategory) {
        return toAjax(recruitCategoryService.updateRecruitCategory(recruitCategory));
    }

    /**
     * 删除岗位分类
     */
    @PreAuthorize("@ss.hasPermi('recruit:category:remove')")
    @Log(title = "岗位分类", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(recruitCategoryService.deleteRecruitCategoryByIds(ids));
    }
}
