package com.klj.springtest.extend.java8;

import com.klj.springtest.model.User;

import java.util.Optional;

/**
 * @author klj
 * @Title: FunctionTest
 * @Description: TODO
 * @date 2019/5/2813:58
 */
public class FunctionTest {

    public static void main(String[] args) {
        User u = null;
        Optional<User> user = Optional.ofNullable(u);
        user.ifPresent(user1 -> {
            String userName = user1.getUserName();
            System.out.println(userName);
        });
    }
}
