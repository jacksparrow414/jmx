package com.demo.jmx.mbean;

public class MyMXBeanImpl implements MyMXBean {

    private String name = "jack";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
