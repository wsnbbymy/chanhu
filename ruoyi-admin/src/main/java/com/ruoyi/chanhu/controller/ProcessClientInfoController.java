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
import com.ruoyi.chanhu.domain.ProcessClientInfo;
import com.ruoyi.chanhu.service.IProcessClientInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 客户信息Controller
 * 
 * @author mingyuan
 * @date 2024-10-15
 */
@RestController
@RequestMapping("/chanhu/process_client")
public class ProcessClientInfoController extends BaseController
{
    @Autowired
    private IProcessClientInfoService processClientInfoService;

    /**
     * 查询客户信息列表
     */
    @PreAuthorize("@ss.hasPermi('chanhu:process_client:list')")
    @GetMapping("/list")
    public TableDataInfo list(ProcessClientInfo processClientInfo)
    {
        startPage();
        List<ProcessClientInfo> list = processClientInfoService.selectProcessClientInfoList(processClientInfo);
        return getDataTable(list);
    }

    /**
     * 导出客户信息列表
     */
    @PreAuthorize("@ss.hasPermi('chanhu:process_client:export')")
    @Log(title = "客户信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ProcessClientInfo processClientInfo)
    {
        List<ProcessClientInfo> list = processClientInfoService.selectProcessClientInfoList(processClientInfo);
        ExcelUtil<ProcessClientInfo> util = new ExcelUtil<ProcessClientInfo>(ProcessClientInfo.class);
        util.exportExcel(response, list, "客户信息数据");
    }

    /**
     * 获取客户信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('chanhu:process_client:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(processClientInfoService.selectProcessClientInfoById(id));
    }

    /**
     * 新增客户信息
     */
    @PreAuthorize("@ss.hasPermi('chanhu:process_client:add')")
    @Log(title = "客户信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ProcessClientInfo processClientInfo)
    {
        return toAjax(processClientInfoService.insertProcessClientInfo(processClientInfo));
    }

    /**
     * 修改客户信息
     */
    @PreAuthorize("@ss.hasPermi('chanhu:process_client:edit')")
    @Log(title = "客户信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ProcessClientInfo processClientInfo)
    {
        return toAjax(processClientInfoService.updateProcessClientInfo(processClientInfo));
    }

    /**
     * 删除客户信息
     */
    @PreAuthorize("@ss.hasPermi('chanhu:process_client:remove')")
    @Log(title = "客户信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(processClientInfoService.deleteProcessClientInfoByIds(ids));
    }
}
