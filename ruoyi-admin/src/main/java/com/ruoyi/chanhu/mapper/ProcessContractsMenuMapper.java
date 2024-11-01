package com.ruoyi.chanhu.mapper;

import com.ruoyi.chanhu.domain.ProcessContractsMenu;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 合同界面目录Mapper接口
 */
public interface ProcessContractsMenuMapper {

    List<ProcessContractsMenu> getAllMenuItems();

    List<ProcessContractsMenu> getMenuItemsByParentId(@Param("parentId") Integer parentId);

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
     * 删除合同菜单
     *
     * @param id 合同菜单主键
     * @return 结果
     */
    public int deleteProcessContractsMenuById(Long id);

    /**
     * 批量删除合同菜单
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteProcessContractsMenuByIds(Long[] ids);
}
