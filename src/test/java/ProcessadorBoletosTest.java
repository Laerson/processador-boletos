import org.junit.jupiter.api.Test;
import org.example.Boleto;
import org.example.Fatura;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
public class ProcessadorBoletosTest {

    @Test
    //List of boletos can`t be empty
    public void emptyBoletos() {
        ProcessadorBoletos.process(boletos, fatura);
    }
}
