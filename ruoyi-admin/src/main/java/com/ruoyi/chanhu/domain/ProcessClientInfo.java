package com.ruoyi.chanhu.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 客户信息对象 process_client_info
 * 
 * @author mingyuan
 * @date 2024-10-15
 */
public class ProcessClientInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 客户单位 */
    @Excel(name = "客户单位")
    private String clientName;

    /** 员工人数 */
    @Excel(name = "员工人数")
    private Long employerNum;

    /** 行业 */
    @Excel(name = "行业")
    private String industry;

    /** 备注 */
    @Excel(name = "备注")
    private String comments;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setClientName(String clientName) 
    {
        this.clientName = clientName;
    }

    public String getClientName() 
    {
        return clientName;
    }
    public void setEmployerNum(Long employerNum) 
    {
        this.employerNum = employerNum;
    }

    public Long getEmployerNum() 
    {
        return employerNum;
    }
    public void setIndustry(String industry) 
    {
        this.industry = industry;
    }

    public String getIndustry() 
    {
        return industry;
    }
    public void setComments(String comments) 
    {
        this.comments = comments;
    }

    public String getComments() 
    {
        return comments;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("clientName", getClientName())
            .append("employerNum", getEmployerNum())
            .append("industry", getIndustry())
            .append("comments", getComments())
            .toString();
    }
}
