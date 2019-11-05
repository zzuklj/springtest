package com.klj.springtest.extend.designpattern.proxy;

import java.lang.reflect.Method;

/**
 * @author klj
 * @Title: InvocationHandler
 * @Description: TODO
 * @date 2019/6/1711:50
 */
public class InvocationHandler implements java.lang.reflect.InvocationHandler {


    private Object target;

    public InvocationHandler(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before invoke.............");
        method.invoke(target, args);
        System.out.println("after invoke.............");
        return null;
    }
}
