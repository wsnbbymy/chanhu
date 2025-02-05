package com.ruoyi.chanhu.controller;

import com.ruoyi.chanhu.domain.ProcessContracts;
import com.ruoyi.chanhu.service.ProcessChartsService;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.SecurityUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/chanhu/charts")
public class ProcessChartsController {

    @Resource
    ProcessChartsService processChartsService;

    @GetMapping("/entry")
    public Map list(ProcessContracts processContracts)
    {
        String currentUser = SecurityUtils.getLoginUser().getUserId().toString();
        return processChartsService.entry(currentUser);
    }

    @GetMapping("/fillStatus")
    public List fillStatus(ProcessContracts processContracts)
    {
        String currentUser = SecurityUtils.getLoginUser().getUserId().toString();
        return processChartsService.fillStatus(currentUser);
    }

    @GetMapping("/processStatus")
    public List processStatus(ProcessContracts processContracts)
    {
        String currentUser = SecurityUtils.getLoginUser().getUserId().toString();
        return processChartsService.processStatus(currentUser);
    }

    @GetMapping("/countdown")
    public AjaxResult countdown(ProcessContracts processContracts)
    {
        String currentUser = SecurityUtils.getLoginUser().getUserId().toString();
        return new AjaxResult(200,"success!",processChartsService.countdown(currentUser));
    }
}
