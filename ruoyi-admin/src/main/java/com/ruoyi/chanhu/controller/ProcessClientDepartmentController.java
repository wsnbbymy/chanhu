package com.ruoyi.chanhu.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.chanhu.domain.ProcessClientDepartment;
import com.ruoyi.chanhu.service.IProcessClientDepartmentService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 客户单位部门管理Controller
 * 
 * @author mingyuan
 * @date 2024-10-15
 */
@RestController
@RequestMapping("/chanhu/department")
public class ProcessClientDepartmentController extends BaseController
{
    @Autowired
    private IProcessClientDepartmentService processClientDepartmentService;

    /**
     * 查询客户单位部门管理列表
     */
    @PreAuthorize("@ss.hasPermi('chanhu:department:list')")
    @GetMapping("/list")
    public TableDataInfo list(ProcessClientDepartment processClientDepartment)
    {
        startPage();
        List<ProcessClientDepartment> list = processClientDepartmentService.selectProcessClientDepartmentList(processClientDepartment);
        return getDataTable(list);
    }

    /**
     * 导出客户单位部门管理列表
     */
    @PreAuthorize("@ss.hasPermi('chanhu:department:export')")
    @Log(title = "客户单位部门管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ProcessClientDepartment processClientDepartment)
    {
        List<ProcessClientDepartment> list = processClientDepartmentService.selectProcessClientDepartmentList(processClientDepartment);
        ExcelUtil<ProcessClientDepartment> util = new ExcelUtil<ProcessClientDepartment>(ProcessClientDepartment.class);
        util.exportExcel(response, list, "客户单位部门管理数据");
    }

    /**
     * 获取客户单位部门管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('chanhu:department:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(processClientDepartmentService.selectProcessClientDepartmentById(id));
    }

    /**
     * 新增客户单位部门管理
     */
    @PreAuthorize("@ss.hasPermi('chanhu:department:add')")
    @Log(title = "客户单位部门管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ProcessClientDepartment processClientDepartment)
    {
        return toAjax(processClientDepartmentService.insertProcessClientDepartment(processClientDepartment));
    }

    /**
     * 修改客户单位部门管理
     */
    @PreAuthorize("@ss.hasPermi('chanhu:department:edit')")
    @Log(title = "客户单位部门管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ProcessClientDepartment processClientDepartment)
    {
        return toAjax(processClientDepartmentService.updateProcessClientDepartment(processClientDepartment));
    }

    /**
     * 删除客户单位部门管理
     */
    @PreAuthorize("@ss.hasPermi('chanhu:department:remove')")
    @Log(title = "客户单位部门管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(processClientDepartmentService.deleteProcessClientDepartmentByIds(ids));
    }
}
