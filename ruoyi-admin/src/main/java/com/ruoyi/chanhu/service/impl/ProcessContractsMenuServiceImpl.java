package com.ruoyi.chanhu.service.impl;

import com.ruoyi.chanhu.domain.ProcessContracts;
import com.ruoyi.chanhu.domain.ProcessContractsMenu;
import com.ruoyi.chanhu.mapper.ProcessContractsMapper;
import com.ruoyi.chanhu.mapper.ProcessContractsMenuMapper;
import com.ruoyi.chanhu.service.IProcessContractsMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProcessContractsMenuServiceImpl implements IProcessContractsMenuService {
    @Autowired
    private ProcessContractsMenuMapper processContractsMenuMapper;

    @Resource
    private ProcessContractsMapper processContractsMapper;

    /**
     * 查询所有菜单项列表
     * @return
     */
    @Override
    public List<ProcessContractsMenu> getAllMenuItems() {
        return processContractsMenuMapper.getAllMenuItems();
    }

    @Override
    public List<ProcessContractsMenu> buildTree(Integer unitId,List<ProcessContractsMenu> allItems) {
        List<ProcessContractsMenu> parents = allItems.stream()
                .filter(item -> item.getParentId() == null)
                .peek(item -> item.setChildren(getChildren(unitId,item, allItems)))
                .collect(Collectors.toList());

        for (ProcessContractsMenu child : parents){
            int count = child.getChildren().stream().mapToInt(ProcessContractsMenu::getFillFlag).sum();
            if (count == child.getChildren().size()*2){
                child.setFillFlag(2);
            }
            if (count > 0 && count <= child.getChildren().size()){
                child.setFillFlag(1);
            }
            if (count == 0){
                child.setFillFlag(0);
            }
        }


        return parents;
    }

    private List<ProcessContractsMenu> getChildren(Integer unitId,ProcessContractsMenu item, List<ProcessContractsMenu> allItems) {

        List<ProcessContractsMenu> parents = allItems.stream()
                .filter(child -> child.getParentId() != null && child.getParentId().equals(item.getId())).collect(Collectors.toList());

        for(ProcessContractsMenu child : parents){
            List<ProcessContractsMenu> resList = getChildren(unitId,child, allItems);
            if(resList.size() > 0){
                int fillInCount = 0;
                for(ProcessContractsMenu node: resList){
                    node.setIsRoot(true);
                    ProcessContracts processContracts = processContractsMapper.selectProcessContractsForRecord(unitId,node.getId(),null);
                    if (processContracts == null) {

                    } else {
                        node.setProcessContracts(processContracts);
                        fillInCount++;
                    }
                }
                if (fillInCount == resList.size()){
                    child.setFillFlag(2);
                }
                if (fillInCount > 0 && fillInCount < resList.size()){
                    child.setFillFlag(1);
                }
                if (fillInCount == 0){
                    child.setFillFlag(0);
                }
            }else{
                child.setFillFlag(0);
            }
            child.setChildren(resList);
        }

        return parents;
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
