package com.ruoyi.chanhu.service;

import com.ruoyi.chanhu.domain.Operator;
import com.ruoyi.chanhu.domain.ProcessContractsConfig;

import java.util.List;


public interface ProcessExtraService {

    public List<Operator> getOperators(Integer id);


    public void createOperator(Operator operator);

    public void updateOperator(Operator operator);

    public void createProcessContractsConfig(ProcessContractsConfig config);

    public List<ProcessContractsConfig> getProcessConfigByid(Long id);

    public void delProcessConfigByid(Long id);
}
