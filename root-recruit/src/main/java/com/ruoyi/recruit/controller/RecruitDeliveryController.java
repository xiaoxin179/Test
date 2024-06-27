package com.ruoyi.recruit.controller;

import java.util.List;

import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.SecurityUtils;
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
import com.ruoyi.recruit.domain.RecruitDelivery;
import com.ruoyi.recruit.service.IRecruitDeliveryService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 简历投递信息Controller
 *
 * @author ruoyi
 * @date 2021-04-03
 */
@RestController
@RequestMapping("/recruit/delivery")
public class RecruitDeliveryController extends BaseController {
    @Autowired
    private IRecruitDeliveryService recruitDeliveryService;

    /**
     * 查询简历投递信息列表
     */
    @PreAuthorize("@ss.hasPermi('recruit:delivery:list')")
    @GetMapping("/list")
    public TableDataInfo list(RecruitDelivery recruitDelivery) {
        startPage();
        List<RecruitDelivery> list = recruitDeliveryService.selectRecruitDeliveryList(recruitDelivery);
        return getDataTable(list);
    }

    /**
     * 导出简历投递信息列表
     */
    @PreAuthorize("@ss.hasPermi('recruit:delivery:export')")
    @Log(title = "简历投递信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(RecruitDelivery recruitDelivery) {
        List<RecruitDelivery> list = recruitDeliveryService.selectRecruitDeliveryList(recruitDelivery);
        ExcelUtil<RecruitDelivery> util = new ExcelUtil<RecruitDelivery>(RecruitDelivery.class);
        return util.exportExcel(list, "delivery");
    }

    /**
     * 获取简历投递信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('recruit:delivery:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(recruitDeliveryService.selectRecruitDeliveryById(id));
    }

    /**
     * 新增简历投递信息
     */
//    @PreAuthorize("@ss.hasPermi('recruit:delivery:add')")
    @Log(title = "简历投递信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RecruitDelivery recruitDelivery) {
        LoginUser currentUser = SecurityUtils.getLoginUser();
        recruitDelivery.setUserId(currentUser.getUser().getUserId());
        recruitDelivery.setUserName(currentUser.getUsername());
        return toAjax(recruitDeliveryService.insertRecruitDelivery(recruitDelivery));
    }

    /**
     * 修改简历投递信息
     */
    @PreAuthorize("@ss.hasPermi('recruit:delivery:edit')")
    @Log(title = "简历投递信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody RecruitDelivery recruitDelivery) {
        return toAjax(recruitDeliveryService.updateRecruitDelivery(recruitDelivery));
    }

    /**
     * 删除简历投递信息
     */
    @PreAuthorize("@ss.hasPermi('recruit:delivery:remove')")
    @Log(title = "简历投递信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(recruitDeliveryService.deleteRecruitDeliveryByIds(ids));
    }
}
