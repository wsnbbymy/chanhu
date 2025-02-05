package com.ruoyi.chanhu.mapper;

import java.util.List;
import com.ruoyi.chanhu.domain.ProcessContracts;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 合同管理Mapper接口
 * 
 * @author mingyuan
 * @date 2024-10-16
 */
public interface ProcessContractsMapper
{
    /**
     * 查询合同管理
     *
     * @param id 合同管理主键
     * @return 合同管理
     */
    public ProcessContracts selectProcessContractsById(Long id);

    public ProcessContracts selectProcessContractsByIdAndUid(@Param("id") Long id, @Param("clientId") Long clientId);

    public ProcessContracts selectProcessContractsForRecord(@Param("unitId") Integer unitId,@Param("processId") Integer processId,@Param("departmentId") Integer departmentId);

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
     * 删除合同管理
     * 
     * @param id 合同管理主键
     * @return 结果
     */
    public int deleteProcessContractsById(Long id);

    /**
     * 批量删除合同管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteProcessContractsByIds(Long[] ids);

    public Long getContractType(Long id);
}
