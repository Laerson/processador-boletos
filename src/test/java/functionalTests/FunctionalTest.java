package functionalTests;

import org.example.Boleto;
import org.example.Fatura;
import org.example.Pagamento;
import org.example.ProcessadorBoletos;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class FunctionalTest {

    //Condition set 1:
    // Sum of boletos greater than fatura value
    // Fatura value greater than or equal to zero
    // All Boletos have positive value

    //Actions:
    //Change Fatura isPaid to true
    //Generate Pagamento for each Boleto

    @Test
    public void conditionSet1() {
        //Arrange
        Fatura fatura = new Fatura(LocalDate.now(), 1_00, "Laerson Saraiva Verissimo");
        List<Boleto> boletos = new ArrayList<>();
        boletos.add(new Boleto("123", LocalDate.now(), 1_00));
        boletos.add(new Boleto("234", LocalDate.now(), 1_00));
        boletos.add(new Boleto("345", LocalDate.now(), 1_00));

        //Act
        List<Pagamento> pagamentos = ProcessadorBoletos.process(boletos, fatura);

        //Assert
        assertThat(fatura.isPaid()).isTrue();
        assertThat(pagamentos.size()).isEqualTo(3);
    }

    //Condition set 2:
    // Sum of boletos less than fatura value
    // Fatura value greater than or equal to zero
    // All Boletos have positive value

    //Actions:
    //Check that fatura isPaid remains false
    //Generate Pagamento for each Boleto

    @Test
    public void conditionSet2() {
        //Arrange
        Fatura fatura = new Fatura(LocalDate.now(), 2_00, "Laerson Saraiva Verissimo");
        List<Boleto> boletos = new ArrayList<>();
        boletos.add(new Boleto("1234", LocalDate.now(), 50));
        boletos.add(new Boleto("1235", LocalDate.now(), 50));
        boletos.add(new Boleto("1236", LocalDate.now(), 50));

        //Act
        List<Pagamento> pagamentos = ProcessadorBoletos.process(boletos, fatura);

        //Assert
        assertThat(fatura.isPaid()).isFalse();
        assertThat(pagamentos.size()).isEqualTo(3);
    }

    //Condition set 3:
    // fatura value less than zero

    //Actions:
    //Throw correct exception

    @Test
    public void conditionSet3() {
        //Arrange
        Fatura fatura = new Fatura(LocalDate.now(), -1_00, "Laerson Saraiva Verissimo");
        List<Boleto> boletos = new ArrayList<>();
        boletos.add(new Boleto("2234", LocalDate.now(), 50));
        boletos.add(new Boleto("2235", LocalDate.now(), 50));
        boletos.add(new Boleto("2236", LocalDate.now(), 50));

        //Act
        //Assert
        assertThatThrownBy(() -> ProcessadorBoletos.process(boletos, fatura))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Value can`t be negative");
    }

    //Condition set 4:
    // fatura value greater than sum of boletos
    // fatura value greater than or equal to zero
    // there is at least one boleto with negative value

    //Actions:
    //Throw correct exception

    @Test
    public void conditionSet4() {
        //Arrange
        Fatura fatura = new Fatura(LocalDate.now(), 1_00, "Laerson Saraiva Verissimo");
        List<Boleto> boletos = new ArrayList<>();
        boletos.add(new Boleto("3234", LocalDate.now(), 50));
        boletos.add(new Boleto("3235", LocalDate.now(), 50));
        boletos.add(new Boleto("3236", LocalDate.now(), -50));

        //Act
        //Assert
        assertThatThrownBy(() -> ProcessadorBoletos.process(boletos, fatura))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Value can`t be negative");
    }

    //Condition set 5:
    // fatura value less than or equal to the sum of boletos
    // fatura value greater than or equal to zero
    // there is at least one boleto with negative value

    //Actions:
    //Throw correct exception

    @Test
    public void conditionSet5() {
        //Arrange
        Fatura fatura = new Fatura(LocalDate.now(), 50, "Laerson Saraiva Verissimo");
        List<Boleto> boletos = new ArrayList<>();
        boletos.add(new Boleto("4234", LocalDate.now(), 50));
        boletos.add(new Boleto("4235", LocalDate.now(), 50));
        boletos.add(new Boleto("4236", LocalDate.now(), -50));

        //Act
        //Assert
        assertThatThrownBy(() -> ProcessadorBoletos.process(boletos, fatura))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Value can`t be negative");
    }

    //condition set 6:
    // fatura value greater than sum of boletos
    // fatura value is less than zero
    // there is at least one boleto with negative value

    //Actions:
    //Throw correct exception

    @Test
    public void conditionSet6() {
        //Arrange
        Fatura fatura = new Fatura(LocalDate.now(), -50, "Laerson Saraiva Verissimo");
        List<Boleto> boletos = new ArrayList<>();
        boletos.add(new Boleto("5234", LocalDate.now(), -50));
        boletos.add(new Boleto("5235", LocalDate.now(), -50));
        boletos.add(new Boleto("5236", LocalDate.now(), -50));

        //Act
        //Assert
        assertThatThrownBy(() -> ProcessadorBoletos.process(boletos, fatura))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Value can`t be negative");
    }

    //condition set 7:
    // fatura value less than or equal to sum of boletos
    // fatura value is less than zero
    // there is at least one boleto with negative value

    //Actions:
    //Throw correct exception

    @Test
    public void conditionSet7() {
        //Arrange
        Fatura fatura = new Fatura(LocalDate.now(), -200, "Laerson Saraiva Verissimo");
        List<Boleto> boletos = new ArrayList<>();
        boletos.add(new Boleto("6234", LocalDate.now(), -50));
        boletos.add(new Boleto("6235", LocalDate.now(), -50));
        boletos.add(new Boleto("6236", LocalDate.now(), -50));

        //Act
        //Assert
        assertThatThrownBy(() -> ProcessadorBoletos.process(boletos, fatura))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Value can`t be negative");
    }
}
