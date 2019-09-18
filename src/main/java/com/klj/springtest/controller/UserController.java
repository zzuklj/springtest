package com.klj.springtest.controller;

import com.klj.springtest.config.event.UserRegisterEvent;
import com.klj.springtest.vo.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Api("用户服务")
public class UserController {

    @Autowired
    ApplicationEventPublisher eventPublisher;

    @PostMapping("/register")
    @ApiOperation("注册")
    public void register(UserVo userVo){
        eventPublisher.publishEvent(new UserRegisterEvent(userVo));
    }
}
