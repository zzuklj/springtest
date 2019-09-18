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
public class ServiceB implements ApplicationListener<ApplicationContextEvent>, Ordered {
    @Override
    public void onApplicationEvent(ApplicationContextEvent applicationContextEvent) {
        initB();
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }

    private void initB(){
        System.out.println("init B");
    }
}
