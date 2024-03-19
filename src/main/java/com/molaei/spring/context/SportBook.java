package com.molaei.spring.context;

import org.springframework.stereotype.Component;

@Component
public class SportBook implements Book{
    public int getPrice() {
        return 0;
    }

    public String getTitle() {
        return null;
    }
}
