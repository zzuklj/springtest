package com.klj.springtest.config.initialize.order;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * @author klj
 * @Title: ServiceA
 * @Description: TODO
 * @date 2019/1/1514:24
 */
@Component
public class ServiceA implements ApplicationListener<ApplicationContextEvent>, Ordered {
    @Override
    public void onApplicationEvent(ApplicationContextEvent applicationContextEvent) {
        initA();
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE - 1;
    }

    private void initA(){
        System.out.println("init A");
    }
}
