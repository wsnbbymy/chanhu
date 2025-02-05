package com.ruoyi.chanhu.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface ProcessChartsMapper {

    public Integer entry(@Param("createBy") String uid,@Param("createStartTime") String createStartTime,@Param("createEndTime") String createEndTime);

    public List<Map<String,String>> fillStatus(@Param("createBy") String user);

    public List processStatus(@Param("createBy") String user);

    public List countdown(@Param("createBy") String user);
}
