package com.sgllnh.myblog.controller;

import com.github.pagehelper.PageHelper;
import com.sgllnh.myblog.entity.Message;
import com.sgllnh.myblog.service.IMessageService;
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
 * message控制器层
 *
 * @author wangqiang
 */
@RestController
@RequestMapping("generator/message")
public class MessageController {
    @Autowired
    private IMessageService messageService;

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
        List<Message> selectAll = messageService.list();
        return R.ok().put("page", selectAll);
    }

    @ApiOperation(value = "spring cloud根据ID查询应用信息", notes = "spring cloud根据ID查询应用信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "String")})
    @RequestMapping(method = RequestMethod.GET, value = "/info/{id}")
    public R info(@PathVariable("id") String id) {
        Message message = messageService.getById(id);

        return R.ok().put("message", message);
    }

    @ApiOperation(value = "spring cloud根据新增应用信息", notes = "spring cloud根据ID新增应用信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "message", value = "message实体类", required = true, dataType = "Message")})
    @RequestMapping(method = RequestMethod.POST, value = "/save")
    public R save(@RequestBody Message message) {
        messageService.save(message);
        return R.ok();
    }

    @ApiOperation(value = "spring cloud根据修改应用信息", notes = "spring cloud修改应用信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "message", value = "message实体类", required = true, dataType = "Message")})
    @RequestMapping(method = RequestMethod.PUT, value = "/update")
    public R update(@RequestBody Message message) {
        messageService.updateById(message);
        return R.ok();
    }

    @ApiOperation(value = "spring cloud删除应用信息", notes = "spring cloud删除应用信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids", value = "ids集合", allowMultiple = true, dataType = "String", paramType = "query")})
    @RequestMapping(method = RequestMethod.DELETE, value = "/delete")
    public R delete(String[] ids) {
        for (String id : ids) {
            messageService.removeById(id);
        }
        return R.ok();
    }

}
