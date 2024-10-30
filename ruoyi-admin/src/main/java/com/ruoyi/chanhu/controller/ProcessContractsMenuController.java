package com.ruoyi.chanhu.controller;

import com.ruoyi.chanhu.domain.ProcessContractsMenu;
import com.ruoyi.chanhu.service.IProcessContractsMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/chanhu/contracts")
public class ProcessContractsMenuController {
    @Autowired
    private IProcessContractsMenuService processContractsMenuService;

    @GetMapping("/menu")
    public List<ProcessContractsMenu> getMenuItems() {
        List<ProcessContractsMenu> allItems = processContractsMenuService.getAllMenuItems();
        List<ProcessContractsMenu> processContractsMenus = processContractsMenuService.buildTree(allItems);
        return processContractsMenus;
    }
}
