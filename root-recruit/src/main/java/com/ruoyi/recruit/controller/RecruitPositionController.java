package com.ruoyi.recruit.controller;

import java.util.List;

import com.alibaba.fastjson.JSON;
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
import com.ruoyi.recruit.domain.RecruitPosition;
import com.ruoyi.recruit.service.IRecruitPositionService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 招聘岗位Controller
 *
 * @author ruoyi
 * @date 2021-03-25
 */
@RestController
@RequestMapping("/recruit/position")
public class RecruitPositionController extends BaseController
{
    @Autowired
    private IRecruitPositionService recruitPositionService;

    /**
     * 查询招聘岗位列表
     */
    @GetMapping("/list")
    public TableDataInfo list(RecruitPosition recruitPosition)
    {
        startPage();
        List<RecruitPosition> list = recruitPositionService.selectRecruitPositionList(recruitPosition);
        return getDataTable(list);
    }

    /**
     * 导出招聘岗位列表
     */
    @PreAuthorize("@ss.hasPermi('recruit:position:export')")
    @Log(title = "招聘岗位", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(RecruitPosition recruitPosition)
    {
        List<RecruitPosition> list = recruitPositionService.selectRecruitPositionList(recruitPosition);
        ExcelUtil<RecruitPosition> util = new ExcelUtil<RecruitPosition>(RecruitPosition.class);
        return util.exportExcel(list, "position");
    }

    /**
     * 获取招聘岗位详细信息
     */
    @PreAuthorize("@ss.hasPermi('recruit:position:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(recruitPositionService.selectRecruitPositionById(id));
    }

    /**
     * 新增招聘岗位
     */
    @PreAuthorize("@ss.hasPermi('recruit:position:add')")
    @Log(title = "招聘岗位", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RecruitPosition recruitPosition)
    {
        return toAjax(recruitPositionService.insertRecruitPosition(recruitPosition));
    }

    /**
     * 修改招聘岗位
     */
    @PreAuthorize("@ss.hasPermi('recruit:position:edit')")
    @Log(title = "招聘岗位", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody RecruitPosition recruitPosition)
    {
        return toAjax(recruitPositionService.updateRecruitPosition(recruitPosition));
    }

    /**
     * 删除招聘岗位
     */
    @PreAuthorize("@ss.hasPermi('recruit:position:remove')")
    @Log(title = "招聘岗位", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(recruitPositionService.deleteRecruitPositionByIds(ids));
    }
}
