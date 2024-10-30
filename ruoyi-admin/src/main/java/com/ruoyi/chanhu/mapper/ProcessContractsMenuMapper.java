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
}
