package com.demo.jmx.configuration;

import com.demo.jmx.mbean.MyMXBeanImpl;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

/**
 *
 * 写法大致为 service:jmx:rmi://192.168.30.10:1234/jndi/rmi://192.168.30.10:2344/jmxrmi
 * 以上写法解释 https://stackoverflow.com/questions/2768087/explain-jmx-url
 *
 * 官方文档解释： https://docs.oracle.com/javase/tutorial/jmx/remote/custom.html
 */
@Component
public class JMXRegister {

    /**
     * type为接口实现名字.匹配规则：https://docs.oracle.com/javase/8/docs/api/javax/management/ObjectName.html
     */
    @PostConstruct
    @SneakyThrows
    public void registerMXBeans() {
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        ObjectName mxbeanName = new ObjectName("com.demo.jmx.mbean:type=MyMXBeanImpl, name=custom");
        MyMXBeanImpl myMXBean = new MyMXBeanImpl();
        mbs.registerMBean(myMXBean, mxbeanName);
    }
}
