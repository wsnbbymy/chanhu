package com.ruoyi.chanhu.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.chanhu.mapper.ProcessManagerInfoMapper;
import com.ruoyi.chanhu.domain.ProcessManagerInfo;
import com.ruoyi.chanhu.service.IProcessManagerInfoService;

/**
 * 客户经理信息管理Service业务层处理
 * 
 * @author mingyuan
 * @date 2024-10-15
 */
@Service
public class ProcessManagerInfoServiceImpl implements IProcessManagerInfoService 
{
    @Autowired
    private ProcessManagerInfoMapper processManagerInfoMapper;

    /**
     * 查询客户经理信息管理
     * 
     * @param id 客户经理信息管理主键
     * @return 客户经理信息管理
     */
    @Override
    public ProcessManagerInfo selectProcessManagerInfoById(Long id)
    {
        return processManagerInfoMapper.selectProcessManagerInfoById(id);
    }

    /**
     * 查询客户经理信息管理列表
     * 
     * @param processManagerInfo 客户经理信息管理
     * @return 客户经理信息管理
     */
    @Override
    public List<ProcessManagerInfo> selectProcessManagerInfoList(ProcessManagerInfo processManagerInfo)
    {
        return processManagerInfoMapper.selectProcessManagerInfoList(processManagerInfo);
    }

    /**
     * 新增客户经理信息管理
     * 
     * @param processManagerInfo 客户经理信息管理
     * @return 结果
     */
    @Override
    public int insertProcessManagerInfo(ProcessManagerInfo processManagerInfo)
    {
        return processManagerInfoMapper.insertProcessManagerInfo(processManagerInfo);
    }

    /**
     * 修改客户经理信息管理
     * 
     * @param processManagerInfo 客户经理信息管理
     * @return 结果
     */
    @Override
    public int updateProcessManagerInfo(ProcessManagerInfo processManagerInfo)
    {
        return processManagerInfoMapper.updateProcessManagerInfo(processManagerInfo);
    }

    /**
     * 批量删除客户经理信息管理
     * 
     * @param ids 需要删除的客户经理信息管理主键
     * @return 结果
     */
    @Override
    public int deleteProcessManagerInfoByIds(Long[] ids)
    {
        return processManagerInfoMapper.deleteProcessManagerInfoByIds(ids);
    }

    /**
     * 删除客户经理信息管理信息
     * 
     * @param id 客户经理信息管理主键
     * @return 结果
     */
    @Override
    public int deleteProcessManagerInfoById(Long id)
    {
        return processManagerInfoMapper.deleteProcessManagerInfoById(id);
    }
}
