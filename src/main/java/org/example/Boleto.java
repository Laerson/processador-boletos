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
        this.id = id;
        this.date = date;
        this.value = value;
    }
}
