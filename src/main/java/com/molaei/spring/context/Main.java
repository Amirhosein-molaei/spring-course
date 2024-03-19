package com.molaei.spring.context;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    static Logger logger = Logger.getLogger(Main.class);
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student = (Student) context.getBean("student");
        Student student2 = (Student) context.getBean("student");
        if (student == student2){
            System.out.println(true);
        }
        logger.info("test log4j");
        //TODO config log4j for writing into file.
        System.out.println(student);
    }
}
