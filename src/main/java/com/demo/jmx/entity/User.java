package com.demo.jmx.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

    private String name;

    private Long password;

    private Boolean used;
}
