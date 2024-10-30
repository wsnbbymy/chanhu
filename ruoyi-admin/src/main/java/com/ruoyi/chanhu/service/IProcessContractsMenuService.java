package com.ruoyi.chanhu.service;

import com.ruoyi.chanhu.domain.ProcessContractsMenu;

import java.util.List;

public interface IProcessContractsMenuService {
    List<ProcessContractsMenu> buildTree(List<ProcessContractsMenu> allItems);

    List<ProcessContractsMenu> getAllMenuItems();
}
