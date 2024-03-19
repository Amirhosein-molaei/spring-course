package com.molaei.spring.context;

import lombok.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@ToString
@Component
public class Student {

    @Autowired
    private Logger logger;

    private int age;
    @Value("reza")
    private String name;
    private String family;

    @Autowired
//    @Qualifier("sportBook")
    private Book book;

    @Autowired
    private Environment env;
    public Student(){
        System.out.println("in constructor");
    }

    public void init(){
        System.out.println("init method");
    }
}
