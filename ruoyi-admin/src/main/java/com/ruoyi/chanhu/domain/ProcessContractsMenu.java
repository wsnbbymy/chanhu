package com.ruoyi.chanhu.domain;

import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;

import java.util.List;

@Data
public class ProcessContractsMenu extends BaseEntity {
    private Integer id;
    private String label;
    private Integer parentId;
    private String menuIndex;
    private List<ProcessContractsMenu> children;
}