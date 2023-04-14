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

    //equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Boleto boleto = (Boleto) o;
        return id.equals(boleto.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
