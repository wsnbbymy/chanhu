package com.ruoyi.chanhu.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.chanhu.mapper.ProcessClientDepartmentMapper;
import com.ruoyi.chanhu.domain.ProcessClientDepartment;
import com.ruoyi.chanhu.service.IProcessClientDepartmentService;

/**
 * 客户单位部门管理Service业务层处理
 * 
 * @author mingyuan
 * @date 2024-10-15
 */
@Service
public class ProcessClientDepartmentServiceImpl implements IProcessClientDepartmentService 
{
    @Autowired
    private ProcessClientDepartmentMapper processClientDepartmentMapper;

    /**
     * 查询客户单位部门管理
     * 
     * @param id 客户单位部门管理主键
     * @return 客户单位部门管理
     */
    @Override
    public ProcessClientDepartment selectProcessClientDepartmentById(Long id)
    {
        return processClientDepartmentMapper.selectProcessClientDepartmentById(id);
    }

    /**
     * 查询客户单位部门管理列表
     * 
     * @param processClientDepartment 客户单位部门管理
     * @return 客户单位部门管理
     */
    @Override
    public List<ProcessClientDepartment> selectProcessClientDepartmentList(ProcessClientDepartment processClientDepartment)
    {
        return processClientDepartmentMapper.selectProcessClientDepartmentList(processClientDepartment);
    }

    /**
     * 新增客户单位部门管理
     * 
     * @param processClientDepartment 客户单位部门管理
     * @return 结果
     */
    @Override
    public int insertProcessClientDepartment(ProcessClientDepartment processClientDepartment)
    {
        return processClientDepartmentMapper.insertProcessClientDepartment(processClientDepartment);
    }

    /**
     * 修改客户单位部门管理
     * 
     * @param processClientDepartment 客户单位部门管理
     * @return 结果
     */
    @Override
    public int updateProcessClientDepartment(ProcessClientDepartment processClientDepartment)
    {
        return processClientDepartmentMapper.updateProcessClientDepartment(processClientDepartment);
    }

    /**
     * 批量删除客户单位部门管理
     * 
     * @param ids 需要删除的客户单位部门管理主键
     * @return 结果
     */
    @Override
    public int deleteProcessClientDepartmentByIds(Long[] ids)
    {
        return processClientDepartmentMapper.deleteProcessClientDepartmentByIds(ids);
    }

    /**
     * 删除客户单位部门管理信息
     * 
     * @param id 客户单位部门管理主键
     * @return 结果
     */
    @Override
    public int deleteProcessClientDepartmentById(Long id)
    {
        return processClientDepartmentMapper.deleteProcessClientDepartmentById(id);
    }
}
