import org.junit.jupiter.api.Test;
import org.example.*;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.*;


public class PagamentoTest {

        @Test
        //Value must be positive
        public void nonPositiveValue() {
            assertThatThrownBy(() -> new Pagamento(-1_00, new Fatura("Laerson", 1_00), LocalDate.now(), "Boleto"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("Value must be positive");

            assertThatThrownBy(() -> new Pagamento(0, new Fatura("Laerson", 1_00), LocalDate.now(), "Boleto"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("Value must be positive");

        }

        @Test
        //Fatura can`t be null
        public void nullFatura() {
            assertThatThrownBy(() -> new Pagamento(1_00, null, LocalDate.now(), "Boleto"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("Fatura can`t be null");

        }

        @Test
        //Date can`t be null
        public void nullDate() {
            assertThatThrownBy(() -> new Pagamento(1_00, new Fatura("Jose Rico", 1_00), null, "Boleto"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("Date can`t be null");

        }

        @Test
        //Type can`t be empty
        public void emptyType() {
            assertThatThrownBy(() -> new Pagamento(1_00, new Fatura("Laerson", 1_00), LocalDate.now(), ""))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("Type can`t be empty");

            assertThatThrownBy(() -> new Pagamento(1_00, new Fatura("Laerson", 1_00), LocalDate.now(), null))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("Type can`t be empty");

        }

}
