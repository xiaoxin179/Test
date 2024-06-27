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
import com.ruoyi.recruit.domain.RecruitClassroom;
import com.ruoyi.recruit.service.IRecruitClassroomService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 教室Controller
 * 
 * @author root
 * @date 2021-04-03
 */
@RestController
@RequestMapping("/recruit/classroom")
public class RecruitClassroomController extends BaseController
{
    @Autowired
    private IRecruitClassroomService recruitClassroomService;

    /**
     * 查询教室列表
     */
    @PreAuthorize("@ss.hasPermi('recruit:classroom:list')")
    @GetMapping("/list")
    public TableDataInfo list(RecruitClassroom recruitClassroom)
    {
        startPage();
        List<RecruitClassroom> list = recruitClassroomService.selectRecruitClassroomList(recruitClassroom);
        return getDataTable(list);
    }

    /**
     * 导出教室列表
     */
    @PreAuthorize("@ss.hasPermi('recruit:classroom:export')")
    @Log(title = "教室", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(RecruitClassroom recruitClassroom)
    {
        List<RecruitClassroom> list = recruitClassroomService.selectRecruitClassroomList(recruitClassroom);
        ExcelUtil<RecruitClassroom> util = new ExcelUtil<RecruitClassroom>(RecruitClassroom.class);
        return util.exportExcel(list, "classroom");
    }

    /**
     * 获取教室详细信息
     */
    @PreAuthorize("@ss.hasPermi('recruit:classroom:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(recruitClassroomService.selectRecruitClassroomById(id));
    }

    /**
     * 新增教室
     */
    @PreAuthorize("@ss.hasPermi('recruit:classroom:add')")
    @Log(title = "教室", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RecruitClassroom recruitClassroom)
    {
        return toAjax(recruitClassroomService.insertRecruitClassroom(recruitClassroom));
    }

    /**
     * 修改教室
     */
    @PreAuthorize("@ss.hasPermi('recruit:classroom:edit')")
    @Log(title = "教室", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody RecruitClassroom recruitClassroom)
    {
        return toAjax(recruitClassroomService.updateRecruitClassroom(recruitClassroom));
    }

    /**
     * 删除教室
     */
    @PreAuthorize("@ss.hasPermi('recruit:classroom:remove')")
    @Log(title = "教室", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(recruitClassroomService.deleteRecruitClassroomByIds(ids));
    }
}
