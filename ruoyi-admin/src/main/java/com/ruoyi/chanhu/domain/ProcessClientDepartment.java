package com.ruoyi.chanhu.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 客户单位部门管理对象 process_client_department
 * 
 * @author mingyuan
 * @date 2024-10-15
 */
public class ProcessClientDepartment extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 部门名称 */
    @Excel(name = "部门名称")
    private String departmentName;

    /** 客户单位id */
    @Excel(name = "客户单位id")
    private Long clientUnitId;

    /** 部门联系人姓名 */
    @Excel(name = "部门联系人姓名")
    private String contactsName;

    /** 联系人电话 */
    @Excel(name = "联系人电话")
    private String contactsMobile;

    /** 联系人职务 */
    @Excel(name = "联系人职务")
    private String duties;

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
    public void setDepartmentName(String departmentName) 
    {
        this.departmentName = departmentName;
    }

    public String getDepartmentName() 
    {
        return departmentName;
    }
    public void setClientUnitId(Long clientUnitId) 
    {
        this.clientUnitId = clientUnitId;
    }

    public Long getClientUnitId() 
    {
        return clientUnitId;
    }
    public void setContactsName(String contactsName) 
    {
        this.contactsName = contactsName;
    }

    public String getContactsName() 
    {
        return contactsName;
    }
    public void setContactsMobile(String contactsMobile) 
    {
        this.contactsMobile = contactsMobile;
    }

    public String getContactsMobile() 
    {
        return contactsMobile;
    }
    public void setDuties(String duties) 
    {
        this.duties = duties;
    }

    public String getDuties() 
    {
        return duties;
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
            .append("departmentName", getDepartmentName())
            .append("clientUnitId", getClientUnitId())
            .append("contactsName", getContactsName())
            .append("contactsMobile", getContactsMobile())
            .append("duties", getDuties())
            .append("comments", getComments())
            .toString();
    }
}
