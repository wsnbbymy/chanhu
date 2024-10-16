package com.ruoyi.chanhu.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 合同管理对象 process_contracts
 * 
 * @author mingyuan
 * @date 2024-10-16
 */
public class ProcessContracts extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 合同类型/业务类型 */
    @Excel(name = "合同类型/业务类型")
    private Long contractType;

    /** 供应商类型：1-联通 2-移动 3-电信 4-广电 */
    @Excel(name = "供应商类型：1-联通 2-移动 3-电信 4-广电")
    private Long provider;

    /** 合同开始日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "合同开始日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startDate;

    /** 合同终止日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "合同终止日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endDate;

    /** 合同具体项目属性/参数，json格式 */
    @Excel(name = "合同具体项目属性/参数，json格式")
    private String detail;

    /** 备注 */
    @Excel(name = "备注")
    private String comments;

    /** 部门id */
    @Excel(name = "部门id")
    private Long departmentId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setContractType(Long contractType) 
    {
        this.contractType = contractType;
    }

    public Long getContractType() 
    {
        return contractType;
    }
    public void setProvider(Long provider) 
    {
        this.provider = provider;
    }

    public Long getProvider() 
    {
        return provider;
    }
    public void setStartDate(Date startDate) 
    {
        this.startDate = startDate;
    }

    public Date getStartDate() 
    {
        return startDate;
    }
    public void setEndDate(Date endDate) 
    {
        this.endDate = endDate;
    }

    public Date getEndDate() 
    {
        return endDate;
    }
    public void setDetail(String detail) 
    {
        this.detail = detail;
    }

    public String getDetail() 
    {
        return detail;
    }
    public void setComments(String comments) 
    {
        this.comments = comments;
    }

    public String getComments() 
    {
        return comments;
    }
    public void setDepartmentId(Long departmentId) 
    {
        this.departmentId = departmentId;
    }

    public Long getDepartmentId() 
    {
        return departmentId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("contractType", getContractType())
            .append("provider", getProvider())
            .append("startDate", getStartDate())
            .append("endDate", getEndDate())
            .append("detail", getDetail())
            .append("comments", getComments())
            .append("departmentId", getDepartmentId())
            .toString();
    }
}
