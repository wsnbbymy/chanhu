package com.ruoyi.chanhu.controller;

import com.ruoyi.chanhu.domain.ProcessContractsMenu;
import com.ruoyi.chanhu.service.IProcessContractsMenuService;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/chanhu/process_contracts_menu")
public class ProcessContractsMenuController extends BaseController {
    @Autowired
    private IProcessContractsMenuService processContractsMenuService;

    @GetMapping("/menu")
    public List<ProcessContractsMenu> getMenuItems() {
        List<ProcessContractsMenu> allItems = processContractsMenuService.getAllMenuItems();
        List<ProcessContractsMenu> processContractsMenus = processContractsMenuService.buildTree(allItems);
        return processContractsMenus;
    }

    /**
     * 查询合同菜单列表
     */
    @PreAuthorize("@ss.hasPermi('chanhu:process_contracts_menu:list')")
    @GetMapping("/list")
    public TableDataInfo list(ProcessContractsMenu processContractsMenu)
    {
        startPage();
        List<ProcessContractsMenu> list = processContractsMenuService.selectProcessContractsMenuList(processContractsMenu);
        return getDataTable(list);
    }

    /**
     * 导出合同菜单列表
     */
    @PreAuthorize("@ss.hasPermi('chanhu:process_contracts_menu:export')")
    @Log(title = "合同菜单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ProcessContractsMenu processContractsMenu)
    {
        List<ProcessContractsMenu> list = processContractsMenuService.selectProcessContractsMenuList(processContractsMenu);
        ExcelUtil<ProcessContractsMenu> util = new ExcelUtil<ProcessContractsMenu>(ProcessContractsMenu.class);
        util.exportExcel(response, list, "合同菜单数据");
    }

    /**
     * 获取合同菜单详细信息
     */
    @PreAuthorize("@ss.hasPermi('chanhu:process_contracts_menu:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(processContractsMenuService.selectProcessContractsMenuById(id));
    }

    /**
     * 新增合同菜单
     */
    @PreAuthorize("@ss.hasPermi('chanhu:process_contracts_menu:add')")
    @Log(title = "合同菜单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ProcessContractsMenu processContractsMenu)
    {
        return toAjax(processContractsMenuService.insertProcessContractsMenu(processContractsMenu));
    }

    /**
     * 修改合同菜单
     */
    @PreAuthorize("@ss.hasPermi('chanhu:process_contracts_menu:edit')")
    @Log(title = "合同菜单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ProcessContractsMenu processContractsMenu)
    {
        return toAjax(processContractsMenuService.updateProcessContractsMenu(processContractsMenu));
    }

    /**
     * 删除合同菜单
     */
    @PreAuthorize("@ss.hasPermi('chanhu:process_contracts_menu:remove')")
    @Log(title = "合同菜单", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(processContractsMenuService.deleteProcessContractsMenuByIds(ids));
    }
}
