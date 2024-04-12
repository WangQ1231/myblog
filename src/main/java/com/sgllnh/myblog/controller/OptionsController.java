package com.sgllnh.myblog.controller;

import com.github.pagehelper.PageHelper;
import com.sgllnh.myblog.entity.Options;
import com.sgllnh.myblog.service.IOptionsService;
import com.sgllnh.myblog.utils.R;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;
import java.util.Map;

/**
 * options控制器层
 *
 * @author Administrator
 */
@RestController
@RequestMapping("generator/options")
public class OptionsController {
    @Autowired
    private IOptionsService optionsService;

    @ApiOperation(value = "spring cloud关键字查询应用信息", notes = "spring cloud分页查询应用信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "当前页数", required = false, paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "size", value = "每页数量", required = false, paramType = "query", dataType = "int")})
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    public R list(@ApiIgnore @RequestParam Map<String, Object> params) {
        //閸掋倖鏌囬弰顖氭儊鐢箑鍨庢い闈涘棘閺侊拷
        if (null != params.get("size") && null != params.get("page")) {
            int page = Integer.parseInt(params.get("page").toString());
            int size = Integer.parseInt(params.get("size").toString());
            PageHelper.startPage(page, size);
        }
        List<Options> selectAll = optionsService.list();
        return R.ok().put("page", selectAll);
    }

    @ApiOperation(value = "spring cloud根据ID查询应用信息", notes = "spring cloud根据ID查询应用信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "String")})
    @RequestMapping(method = RequestMethod.GET, value = "/info/{id}")
    public R info(@PathVariable("id") String id) {
        Options options = optionsService.getById(id);

        return R.ok().put("options", options);
    }

    @ApiOperation(value = "spring cloud根据新增应用信息", notes = "spring cloud根据ID新增应用信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "options", value = "options实体类", required = true, dataType = "Options")})
    @RequestMapping(method = RequestMethod.POST, value = "/save")
    public R save(@RequestBody Options options) {
        optionsService.save(options);
        return R.ok();
    }

    @ApiOperation(value = "spring cloud根据修改应用信息", notes = "spring cloud修改应用信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "options", value = "options实体类", required = true, dataType = "Options")})
    @RequestMapping(method = RequestMethod.PUT, value = "/update")
    public R update(@RequestBody Options options) {
        optionsService.updateById(options);
        return R.ok();
    }

    @ApiOperation(value = "spring cloud删除应用信息", notes = "spring cloud删除应用信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids", value = "ids集合", allowMultiple = true, dataType = "String", paramType = "query")})
    @RequestMapping(method = RequestMethod.DELETE, value = "/delete")
    public R delete(String[] ids) {
        for (String id : ids) {
            optionsService.removeById(id);
        }
        return R.ok();
    }

}
