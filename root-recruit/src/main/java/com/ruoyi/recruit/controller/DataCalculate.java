package com.ruoyi.recruit.controller;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.recruit.domain.bo.CompanySumHC;
import com.ruoyi.recruit.service.DataCalculateService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@ResponseBody
@RequestMapping("/data")
public class DataCalculate extends BaseController {
    @Resource
    private DataCalculateService dataCalculateService;
    @GetMapping("/sumHC")
    public AjaxResult getSumHC() {
        List<CompanySumHC> list = dataCalculateService.getCompanySum();
        return AjaxResult.success(list);
    }

    @GetMapping("/top6")
    public AjaxResult getTop6() {
        List<CompanySumHC> list = dataCalculateService.getTop6();
        return AjaxResult.success(list);
    }


}
