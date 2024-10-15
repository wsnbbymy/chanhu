package com.ruoyi.chanhu.service;

import java.util.List;
import com.ruoyi.chanhu.domain.ProcessManagerInfo;

/**
 * 客户经理信息管理Service接口
 * 
 * @author mingyuan
 * @date 2024-10-15
 */
public interface IProcessManagerInfoService 
{
    /**
     * 查询客户经理信息管理
     * 
     * @param id 客户经理信息管理主键
     * @return 客户经理信息管理
     */
    public ProcessManagerInfo selectProcessManagerInfoById(Long id);

    /**
     * 查询客户经理信息管理列表
     * 
     * @param processManagerInfo 客户经理信息管理
     * @return 客户经理信息管理集合
     */
    public List<ProcessManagerInfo> selectProcessManagerInfoList(ProcessManagerInfo processManagerInfo);

    /**
     * 新增客户经理信息管理
     * 
     * @param processManagerInfo 客户经理信息管理
     * @return 结果
     */
    public int insertProcessManagerInfo(ProcessManagerInfo processManagerInfo);

    /**
     * 修改客户经理信息管理
     * 
     * @param processManagerInfo 客户经理信息管理
     * @return 结果
     */
    public int updateProcessManagerInfo(ProcessManagerInfo processManagerInfo);

    /**
     * 批量删除客户经理信息管理
     * 
     * @param ids 需要删除的客户经理信息管理主键集合
     * @return 结果
     */
    public int deleteProcessManagerInfoByIds(Long[] ids);

    /**
     * 删除客户经理信息管理信息
     * 
     * @param id 客户经理信息管理主键
     * @return 结果
     */
    public int deleteProcessManagerInfoById(Long id);
}
