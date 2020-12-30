package com.gaowl.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Blog {
    private String id;
    private String title;
    private String author;
    private Date create_time;   // 此处属性名和字段名不一致，可以通过mybatis开启自动驼峰命名解决
    private int views;
}
