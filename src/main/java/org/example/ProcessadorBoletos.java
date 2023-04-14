package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProcessadorBoletos {
    public static List<Pagamento> process(List<Boleto> boletos, Fatura fatura) {

        List<Pagamento> pagamentos = new ArrayList<>();
        if (boletos == null || boletos.isEmpty()) {
            throw new IllegalArgumentException("List of boletos can`t be empty");
        }

        if (fatura == null) {
            throw new IllegalArgumentException("Fatura can`t be null");
        }

        for (Boleto boleto : boletos) {
            Pagamento pagamento = new Pagamento(boleto.getValue(), fatura, LocalDate.now(), "BOLETO");
            pagamentos.add(pagamento);
        }

        if (pagamentos.stream().mapToInt(Pagamento::getValue).sum() >= fatura.getValue()) {
            fatura.setPaid();
        }

        return pagamentos;
    }
}
