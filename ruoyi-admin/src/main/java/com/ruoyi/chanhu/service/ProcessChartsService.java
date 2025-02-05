package com.ruoyi.chanhu.service;

import java.util.List;
import java.util.Map;


public interface ProcessChartsService {

    public Map entry(String user);


    public List fillStatus(String user);

    public List processStatus(String user);

    public List countdown(String user);
}
