package com.sgllnh.myblog.controller;

import com.github.pagehelper.PageHelper;
import com.sgllnh.myblog.entity.User;
import com.sgllnh.myblog.service.IUserService;
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
 * user控制器层
 *
 * @author wangqiang
 */
@RestController
@RequestMapping("generator/user")
public class UserController {
    @Autowired
    private IUserService userService;

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
        List<User> selectAll = userService.list();
        return R.ok().put("page", selectAll);
    }

    @ApiOperation(value = "spring cloud根据ID查询应用信息", notes = "spring cloud根据ID查询应用信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "String")})
    @RequestMapping(method = RequestMethod.GET, value = "/info/{id}")
    public R info(@PathVariable("id") String id) {
        User user = userService.getById(id);

        return R.ok().put("user", user);
    }

    @ApiOperation(value = "spring cloud根据新增应用信息", notes = "spring cloud根据ID新增应用信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "user实体类", required = true, dataType = "User")})
    @RequestMapping(method = RequestMethod.POST, value = "/save")
    public R save(@RequestBody User user) {
        userService.save(user);
        return R.ok();
    }

    @ApiOperation(value = "spring cloud根据修改应用信息", notes = "spring cloud修改应用信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "user实体类", required = true, dataType = "User")})
    @RequestMapping(method = RequestMethod.PUT, value = "/update")
    public R update(@RequestBody User user) {
        userService.updateById(user);
        return R.ok();
    }

    @ApiOperation(value = "spring cloud删除应用信息", notes = "spring cloud删除应用信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids", value = "ids集合", allowMultiple = true, dataType = "String", paramType = "query")})
    @RequestMapping(method = RequestMethod.DELETE, value = "/delete")
    public R delete(String[] ids) {
        for (String id : ids) {
            userService.removeById(id);
        }
        return R.ok();
    }


    @ApiOperation(value = "注册用户信息", notes = "注册用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", allowMultiple = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "password", value = "密码", allowMultiple = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "email", value = "email", allowMultiple = true, dataType = "String", paramType = "query")
    })
    @RequestMapping(method = RequestMethod.POST, value = "/register")
    public R register(@RequestParam String username, @RequestParam String password, @RequestParam String email) {
        //查询用户
        User user = userService.findByUsername(username);
        if (user == null) {
            //注册
            userService.register(username, password, email);
            return R.ok();
        } else {
            return R.error("该用户已注册");
        }
    }

    @ApiOperation(value = "登录用户信息", notes = "登录用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", allowMultiple = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "password", value = "密码", allowMultiple = true, dataType = "String", paramType = "query")
    })
    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public R login (@RequestParam String username, @RequestParam String password) {
        //return userService.login(username, password);
        return null;
    }
}
