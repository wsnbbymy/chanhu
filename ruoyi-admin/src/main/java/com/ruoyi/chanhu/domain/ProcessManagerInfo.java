package com.ruoyi.chanhu.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 客户经理信息管理对象 process_manager_info
 * 
 * @author mingyuan
 * @date 2024-10-15
 */
public class ProcessManagerInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 客户经理名称 */
    @Excel(name = "客户经理名称")
    private String name;

    /** 电话号码 */
    @Excel(name = "电话号码")
    private String mobile;

    /** 绑定账号id */
    @Excel(name = "绑定账号id")
    private Long userId;

    /** 所属单元名称 */
    @Excel(name = "所属单元名称")
    private String unitName;

    /** 所属区域
 */
    @Excel(name = "所属区域 ")
    private String areaName;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setMobile(String mobile) 
    {
        this.mobile = mobile;
    }

    public String getMobile() 
    {
        return mobile;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setUnitName(String unitName) 
    {
        this.unitName = unitName;
    }

    public String getUnitName() 
    {
        return unitName;
    }
    public void setAreaName(String areaName) 
    {
        this.areaName = areaName;
    }

    public String getAreaName() 
    {
        return areaName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("mobile", getMobile())
            .append("userId", getUserId())
            .append("unitName", getUnitName())
            .append("areaName", getAreaName())
            .toString();
    }
}
