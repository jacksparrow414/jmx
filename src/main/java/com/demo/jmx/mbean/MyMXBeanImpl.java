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
 * 属性对应的是在当前实现类中定义的，对属性的具体操作方法get/set则是在MXBean中定义的，二者通过接口中实现的方法进行关联,
 * 如果只有属性而接口中没有和这个属性相关的方法，
 * 那么jconsole中是看不到这个属性的
 *
 *
 * 【属性】默认的方法名字是get*和set*和is*去掉前缀。如果提供了set和get方法，那么该属性在jconsole中的属性【那里】是可以直接编辑，然后【刷新】的
 * 一个简单的方法是，如果属性点开右边显示部分是蓝色的，那么基本可以是编辑的。也说明这个属性有setA和getA方法。如果是灰色的，说明不可编辑。只有getA方法
 * 【操作】如果方法名字不是上述的那几种，则为操作。也可以是同为set*方法，但是有多个参数。如下面的set方法 或者参考{@link org.apache.logging.log4j.core.jmx.LoggerContextAdminMBean#setConfigText}
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

    /**
     * 这里的方法在jconsole中属于操作.
     * @param name
     * @param charsetName
     */
    @Override
    public void setName(String name, String charsetName) {
        log.info("name is " +name+ " charsetName is " + charsetName);
    }
}
