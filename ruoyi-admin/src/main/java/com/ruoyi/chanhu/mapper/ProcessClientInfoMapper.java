package com.ruoyi.chanhu.mapper;

import java.util.List;
import com.ruoyi.chanhu.domain.ProcessClientInfo;

/**
 * 客户信息Mapper接口
 * 
 * @author mingyuan
 * @date 2024-10-15
 */
public interface ProcessClientInfoMapper 
{
    /**
     * 查询客户信息
     * 
     * @param id 客户信息主键
     * @return 客户信息
     */
    public ProcessClientInfo selectProcessClientInfoById(Long id);

    /**
     * 查询客户信息列表
     * 
     * @param processClientInfo 客户信息
     * @return 客户信息集合
     */
    public List<ProcessClientInfo> selectProcessClientInfoList(ProcessClientInfo processClientInfo);

    /**
     * 新增客户信息
     * 
     * @param processClientInfo 客户信息
     * @return 结果
     */
    public int insertProcessClientInfo(ProcessClientInfo processClientInfo);

    /**
     * 修改客户信息
     * 
     * @param processClientInfo 客户信息
     * @return 结果
     */
    public int updateProcessClientInfo(ProcessClientInfo processClientInfo);

    /**
     * 删除客户信息
     * 
     * @param id 客户信息主键
     * @return 结果
     */
    public int deleteProcessClientInfoById(Long id);

    /**
     * 批量删除客户信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteProcessClientInfoByIds(Long[] ids);
}
