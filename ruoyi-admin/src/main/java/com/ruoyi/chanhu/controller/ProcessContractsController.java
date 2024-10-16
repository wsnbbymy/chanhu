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
import com.ruoyi.chanhu.domain.ProcessContracts;
import com.ruoyi.chanhu.service.IProcessContractsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 合同管理Controller
 * 
 * @author mingyuan
 * @date 2024-10-16
 */
@RestController
@RequestMapping("/chanhu/contracts")
public class ProcessContractsController extends BaseController
{
    @Autowired
    private IProcessContractsService processContractsService;

    /**
     * 查询合同管理列表
     */
    @PreAuthorize("@ss.hasPermi('chanhu:contracts:list')")
    @GetMapping("/list")
    public TableDataInfo list(ProcessContracts processContracts)
    {
        startPage();
        List<ProcessContracts> list = processContractsService.selectProcessContractsList(processContracts);
        return getDataTable(list);
    }

    /**
     * 导出合同管理列表
     */
    @PreAuthorize("@ss.hasPermi('chanhu:contracts:export')")
    @Log(title = "合同管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ProcessContracts processContracts)
    {
        List<ProcessContracts> list = processContractsService.selectProcessContractsList(processContracts);
        ExcelUtil<ProcessContracts> util = new ExcelUtil<ProcessContracts>(ProcessContracts.class);
        util.exportExcel(response, list, "合同管理数据");
    }

    /**
     * 获取合同管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('chanhu:contracts:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(processContractsService.selectProcessContractsById(id));
    }

    /**
     * 新增合同管理
     */
    @PreAuthorize("@ss.hasPermi('chanhu:contracts:add')")
    @Log(title = "合同管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ProcessContracts processContracts)
    {
        return toAjax(processContractsService.insertProcessContracts(processContracts));
    }

    /**
     * 修改合同管理
     */
    @PreAuthorize("@ss.hasPermi('chanhu:contracts:edit')")
    @Log(title = "合同管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ProcessContracts processContracts)
    {
        return toAjax(processContractsService.updateProcessContracts(processContracts));
    }

    /**
     * 删除合同管理
     */
    @PreAuthorize("@ss.hasPermi('chanhu:contracts:remove')")
    @Log(title = "合同管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(processContractsService.deleteProcessContractsByIds(ids));
    }
}
