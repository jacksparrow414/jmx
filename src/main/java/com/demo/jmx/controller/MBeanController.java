package com.demo.jmx.controller;

import lombok.SneakyThrows;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.management.*;
import java.lang.management.ManagementFactory;
import java.util.Arrays;

@Log
@RestController
@RequestMapping(path = "mbean")
public class MBeanController {

    /**
     * curl 'http://localhost:18081/jmx/mbean?objectName=com.demo.jmx.mbean%3Atype%3DMyMXBeanImpl%2C%20name%3Dcustom'
     * @param objectName
     * @return
     */
    @SneakyThrows
    @GetMapping
    public String queryMbeans(@RequestParam String objectName) {
        MBeanServer platformMBeanServer = ManagementFactory.getPlatformMBeanServer();
        ObjectName mxbeanName = new ObjectName(objectName);
//        如果传null，则查询所有MBean
//        platformMBeanServer.queryMBeans(null, null);
        MBeanAttributeInfo[] mBeanAttributeInfos = platformMBeanServer.getMBeanInfo(mxbeanName).getAttributes();
        for (MBeanAttributeInfo mBeanAttributeInfo : mBeanAttributeInfos) {
            log.info(mBeanAttributeInfo.getName());
            log.info(mBeanAttributeInfo.getClass().getName());
        }
//        通过MBeanAttributeInfo拿AttributeList
        AttributeList attributes = platformMBeanServer.getAttributes(mxbeanName, Arrays.stream(mBeanAttributeInfos).map(MBeanFeatureInfo::getName).toArray(String[]::new));
//        遍历AttributeList获取每个attribute的值
        attributes.forEach(each -> {
            if (each instanceof Attribute) {
                String value = ((Attribute) each).getValue().toString();
                log.info(value);
            }
        });

        return "ok";
    }
}
