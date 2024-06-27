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
import com.ruoyi.recruit.domain.RecruitResume;
import com.ruoyi.recruit.service.IRecruitResumeService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 学生简历信息Controller
 *
 * @author ruoyi
 * @date 2021-04-03
 */
@RestController
@RequestMapping("/recruit/resume")
public class RecruitResumeController extends BaseController {
    @Autowired
    private IRecruitResumeService recruitResumeService;

    /**
     * 查询学生简历信息列表
     */
    @PreAuthorize("@ss.hasPermi('recruit:resume:list')")
    @GetMapping("/list")
    public TableDataInfo list(RecruitResume recruitResume) {
        startPage();
        List<RecruitResume> list = recruitResumeService.selectRecruitResumeList(recruitResume);
        return getDataTable(list);
    }

    @GetMapping("/company")
    public TableDataInfo company(RecruitResume recruitResume) {
        List<RecruitResume> list = recruitResumeService.selectRecruitResumeList(recruitResume);
        return getDataTable(list);
    }

    /**
     * 导出学生简历信息列表
     */
    @PreAuthorize("@ss.hasPermi('recruit:resume:export')")
    @Log(title = "学生简历信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(RecruitResume recruitResume) {
        List<RecruitResume> list = recruitResumeService.selectRecruitResumeList(recruitResume);
        ExcelUtil<RecruitResume> util = new ExcelUtil<RecruitResume>(RecruitResume.class);
        return util.exportExcel(list, "resume");
    }

    /**
     * 获取学生简历信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('recruit:resume:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(recruitResumeService.selectRecruitResumeById(id));
    }

    /**
     * 新增学生简历信息
     */
    @PreAuthorize("@ss.hasPermi('recruit:resume:add')")
    @Log(title = "学生简历信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RecruitResume recruitResume) {
        return toAjax(recruitResumeService.insertRecruitResume(recruitResume));
    }

    /**
     * 修改学生简历信息
     */
    @PreAuthorize("@ss.hasPermi('recruit:resume:edit')")
    @Log(title = "学生简历信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody RecruitResume recruitResume) {
        return toAjax(recruitResumeService.updateRecruitResume(recruitResume));
    }

    /**
     * 删除学生简历信息
     */
    @PreAuthorize("@ss.hasPermi('recruit:resume:remove')")
    @Log(title = "学生简历信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(recruitResumeService.deleteRecruitResumeByIds(ids));
    }
}
