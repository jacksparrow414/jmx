package com.demo.jmx.mbean;

import javax.management.MXBean;

/**
 * 两种方式
 * 1、使用注解
 * 2、接口名字以MXBean结尾
 */
@MXBean
public interface MyMXBean{

    String getName();

    void setName(String name);

}
