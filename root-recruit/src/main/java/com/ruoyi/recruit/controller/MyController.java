package com.ruoyi.recruit.controller;

import com.alibaba.fastjson.JSON;
import com.ruoyi.common.annotation.AnonymousAccess;
import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.recruit.domain.CompanyRegisterInfo;
import com.ruoyi.recruit.domain.RecruitCompanyInfo;
import com.ruoyi.recruit.service.IRecruitCompanyInfoService;
import com.ruoyi.system.service.ISysUserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.condition.PatternsRequestCondition;
import org.springframework.web.servlet.mvc.condition.RequestMethodsRequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author xyh
 * @date 2021/2/20 10:26
 */
@RestController
public class MyController {
    @Resource
    private RequestMappingHandlerMapping handlerMapping;

    @Resource
    private ISysUserService userService;

    @Resource
    private IRecruitCompanyInfoService companyInfoService;

    @PostMapping("/c")
    @AnonymousAccess
    public String c(@RequestBody CompanyRegisterInfo companyRegisterInfo) {
        SysUser user = companyRegisterInfo.getUser();
        RecruitCompanyInfo companyInfo = companyRegisterInfo.getCompanyInfo();
        user.setUserType(UserConstants.COMPANY_USER);
        user.setPostIds(new Long[]{1L});
        user.setRoleIds(new Long[]{1L});
        user.setPassword(SecurityUtils.encryptPassword(user.getPassword()));
        System.out.println(JSON.toJSONString(companyRegisterInfo));
        return "1";
    }
    @PostMapping("/m")
    @AnonymousAccess
    public String m(@RequestBody Map<String, Object> map) {
        return JSON.toJSONString(map);
    }

    @RequestMapping("/list/urls")
    @AnonymousAccess
    public List<RequestToMethodItem> listUrls() {
        Map<RequestMappingInfo, HandlerMethod> handlerMethodMap = handlerMapping.getHandlerMethods();
        Iterator<Map.Entry<RequestMappingInfo, HandlerMethod>> iterator = handlerMethodMap.entrySet().iterator();
        List<RequestToMethodItem> urls = new ArrayList<>();
        while (iterator.hasNext()) {
            Map.Entry<RequestMappingInfo, HandlerMethod> entry = iterator.next();
            RequestMappingInfo requestMappingInfo = entry.getKey();
            HandlerMethod mappingInfoValue = entry.getValue();
            String controllerName = mappingInfoValue.getBeanType().toString();
            String requestMethodName = mappingInfoValue.getMethod().getName();
            Class<?>[] methodParamTypes = mappingInfoValue.getMethod().getParameterTypes();
            RequestMethodsRequestCondition methodCondition = requestMappingInfo.getMethodsCondition();
            Iterator<RequestMethod> it = methodCondition.getMethods().iterator();
            String requestType = it.hasNext() ? it.next().name() : "";
            PatternsRequestCondition patternsCondition = requestMappingInfo.getPatternsCondition();
            Set<String> requestUrlSet = patternsCondition.getPatterns();
            RequestToMethodItem item = new RequestToMethodItem(controllerName, requestMethodName, requestType, requestUrlSet, methodParamTypes);
            urls.add(item);
        }
        return urls;
    }
}
@AllArgsConstructor
class RequestToMethodItem {
    public String controllerName;
    public String methodName;
    public String requestType;
    public Set<String> requestUrlSet;
    public Class<?>[] methodParmaTypes;
}
