import org.junit.jupiter.api.Test;
import org.example.Boleto;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.*;

public class BoletoTest {

    @Test
    //Value must be positive
    public void nonPositiveValue() {
        assertThatThrownBy(() -> new Boleto("123", LocalDate.now(), -1_00))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Value must be positive");

        assertThatThrownBy(() -> new Boleto("123", LocalDate.now(), 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Value must be positive");

    }

    @Test
    //Id can`t be empty
    public void emptyId() {
        assertThatThrownBy(() -> new Boleto("", LocalDate.now(), 1_00))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Id can`t be empty");

        assertThatThrownBy(() -> new Boleto(null, LocalDate.now(), 1_00))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Id can`t be empty");
    }

    @Test
    //Two boletos with same id are equal
    public void sameId() {
        Boleto boleto1 = new Boleto("123", LocalDate.now(), 1_00);
        Boleto boleto2 = new Boleto("123", LocalDate.now(), 1_00);
        assertThat(boleto1).isEqualTo(boleto2);
    }
}
