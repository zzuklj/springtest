package com.klj.springtest.extend.designpattern.proxy;

import java.lang.reflect.Proxy;

/**
 * @author klj
 * @Title: UserService
 * @Description: TODO
 * @date 2019/6/1711:53
 */
public class UserProxyService implements IUserProxyService {

    @Override
    public void getUserInfo(){
        System.out.println(" I am a man");
    }


    public static void main(String[] args) {
        IUserProxyService us = new UserProxyService();
        InvocationHandler ih = new InvocationHandler(us);
        IUserProxyService pus = (IUserProxyService) Proxy.newProxyInstance(IUserProxyService.class.getClassLoader(),
                UserProxyService.class.getInterfaces(),
                ih);
        pus.getUserInfo();
    }
}
