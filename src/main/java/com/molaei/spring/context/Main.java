package com.molaei.spring.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student = (Student) context.getBean("student");
        Student student2 = (Student) context.getBean("student");
        if (student == student2){
            System.out.println(true);
        }
        System.out.println(student);
    }
}
