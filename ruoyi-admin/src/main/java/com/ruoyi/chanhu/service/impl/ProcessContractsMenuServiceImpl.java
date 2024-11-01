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


    /**
     * 查询合同菜单
     *
     * @param id 合同菜单主键
     * @return 合同菜单
     */
    @Override
    public ProcessContractsMenu selectProcessContractsMenuById(Long id)
    {
        return processContractsMenuMapper.selectProcessContractsMenuById(id);
    }

    /**
     * 查询合同菜单列表
     *
     * @param processContractsMenu 合同菜单
     * @return 合同菜单
     */
    @Override
    public List<ProcessContractsMenu> selectProcessContractsMenuList(ProcessContractsMenu processContractsMenu)
    {
        return processContractsMenuMapper.selectProcessContractsMenuList(processContractsMenu);
    }

    /**
     * 新增合同菜单
     *
     * @param processContractsMenu 合同菜单
     * @return 结果
     */
    @Override
    public int insertProcessContractsMenu(ProcessContractsMenu processContractsMenu)
    {
        return processContractsMenuMapper.insertProcessContractsMenu(processContractsMenu);
    }

    /**
     * 修改合同菜单
     *
     * @param processContractsMenu 合同菜单
     * @return 结果
     */
    @Override
    public int updateProcessContractsMenu(ProcessContractsMenu processContractsMenu)
    {
        return processContractsMenuMapper.updateProcessContractsMenu(processContractsMenu);
    }

    /**
     * 批量删除合同菜单
     *
     * @param ids 需要删除的合同菜单主键
     * @return 结果
     */
    @Override
    public int deleteProcessContractsMenuByIds(Long[] ids)
    {
        return processContractsMenuMapper.deleteProcessContractsMenuByIds(ids);
    }

    /**
     * 删除合同菜单信息
     *
     * @param id 合同菜单主键
     * @return 结果
     */
    @Override
    public int deleteProcessContractsMenuById(Long id)
    {
        return processContractsMenuMapper.deleteProcessContractsMenuById(id);
    }
}
