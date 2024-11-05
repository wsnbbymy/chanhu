package com.ruoyi.chanhu.controller;

import com.ruoyi.chanhu.domain.Operator;
import com.ruoyi.chanhu.domain.ProcessClientInfo;
import com.ruoyi.chanhu.service.IProcessClientInfoService;
import com.ruoyi.chanhu.service.ProcessExtraService;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

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

    @Resource
    private ProcessExtraService processExtraService;

    /**
     * 查询客户信息列表
     */
    @PreAuthorize("@ss.hasPermi('chanhu:process_client:list')")
    @GetMapping("/list")
    public TableDataInfo list(ProcessClientInfo processClientInfo)
    {
        startPage();
        List<ProcessClientInfo> list = processClientInfoService.selectProcessClientInfoList(processClientInfo);
//        List<ProcessClientInfoDto> list = processClientInfoService.selectProcessClientInfoListAndDepartments(processClientInfo);
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

    /**
     *  查询业务字段
     */
    @GetMapping("/getTableConfig")
    public AjaxResult getTableConfig(){



        return toAjax(true);
    }

    /**
     *  查询供应商字典
     */
    @GetMapping("/getOperators")
    public AjaxResult getOperators(@RequestParam("id") Integer id){
        return success(processExtraService.getOperators(id));
    }


    /**
     *  查询供应商字典
     */
    @PostMapping("/createOperators")
    public AjaxResult createOperator(@RequestBody Operator operator){
        processExtraService.createOperator(operator);
        return success();
    }

    @PostMapping("/updateOperators")
    public AjaxResult updateOperators(@RequestBody Operator operator){
        processExtraService.updateOperator(operator);
        return success();
    }

    @PostMapping("/deleteOperators")
    public AjaxResult deleteOperators(@RequestBody Operator operator){
        processExtraService.updateOperator(operator);
        return success();
    }
}
