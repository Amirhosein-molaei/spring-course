package com.molaei.spring.context;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
@Primary
public class HistoryBook implements Book{

    private int price;
    private String title;
    public int getPrice() {
        return 0;
    }

    public String getTitle() {
        return null;
    }
}
