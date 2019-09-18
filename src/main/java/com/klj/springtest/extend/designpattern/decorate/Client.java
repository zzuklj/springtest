package com.klj.springtest.extend.designpattern.decorate;

import java.lang.reflect.Proxy;

/**
 * Created by 0 on 2018/8/14.
 */
public class Client {
    public static void main(String[] args) {
        RealSubject subject = new RealSubject();
        Subject proxyInstance  = (Subject) Proxy.newProxyInstance(Subject.class.getClassLoader(),
                                new Class[]{Subject.class},
                                new SubjectProxy(subject));
        System.out.println(proxyInstance.reverseInput("hello world"));
    }
}
