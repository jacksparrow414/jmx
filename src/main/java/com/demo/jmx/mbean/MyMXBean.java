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
 *
 * jconsole中看到的属性是方法名去掉get后的名字，如下面的getUser,getName,
 * 可以尝试将getName和setName修改为getname、setname，再观察jconsole，发现属性由Name变为name了
 *
 * 官方文档原话 对应的文档： https://docs.oracle.com/javase/tutorial/jmx/mbeans/standard.html
 * Getter and setter methods are declared to allow the managed application to access and possibly change the attribute values. As defined by the JMX specification,
 * a getter is any public method that does not return void and whose name begins with get.
 * A getter enables a manager to read the value of the attribute,
 * whose type is that of the returned object.
 * A setter is any public method that takes a single parameter and whose name begins with set.
 * A setter enables a manager to write a new value in the attribute,
 * whose type is the same as that of the paramete
 */
@MXBean
public interface MyMXBean{

    User getUser();

    String getName();

    void setName(String name);

    void logMessage();

}
