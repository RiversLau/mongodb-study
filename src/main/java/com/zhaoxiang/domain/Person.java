package com.zhaoxiang.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.bson.types.ObjectId;

/**
 * Author: RiversLau
 * Date: 2017/9/8 15:29
 */
@Getter
@Setter
@ToString
public class Person {

    private ObjectId id;
    private String name;
    private int age;
    private String description;
    private Address address;
}
