package com.ruoyi.chanhu.service;

import java.util.List;
import com.ruoyi.chanhu.domain.ProcessContracts;
import com.ruoyi.common.core.domain.AjaxResult;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 合同管理Service接口
 * 
 * @author mingyuan
 * @date 2024-10-16
 */
public interface IProcessContractsService 
{
    /**
     * 查询合同管理
     * 
     * @param id 合同管理主键
     * @return 合同管理
     */
    public ProcessContracts selectProcessContractsById(Long id);

    public ProcessContracts selectProcessContractsByIdAndUid(Long id, Long clientId);
    /**
     * 查询合同管理列表
     * 
     * @param processContracts 合同管理
     * @return 合同管理集合
     */
    public List<ProcessContracts> selectProcessContractsList(ProcessContracts processContracts);

    /**
     * 新增合同管理
     * 
     * @param processContracts 合同管理
     * @return 结果
     */
    public int insertProcessContracts(ProcessContracts processContracts);

    /**
     * 修改合同管理
     * 
     * @param processContracts 合同管理
     * @return 结果
     */
    public int updateProcessContracts(ProcessContracts processContracts);

    /**
     * 批量删除合同管理
     * 
     * @param ids 需要删除的合同管理主键集合
     * @return 结果
     */
    public int deleteProcessContractsByIds(Long[] ids);

    /**
     * 删除合同管理信息
     * 
     * @param id 合同管理主键
     * @return 结果
     */
    public int deleteProcessContractsById(Long id);

    public void updateContractType();
}
