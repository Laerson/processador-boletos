package org.example;

import java.time.LocalDate;

public class Fatura {
    final private LocalDate date;
    final private int value;
    final private String name;

    private boolean isPaid = false;



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

        if (!name.matches("[a-zA-Z ]+")) {
            throw new IllegalArgumentException("Name can only contain letters");
        }
        this.date = date;
        this.value = value;
        this.name = name;
    }

    public Fatura(String name, int value) {
        this(LocalDate.now(), value, name);
    }

    public int getValue() {
        return value;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid() {
        isPaid = true;
    }
}
