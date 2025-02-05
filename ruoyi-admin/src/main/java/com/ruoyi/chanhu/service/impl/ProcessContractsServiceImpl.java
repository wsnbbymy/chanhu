package com.ruoyi.chanhu.service.impl;

import java.util.List;

import com.ruoyi.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.chanhu.mapper.ProcessContractsMapper;
import com.ruoyi.chanhu.domain.ProcessContracts;
import com.ruoyi.chanhu.service.IProcessContractsService;

import javax.annotation.Resource;

/**
 * 合同管理Service业务层处理
 * 
 * @author mingyuan
 * @date 2024-10-16
 */
@Service
public class ProcessContractsServiceImpl implements IProcessContractsService 
{
    @Resource
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

    public ProcessContracts selectProcessContractsByIdAndUid(Long id,Long clientId)
    {
        return processContractsMapper.selectProcessContractsByIdAndUid(id,clientId);
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
        processContracts.setCreateBy(SecurityUtils.getLoginUser().getUserId().toString());
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
        processContracts.setDraft(Boolean.TRUE);
        processContracts.setCreateBy(SecurityUtils.getLoginUser().getUserId().toString());
        processContracts.setContractType(processContractsMapper.getContractType(processContracts.getProcessId()));
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
        processContracts.setContractType(processContractsMapper.getContractType(processContracts.getProcessId()));
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

    @Override
    public void updateContractType() {
        List<ProcessContracts> processContracts = processContractsMapper.selectProcessContractsList(new ProcessContracts());
        for(ProcessContracts item : processContracts){
            this.updateProcessContracts(item);
        }
    }
}
