package org.example;

import java.time.LocalDate;

public class Boleto {
    String id;
    LocalDate date;
    int value;

    public Boleto(String id, LocalDate date, int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("Value must be positive");
        }
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("Id can`t be empty");
        }
        this.id = id;
        this.date = date;
        this.value = value;
    }
}
