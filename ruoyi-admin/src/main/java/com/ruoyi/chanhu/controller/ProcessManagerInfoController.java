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
import com.ruoyi.chanhu.domain.ProcessManagerInfo;
import com.ruoyi.chanhu.service.IProcessManagerInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 客户经理信息管理Controller
 * 
 * @author mingyuan
 * @date 2024-10-15
 */
@RestController
@RequestMapping("/chanhu/process_manager")
public class ProcessManagerInfoController extends BaseController
{
    @Autowired
    private IProcessManagerInfoService processManagerInfoService;

    /**
     * 查询客户经理信息管理列表
     */
    @PreAuthorize("@ss.hasPermi('chanhu:process_manager:list')")
    @GetMapping("/list")
    public TableDataInfo list(ProcessManagerInfo processManagerInfo)
    {
        startPage();
        List<ProcessManagerInfo> list = processManagerInfoService.selectProcessManagerInfoList(processManagerInfo);
        return getDataTable(list);
    }

    /**
     * 导出客户经理信息管理列表
     */
    @PreAuthorize("@ss.hasPermi('chanhu:process_manager:export')")
    @Log(title = "客户经理信息管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ProcessManagerInfo processManagerInfo)
    {
        List<ProcessManagerInfo> list = processManagerInfoService.selectProcessManagerInfoList(processManagerInfo);
        ExcelUtil<ProcessManagerInfo> util = new ExcelUtil<ProcessManagerInfo>(ProcessManagerInfo.class);
        util.exportExcel(response, list, "客户经理信息管理数据");
    }

    /**
     * 获取客户经理信息管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('chanhu:process_manager:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(processManagerInfoService.selectProcessManagerInfoById(id));
    }

    /**
     * 新增客户经理信息管理
     */
    @PreAuthorize("@ss.hasPermi('chanhu:process_manager:add')")
    @Log(title = "客户经理信息管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ProcessManagerInfo processManagerInfo)
    {
        return toAjax(processManagerInfoService.insertProcessManagerInfo(processManagerInfo));
    }

    /**
     * 修改客户经理信息管理
     */
    @PreAuthorize("@ss.hasPermi('chanhu:process_manager:edit')")
    @Log(title = "客户经理信息管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ProcessManagerInfo processManagerInfo)
    {
        return toAjax(processManagerInfoService.updateProcessManagerInfo(processManagerInfo));
    }

    /**
     * 删除客户经理信息管理
     */
    @PreAuthorize("@ss.hasPermi('chanhu:process_manager:remove')")
    @Log(title = "客户经理信息管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(processManagerInfoService.deleteProcessManagerInfoByIds(ids));
    }
}
