package com.ruoyi.chanhu.mapper;

import java.util.List;
import com.ruoyi.chanhu.domain.ProcessClientDepartment;

/**
 * 客户单位部门管理Mapper接口
 * 
 * @author mingyuan
 * @date 2024-10-15
 */
public interface ProcessClientDepartmentMapper 
{
    /**
     * 查询客户单位部门管理
     * 
     * @param id 客户单位部门管理主键
     * @return 客户单位部门管理
     */
    public ProcessClientDepartment selectProcessClientDepartmentById(Long id);

    /**
     * 查询客户单位部门管理列表
     * 
     * @param processClientDepartment 客户单位部门管理
     * @return 客户单位部门管理集合
     */
    public List<ProcessClientDepartment> selectProcessClientDepartmentList(ProcessClientDepartment processClientDepartment);

    /**
     * 新增客户单位部门管理
     * 
     * @param processClientDepartment 客户单位部门管理
     * @return 结果
     */
    public int insertProcessClientDepartment(ProcessClientDepartment processClientDepartment);

    /**
     * 修改客户单位部门管理
     * 
     * @param processClientDepartment 客户单位部门管理
     * @return 结果
     */
    public int updateProcessClientDepartment(ProcessClientDepartment processClientDepartment);

    /**
     * 删除客户单位部门管理
     * 
     * @param id 客户单位部门管理主键
     * @return 结果
     */
    public int deleteProcessClientDepartmentById(Long id);

    /**
     * 批量删除客户单位部门管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteProcessClientDepartmentByIds(Long[] ids);
}
