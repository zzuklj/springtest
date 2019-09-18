package com.klj.springtest.config.listener;

import com.klj.springtest.config.event.UserRegisterEvent;
import com.klj.springtest.vo.UserVo;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
@Order(value = Integer.MAX_VALUE-20)
public class EmailListener implements ApplicationListener<UserRegisterEvent> {
    @Override
    public void onApplicationEvent(UserRegisterEvent event) {
        UserVo user = (UserVo) event.getSource();
        System.out.println("send email to "+ user.getName());
    }
}
