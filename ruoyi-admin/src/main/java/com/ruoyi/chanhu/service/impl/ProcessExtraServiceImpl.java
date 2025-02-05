package com.ruoyi.chanhu.service.impl;

import com.ruoyi.chanhu.domain.Operator;
import com.ruoyi.chanhu.domain.ProcessContractsConfig;
import com.ruoyi.chanhu.mapper.ProcessClientInfoMapper;
import com.ruoyi.chanhu.service.ProcessExtraService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProcessExtraServiceImpl implements ProcessExtraService {

    @Resource
    ProcessClientInfoMapper processClientInfoMapper;

    @Override
    public List<Operator> getOperators(Integer id) {
        if(id == -1) return processClientInfoMapper.getOperators();
        return processClientInfoMapper.getOperatorsById(id);
    }

    @Override
    public void createOperator(Operator operator) {
        processClientInfoMapper.createOperator(operator);
    }

    @Override
    public void updateOperator(Operator operator) {
        processClientInfoMapper.updateOperator(operator);
    }

    @Override
    public void createProcessContractsConfig(ProcessContractsConfig config) {
        processClientInfoMapper.createProcessContractsConfig(config);
    }

    @Override
    public List<ProcessContractsConfig> getProcessConfigByid(Long id) {
        return processClientInfoMapper.getProcessConfigByid(id);
    }

    @Override
    public void delProcessConfigByid(Long id) {
        processClientInfoMapper.delProcessConfigByid(id);
    }
}
