package com.klj.springtest.extend.designpattern.decorate;

/**
 * Created by 0 on 2018/8/14.
 */
public class RealSubject implements Subject {
    @Override
    public String reverseInput(String input) {
        System.out.println("this is realSubject:"+input);
        return new StringBuilder(input).reverse().toString();
    }
}
