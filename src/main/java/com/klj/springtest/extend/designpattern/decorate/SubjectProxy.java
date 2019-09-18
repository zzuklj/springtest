package com.klj.springtest.extend.designpattern.decorate;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by 0 on 2018/8/14.
 */
public class SubjectProxy implements InvocationHandler {

    private Object target;

    public SubjectProxy(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxy subject is "+ proxy.getClass());
        System.out.println("real subject is "+ ToStringBuilder.reflectionToString(target));
        System.out.println("method: "+method);
        System.out.println("args: "+ ToStringBuilder.reflectionToString(args));
        return method.invoke(target,args);
    }
}
