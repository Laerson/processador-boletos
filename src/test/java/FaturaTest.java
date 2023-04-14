import org.example.Fatura;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;


import java.time.LocalDate;

public class FaturaTest {

    @Test
    //Values can`t be negative
    public void negativeValue() {
        assertThatThrownBy(() -> new Fatura(LocalDate.now(), -1_00, "Laerson Saraiva Verissimo"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Value can`t be negative");
    }
}
