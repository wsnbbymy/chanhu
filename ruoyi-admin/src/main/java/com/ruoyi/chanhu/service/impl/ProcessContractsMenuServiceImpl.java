package com.ruoyi.chanhu.service.impl;

import com.ruoyi.chanhu.domain.ProcessContractsMenu;
import com.ruoyi.chanhu.mapper.ProcessContractsMenuMapper;
import com.ruoyi.chanhu.service.IProcessContractsMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProcessContractsMenuServiceImpl implements IProcessContractsMenuService {
    @Autowired
    private ProcessContractsMenuMapper processContractsMenuMapper;

    /**
     * 查询所有菜单项列表
     * @return
     */
    @Override
    public List<ProcessContractsMenu> getAllMenuItems() {
        return processContractsMenuMapper.getAllMenuItems();
    }

    @Override
    public List<ProcessContractsMenu> buildTree(List<ProcessContractsMenu> allItems) {
        return allItems.stream()
                .filter(item -> item.getParentId() == null)
                .peek(item -> item.setChildren(getChildren(item, allItems)))
                .collect(Collectors.toList());
    }

    private List<ProcessContractsMenu> getChildren(ProcessContractsMenu item, List<ProcessContractsMenu> allItems) {
        return allItems.stream()
                .filter(child -> child.getParentId() != null && child.getParentId().equals(item.getId()))
                .peek(child -> child.setChildren(getChildren(child, allItems)))
                .collect(Collectors.toList());
    }
}
