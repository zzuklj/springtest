package com.klj.springtest.config.event;

import com.klj.springtest.vo.UserVo;
import org.springframework.context.ApplicationEvent;

public class UserRegisterEvent extends ApplicationEvent {
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public UserRegisterEvent(UserVo source) {
        super(source);
    }
}
