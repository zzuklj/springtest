package com.klj.springtest.config.springlistener;

import com.klj.springtest.mapper.UserMapper;
import com.klj.springtest.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author klj
 * @Title: spring中的bean加载完之后执行
 * @Description: TODO
 * @date 2019/1/149:29
 */
@Component
/*public class DictContentLoad implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired(required = false)
    private UserMapper userMapper;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        //ApplicationContext
        //List<User> users = userMapper.selectAll();
        User user = userMapper.selectByPrimaryKey(1);
        System.out.println(user.getUserName());
    }*/
public class DictContentLoad implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired(required = false)
    private UserMapper userMapper;

    @Autowired
    private StringRedisTemplate srt;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        User user = userMapper.selectByPrimaryKey(1);
        System.out.println(user.getUserName());

        srt.opsForValue().set("srt","klj");
        srt.opsForHash().put("srthash","name","klj");

    }
}
