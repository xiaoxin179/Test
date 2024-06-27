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
import com.ruoyi.recruit.domain.RecruitStudent;
import com.ruoyi.recruit.service.IRecruitStudentService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 学生个人信息Controller
 * 
 * @author ruoyi
 * @date 2021-04-03
 */
@RestController
@RequestMapping("/recruit/student")
public class RecruitStudentController extends BaseController
{
    @Autowired
    private IRecruitStudentService recruitStudentService;

    /**
     * 查询学生个人信息列表
     */
    @PreAuthorize("@ss.hasPermi('recruit:student:list')")
    @GetMapping("/list")
    public TableDataInfo list(RecruitStudent recruitStudent)
    {
        startPage();
        List<RecruitStudent> list = recruitStudentService.selectRecruitStudentList(recruitStudent);
        return getDataTable(list);
    }

    /**
     * 导出学生个人信息列表
     */
    @PreAuthorize("@ss.hasPermi('recruit:student:export')")
    @Log(title = "学生个人信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(RecruitStudent recruitStudent)
    {
        List<RecruitStudent> list = recruitStudentService.selectRecruitStudentList(recruitStudent);
        ExcelUtil<RecruitStudent> util = new ExcelUtil<RecruitStudent>(RecruitStudent.class);
        return util.exportExcel(list, "student");
    }

    /**
     * 获取学生个人信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('recruit:student:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(recruitStudentService.selectRecruitStudentById(id));
    }

    /**
     * 新增学生个人信息
     */
    @PreAuthorize("@ss.hasPermi('recruit:student:add')")
    @Log(title = "学生个人信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RecruitStudent recruitStudent)
    {
        return toAjax(recruitStudentService.insertRecruitStudent(recruitStudent));
    }

    /**
     * 修改学生个人信息
     */
    @PreAuthorize("@ss.hasPermi('recruit:student:edit')")
    @Log(title = "学生个人信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody RecruitStudent recruitStudent)
    {
        return toAjax(recruitStudentService.updateRecruitStudent(recruitStudent));
    }

    /**
     * 删除学生个人信息
     */
    @PreAuthorize("@ss.hasPermi('recruit:student:remove')")
    @Log(title = "学生个人信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(recruitStudentService.deleteRecruitStudentByIds(ids));
    }
}
