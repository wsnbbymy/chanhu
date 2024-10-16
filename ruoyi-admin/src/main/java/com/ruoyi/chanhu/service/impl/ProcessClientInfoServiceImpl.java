package com.ruoyi.chanhu.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ruoyi.chanhu.domain.ProcessClientDepartment;
import com.ruoyi.chanhu.domain.dto.ProcessClientInfoDto;
import com.ruoyi.chanhu.service.IProcessClientDepartmentService;
import com.ruoyi.common.utils.bean.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.chanhu.mapper.ProcessClientInfoMapper;
import com.ruoyi.chanhu.domain.ProcessClientInfo;
import com.ruoyi.chanhu.service.IProcessClientInfoService;

/**
 * 客户信息Service业务层处理
 * 
 * @author mingyuan
 * @date 2024-10-15
 */
@Service
public class ProcessClientInfoServiceImpl implements IProcessClientInfoService 
{
    @Autowired
    private ProcessClientInfoMapper processClientInfoMapper;

    @Autowired
    private IProcessClientDepartmentService processClientDepartmentService;

    /**
     * 查询客户信息
     * 
     * @param id 客户信息主键
     * @return 客户信息
     */
    @Override
    public ProcessClientInfo selectProcessClientInfoById(Long id)
    {
        return processClientInfoMapper.selectProcessClientInfoById(id);
    }

    /**
     * 查询客户信息列表
     * 
     * @param processClientInfo 客户信息
     * @return 客户信息
     */
    @Override
    public List<ProcessClientInfo> selectProcessClientInfoList(ProcessClientInfo processClientInfo)
    {
        return processClientInfoMapper.selectProcessClientInfoList(processClientInfo);
    }

    /**
     * 新增客户信息
     * 
     * @param processClientInfo 客户信息
     * @return 结果
     */
    @Override
    public int insertProcessClientInfo(ProcessClientInfo processClientInfo)
    {
        return processClientInfoMapper.insertProcessClientInfo(processClientInfo);
    }

    /**
     * 修改客户信息
     * 
     * @param processClientInfo 客户信息
     * @return 结果
     */
    @Override
    public int updateProcessClientInfo(ProcessClientInfo processClientInfo)
    {
        return processClientInfoMapper.updateProcessClientInfo(processClientInfo);
    }

    /**
     * 批量删除客户信息
     * 
     * @param ids 需要删除的客户信息主键
     * @return 结果
     */
    @Override
    public int deleteProcessClientInfoByIds(Long[] ids)
    {
        return processClientInfoMapper.deleteProcessClientInfoByIds(ids);
    }

    /**
     * 删除客户信息信息
     * 
     * @param id 客户信息主键
     * @return 结果
     */
    @Override
    public int deleteProcessClientInfoById(Long id)
    {
        return processClientInfoMapper.deleteProcessClientInfoById(id);
    }

    /**
     * 查询客户单位信息，带部门信息
     * @param processClientInfo
     * @return
     */
    @Override
    public List<ProcessClientInfoDto> selectProcessClientInfoListAndDepartments(ProcessClientInfo processClientInfo) {
        List<ProcessClientInfo> processClientInfos = processClientInfoMapper.selectProcessClientInfoList(processClientInfo);
        List<ProcessClientInfoDto> dtos = new ArrayList<>();
        for (ProcessClientInfo info : processClientInfos) {
            ProcessClientInfoDto dto = new ProcessClientInfoDto();
            Long id = info.getId();
            ProcessClientDepartment department = new ProcessClientDepartment();
            department.setClientUnitId(id);
            List<ProcessClientDepartment> result = processClientDepartmentService.selectProcessClientDepartmentList(department);
            BeanUtils.copyBeanProp(dto,info);
            dto.setChildren(result);
            dtos.add(dto);
        }
        return dtos;
    }


}
