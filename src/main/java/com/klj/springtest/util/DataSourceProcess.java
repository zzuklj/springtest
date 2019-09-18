package com.klj.springtest.util;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * @author klj
 * @Title: DataSourceProcess
 * @Description: TODO
 * @date 2018/12/24 14:41
 */
//@Component
public class DataSourceProcess implements BeanPostProcessor{
    @Nullable
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }

    @Nullable
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(beanName);
        if(bean instanceof DataSourceProperties){
            DataSourceProperties dataSourceProperties = (DataSourceProperties) bean;
            String  s = JSON.toJSONString(dataSourceProperties);
            System.out.println("==================="+s+"===================");
        }

        return null;
    }
}
