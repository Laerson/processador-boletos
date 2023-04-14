import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.*;

public class BoletoTest {

    @Test
    //Value must be positive
    public void nonPositiveValue() {
        new Boleto(String code, LocalDate date, int value);
        assertThatThrownBy(() -> new Boleto("123", LocalDate.now(), -1_00))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Value must be positive");

        assertThatThrownBy(() -> new Boleto("123", LocalDate.now(), 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Value must be positive");

    }
}