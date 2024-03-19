package com.molaei.spring.context;


import com.molaei.beans.Book;
import com.molaei.beans.Course;
import com.molaei.beans.Teacher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Teacher t = (Teacher) context.getBean("teacher");
        t.setName("peyman Dodangeh");
        t.setCourse("Java");
        Book book = (Book) context.getBean("book");
        book.setTitle("PHP Learning");
        book.setPrice("70$");
        Course course = (Course) context.getBean("course");
        course.setTeacher(t);
        course.setNumberOfStudents(11);
        course.setLanguage("java");
        System.out.println(book);
    }
}
