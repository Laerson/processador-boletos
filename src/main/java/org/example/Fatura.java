package org.example;

import java.time.LocalDate;

public class Fatura {
    private LocalDate date;
    private int value;
    private String name;

    public Fatura(LocalDate date, int value, String name) {
        this.date = date;
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }
}
