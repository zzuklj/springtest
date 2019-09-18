package com.klj.springtest.config.initialize.order;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author klj
 * @Title: ServiceA
 * @Description: TODO
 * @date 2019/1/1514:24
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE+1)
public class ServiceA implements ApplicationListener<ApplicationContextEvent> {
    @Override
    public void onApplicationEvent(ApplicationContextEvent applicationContextEvent) {
        initA();
    }

    private void initA(){
        System.out.println("init A");
    }
}
