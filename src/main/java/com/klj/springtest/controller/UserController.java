package com.klj.springtest.controller;

import com.klj.springtest.controller.base.BaseController;
import com.klj.springtest.model.JsonResult;
import com.klj.springtest.service.UserService;
import com.klj.springtest.vo.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Api("用户服务")
public class UserController extends BaseController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    @ApiOperation("注册")
    public JsonResult register(UserVo userVo){
        return simpleJsonResult(userVo, userService::register);
    }

    @GetMapping("/detail")
    @ApiOperation("查询详情")
    public JsonResult<UserVo> getDetail(Integer id){
        return simpleJsonResult(id, userService::getDetail);
    }

    @GetMapping("/draw-prize")
    @ApiOperation("抽奖")
    public JsonResult drawPrize(UserVo vo){
        return simpleJsonResult(vo, userService::drawPrize);
    }


}
