package com.ruoyi.chanhu.service;

import com.ruoyi.chanhu.domain.ProcessContractsMenu;

import java.util.List;

public interface IProcessContractsMenuService {
    List<ProcessContractsMenu> buildTree(Integer unitId,List<ProcessContractsMenu> allItems);

    List<ProcessContractsMenu> getAllMenuItems();

    /**
     * 查询合同菜单
     *
     * @param id 合同菜单主键
     * @return 合同菜单
     */
    public ProcessContractsMenu selectProcessContractsMenuById(Long id);

    /**
     * 查询合同菜单列表
     *
     * @param processContractsMenu 合同菜单
     * @return 合同菜单集合
     */
    public List<ProcessContractsMenu> selectProcessContractsMenuList(ProcessContractsMenu processContractsMenu);

    /**
     * 新增合同菜单
     *
     * @param processContractsMenu 合同菜单
     * @return 结果
     */
    public int insertProcessContractsMenu(ProcessContractsMenu processContractsMenu);

    /**
     * 修改合同菜单
     *
     * @param processContractsMenu 合同菜单
     * @return 结果
     */
    public int updateProcessContractsMenu(ProcessContractsMenu processContractsMenu);

    /**
     * 批量删除合同菜单
     *
     * @param ids 需要删除的合同菜单主键集合
     * @return 结果
     */
    public int deleteProcessContractsMenuByIds(Long[] ids);

    /**
     * 删除合同菜单信息
     *
     * @param id 合同菜单主键
     * @return 结果
     */
    public int deleteProcessContractsMenuById(Long id);
}
