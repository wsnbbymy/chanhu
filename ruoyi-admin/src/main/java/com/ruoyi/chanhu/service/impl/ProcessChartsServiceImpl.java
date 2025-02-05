package com.ruoyi.chanhu.service.impl;

import com.ruoyi.chanhu.mapper.ProcessChartsMapper;
import com.ruoyi.chanhu.service.ProcessChartsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProcessChartsServiceImpl implements ProcessChartsService {

    @Resource
    ProcessChartsMapper processChartsMapper;

    @Override
    public Map entry(String user) {
        LocalDate today = LocalDate.now();
        String todayStr = today.toString();
        LocalDate yesterday = today.minusDays(1);
        String yesterdayStr = yesterday.toString();
        Integer todayInput = processChartsMapper.entry(user,todayStr+" 00:00:00",todayStr+" 23:59:59");
        Integer totalInput = processChartsMapper.entry(user,null,null);
        Integer yesterdayInput = processChartsMapper.entry(user,yesterdayStr+" 00:00:00",yesterdayStr+" 23:59:59");
        Map<String, Integer> result = new HashMap();
        result.put("todayInput",todayInput);
        result.put("totalInput",totalInput);
        result.put("yesterdayInput",yesterdayInput);
        return result;
    }

    @Override
    public List fillStatus(String user){
        return processChartsMapper.fillStatus(user);
    }

    @Override
    public List processStatus(String user) {
        return processChartsMapper.processStatus(user);
    }

    @Override
    public List countdown(String user) {
        return processChartsMapper.countdown(user);
    }
}


