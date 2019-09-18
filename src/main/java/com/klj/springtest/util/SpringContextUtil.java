package com.klj.springtest.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author lvxi
 * Create Time: 2018/8/23 11:46
 */
@Component
public class SpringContextUtil implements ApplicationContextAware {

    /**
     * Spring应用上下文环境
     */
    private static ApplicationContext applicationContext;

    /**
     * 重写并初始化上下文
     * @param applicationContext 应用上下文
     * @throws BeansException bean异常
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        // 初始化applicationContext
        SpringContextUtil.applicationContext = applicationContext;
    }

    /**
     * 通过类获取
     * @param clazz 注入的类
     * @param <T> 返回类型
     * @return 返回这个bean
     * @throws BeansException bean异常
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(Class<T> clazz) throws BeansException {
        return  (T)applicationContext.getBean(clazz);
    }

    /**
     * 通过名字获取
     * @param name 名字
     * @param <T> 返回类型
     * @return 返回这个bean
     * @throws BeansException bean异常
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(String name) throws BeansException {
        return (T) applicationContext.getBean(name);
    }

}
