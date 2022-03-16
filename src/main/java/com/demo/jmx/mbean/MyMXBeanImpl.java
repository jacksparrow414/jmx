package com.demo.jmx.mbean;

import com.demo.jmx.entity.User;
import lombok.extern.java.Log;
import org.springframework.boot.admin.SpringApplicationAdminMXBean;

import java.lang.management.MemoryMXBean;

/**
 * 给要在JMX中查看的属性赋初始值，否则在JXM中看不到
 *
 * JMX中可以看到属性、操作两个
 *
 * 属性对应的是在当前实现类中定义的，对属性的具体操作方法get/set则是在MXBean中定义的，二者通过接口中实现的方法进行关联
 *
 * 操作则是不涉及当前类中的属性
 *
 * 可参考{@link SpringApplicationAdminMXBean}和{@link MemoryMXBean}
 */
@Log
public class MyMXBeanImpl implements MyMXBean {

    private String name = "jack";

    private User user = User.builder().name("jack").password(888888L).used(false).build();;

    @Override
    public User getUser() {
        return user;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * JMX 操作示例
     */
    @Override
    public void logMessage() {
        log.info("log message");
    }
}
