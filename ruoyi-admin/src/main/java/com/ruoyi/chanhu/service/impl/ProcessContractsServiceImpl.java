package com.ruoyi.chanhu.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.chanhu.mapper.ProcessContractsMapper;
import com.ruoyi.chanhu.domain.ProcessContracts;
import com.ruoyi.chanhu.service.IProcessContractsService;

/**
 * 合同管理Service业务层处理
 * 
 * @author mingyuan
 * @date 2024-10-16
 */
@Service
public class ProcessContractsServiceImpl implements IProcessContractsService 
{
    @Autowired
    private ProcessContractsMapper processContractsMapper;

    /**
     * 查询合同管理
     * 
     * @param id 合同管理主键
     * @return 合同管理
     */
    @Override
    public ProcessContracts selectProcessContractsById(Long id)
    {
        return processContractsMapper.selectProcessContractsById(id);
    }

    /**
     * 查询合同管理列表
     * 
     * @param processContracts 合同管理
     * @return 合同管理
     */
    @Override
    public List<ProcessContracts> selectProcessContractsList(ProcessContracts processContracts)
    {
        return processContractsMapper.selectProcessContractsList(processContracts);
    }

    /**
     * 新增合同管理
     * 
     * @param processContracts 合同管理
     * @return 结果
     */
    @Override
    public int insertProcessContracts(ProcessContracts processContracts)
    {
        return processContractsMapper.insertProcessContracts(processContracts);
    }

    /**
     * 修改合同管理
     * 
     * @param processContracts 合同管理
     * @return 结果
     */
    @Override
    public int updateProcessContracts(ProcessContracts processContracts)
    {
        return processContractsMapper.updateProcessContracts(processContracts);
    }

    /**
     * 批量删除合同管理
     * 
     * @param ids 需要删除的合同管理主键
     * @return 结果
     */
    @Override
    public int deleteProcessContractsByIds(Long[] ids)
    {
        return processContractsMapper.deleteProcessContractsByIds(ids);
    }

    /**
     * 删除合同管理信息
     * 
     * @param id 合同管理主键
     * @return 结果
     */
    @Override
    public int deleteProcessContractsById(Long id)
    {
        return processContractsMapper.deleteProcessContractsById(id);
    }
}
