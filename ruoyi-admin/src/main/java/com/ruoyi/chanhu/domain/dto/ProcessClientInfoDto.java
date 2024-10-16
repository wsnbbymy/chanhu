package com.ruoyi.chanhu.domain.dto;

import com.ruoyi.chanhu.domain.ProcessClientDepartment;
import com.ruoyi.chanhu.domain.ProcessClientInfo;
import lombok.Data;

import java.util.List;

@Data
public class ProcessClientInfoDto extends ProcessClientInfo {
    // 单位下属部门列表
    private List<ProcessClientDepartment> children;
}
