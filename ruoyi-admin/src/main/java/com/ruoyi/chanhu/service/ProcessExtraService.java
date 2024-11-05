package com.ruoyi.chanhu.service;

import com.ruoyi.chanhu.domain.Operator;

import java.util.List;


public interface ProcessExtraService {

    public List<Operator> getOperators(Integer id);


    public void createOperator(Operator operator);

    public void updateOperator(Operator operator);
}
