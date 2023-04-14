package org.example;

import java.time.LocalDate;

public class Pagamento {
    private final int value;
    private final Fatura fatura;

    private final LocalDate date;

    private final String type;

    public Pagamento(int value, Fatura fatura, LocalDate date, String type) {
        if (value <= 0) {
            throw new IllegalArgumentException("Value must be positive");
        }

        if (fatura == null) {
            throw new IllegalArgumentException("Fatura can`t be null");
        }

        if (date == null) {
            throw new IllegalArgumentException("Date can`t be null");
        }

        if (type == null || type.isEmpty()) {
            throw new IllegalArgumentException("Type can`t be empty");
        }


        this.value = value;
        this.fatura = fatura;
        this.date = date;
        this.type = type;
    }

    public int getValue() {
        return value;
    }

    public Fatura getFatura() {
        return fatura;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getType() {
        return type;
    }
}
