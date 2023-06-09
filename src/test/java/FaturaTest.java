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

    @Test
    //Values can`t be zero
    public void zeroValue() {
        assertThatThrownBy(() -> new Fatura(LocalDate.now(), 0, "Laerson Saraiva Verissimo"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Value can`t be zero");
    }

    @Test
    //Name can`t be empty
    public void emptyName() {
        assertThatThrownBy(() -> new Fatura(LocalDate.now(), 1_00, ""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Name can`t be empty");
    }

    @Test
    //Name can only contain letters
    public void nameWithNumbers() {
        assertThatThrownBy(() -> new Fatura(LocalDate.now(), 1_00, "Laerson 123"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Name can only contain letters");
    }
}
