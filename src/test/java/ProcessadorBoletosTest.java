import org.junit.jupiter.api.Test;
import org.example.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
public class ProcessadorBoletosTest {

    @Test
    //List of boletos can`t be empty
    public void emptyList() {
        assertThatThrownBy(() -> ProcessadorBoletos.process(null, new Fatura("Laerson", 1_00)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("List of boletos can`t be empty");

        assertThatThrownBy(() -> ProcessadorBoletos.process(List.of(), new Fatura("Laerson", 1_00)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("List of boletos can`t be empty");
    }

    @Test
    //Fatura can`t be null
    public void nullFatura() {
        assertThatThrownBy(() -> ProcessadorBoletos.process(List.of(new Boleto("123", LocalDate.now(), 1_00)), null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Fatura can`t be null");
    }

    @Test
    //For each boleto in list of boletos, ProcessadorBoletos.process() must return a Pagamento object with the following properties:
    //value = boleto`s value
    //fatura = fatura
    //date = LocalDate.now()
    //type = "BOLETO"
    public void process() {
        List<Boleto> boletos = new ArrayList<>();
        boletos.add(new Boleto("ABC123DEF4", LocalDate.of(2023, 4, 14), 100));
        boletos.add(new Boleto("XYZ456GHI7", LocalDate.of(2023, 4, 15), 200));
        boletos.add(new Boleto("JKL789MNO1", LocalDate.of(2023, 4, 16), 300));
        boletos.add(new Boleto("PQR234STU5", LocalDate.of(2023, 4, 17), 400));
        boletos.add(new Boleto("VWX567YZA8", LocalDate.of(2023, 4, 18), 500));
        boletos.add(new Boleto("BCD890EFG2", LocalDate.of(2023, 4, 19), 600));
        boletos.add(new Boleto("HIJ345KLM6", LocalDate.of(2023, 4, 20), 700));
        boletos.add(new Boleto("NOP678QRS9", LocalDate.of(2023, 4, 21), 800));
        boletos.add(new Boleto("TUV012WXY3", LocalDate.of(2023, 4, 22), 900));
        boletos.add(new Boleto("ZAB456CDE7", LocalDate.of(2023, 4, 23), 1000));
        Fatura fatura = new Fatura(LocalDate.now(), 5500, "Laerson Saraiva");

        List<Pagamento> pagamentos = ProcessadorBoletos.process(boletos, fatura);
        assertThat(pagamentos).hasSize(10);
        for (int i = 0; i < pagamentos.size(); i++) {
            Pagamento pagamento = pagamentos.get(i);
            Boleto boleto = boletos.get(i);
            assertThat(pagamento.getValue()).isEqualTo(boleto.getValue());
            assertThat(pagamento.getFatura()).isEqualTo(fatura);
            assertThat(pagamento.getDate()).isEqualTo(LocalDate.now());
            assertThat(pagamento.getType()).isEqualTo("BOLETO");
        }
    }

    @Test
    //If the sum of the values of each boleto is greater or equal than the fatura`s value, then fatura.isPaid() must return true
    //else it must return false
    public void faturaGreaterThanBoletos() {
        List<Boleto> boletos = new ArrayList<>();
        boletos.add(new Boleto("ABC123DEF4", LocalDate.of(2023, 4, 14), 100));
        boletos.add(new Boleto("XYZ456GHI7", LocalDate.of(2023, 4, 15), 200));
        boletos.add(new Boleto("JKL789MNO1", LocalDate.of(2023, 4, 16), 300));
        Fatura fatura = new Fatura(LocalDate.now(), 5500, "Laerson Saraiva");
        ProcessadorBoletos.process(boletos, fatura);
        assertThat(fatura.isPaid()).isFalse();

        List<Boleto> boletos2 = new ArrayList<>();
        boletos2.add(new Boleto("ABC123DEF5", LocalDate.of(2023, 4, 14), 100));
        boletos2.add(new Boleto("XYZ456GHI8", LocalDate.of(2023, 4, 15), 200));
        boletos2.add(new Boleto("JKL789MNOG", LocalDate.of(2023, 4, 16), 300));
        Fatura fatura2 = new Fatura(LocalDate.now(), 600, "Laerson Saraiva");
        ProcessadorBoletos.process(boletos2, fatura2);
        assertThat(fatura2.isPaid()).isTrue();

    }

}
