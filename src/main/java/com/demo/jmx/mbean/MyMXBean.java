package com.demo.jmx.mbean;

import com.demo.jmx.entity.User;

import javax.management.MXBean;

/**
 * 两种方式
 * 1、使用注解
 * 2、接口名字以MXBean结尾
 *
 * 对于要取值的属性，要有get方法
 *
 * 对于设值的属性，要有set方法
 *
 * 对象无法设值，只能是基本类型和包装类
 */
@MXBean
public interface MyMXBean{

    User getUser();

    String getName();

    void setName(String name);

    void logMessage();

}
