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
import com.ruoyi.recruit.domain.RecruitLecture;
import com.ruoyi.recruit.service.IRecruitLectureService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 讲座申请Controller
 *
 * @author ruoyi
 * @date 2021-04-03
 */
@RestController
@RequestMapping("/recruit/lecture")
public class RecruitLectureController extends BaseController {
    @Autowired
    private IRecruitLectureService recruitLectureService;

    /**
     * 查询讲座申请列表
     */
    @PreAuthorize("@ss.hasPermi('recruit:lecture:list')")
    @GetMapping("/list")
    public TableDataInfo list(RecruitLecture recruitLecture) {
        startPage();
        List<RecruitLecture> list = recruitLectureService.selectRecruitLectureList(recruitLecture);
        return getDataTable(list);
    }

    /**
     * 根据用户ID查公司，根据公司名查该公司的讲座
     */
    @PreAuthorize("@ss.hasPermi('recruit:lecture:list')")
    @GetMapping("/my")
    public TableDataInfo my() {
        List<RecruitLecture> list = recruitLectureService.myLectureList();
        return getDataTable(list);
    }

    /**
     * 导出讲座申请列表
     */
    @PreAuthorize("@ss.hasPermi('recruit:lecture:export')")
    @Log(title = "讲座申请", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(RecruitLecture recruitLecture) {
        List<RecruitLecture> list = recruitLectureService.selectRecruitLectureList(recruitLecture);
        ExcelUtil<RecruitLecture> util = new ExcelUtil<RecruitLecture>(RecruitLecture.class);
        return util.exportExcel(list, "lecture");
    }

    /**
     * 获取讲座申请详细信息
     */
    @PreAuthorize("@ss.hasPermi('recruit:lecture:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(recruitLectureService.selectRecruitLectureById(id));
    }

    /**
     * 新增讲座申请
     */
    @PreAuthorize("@ss.hasPermi('recruit:lecture:add')")
    @Log(title = "讲座申请", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RecruitLecture recruitLecture) {
        return toAjax(recruitLectureService.insertRecruitLecture(recruitLecture));
    }

    /**
     * 修改讲座申请
     */
    @PreAuthorize("@ss.hasPermi('recruit:lecture:edit')")
    @Log(title = "讲座申请", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody RecruitLecture recruitLecture) {
        return toAjax(recruitLectureService.updateRecruitLecture(recruitLecture));
    }

    /**
     * 删除讲座申请
     */
    @PreAuthorize("@ss.hasPermi('recruit:lecture:remove')")
    @Log(title = "讲座申请", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(recruitLectureService.deleteRecruitLectureByIds(ids));
    }
}
