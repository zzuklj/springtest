package com.klj.springtest.service;

import com.klj.springtest.config.event.UserRegisterEvent;
import com.klj.springtest.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author klj
 * @Title: UserService
 * @Description: TODO
 * @date 2019/1/149:46
 */
@Service
public class UserService {

    @Autowired
    ApplicationEventPublisher eventPublisher;

    public boolean register(UserVo vo) {
        eventPublisher.publishEvent(new UserRegisterEvent(vo));
        return true;
    }

    public boolean drawPrize(UserVo vo) {
        return true;
    }

    public UserVo getDetail(Integer id) {
        return UserVo.builder().id(1).name("klj").build();
    }
}
