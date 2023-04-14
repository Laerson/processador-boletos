package org.example;

import java.time.LocalDate;

public class Fatura {
    private LocalDate date;
    private int value;
    private String name;

    public Fatura(LocalDate date, int value, String name) {
        if (value < 0) {
            throw new IllegalArgumentException("Value can`t be negative");
        }
        if (value == 0) {
            throw new IllegalArgumentException("Value can`t be zero");
        }

        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name can`t be empty");
        }

        if (name == null) {
            throw new IllegalArgumentException("Name can`t be null");
        }
        this.date = date;
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }
}
