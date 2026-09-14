package core.domain.vo;// @author Marcelo Neves

import org.junit.Test;

import java.math.BigDecimal;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class MoneyTest {

    @Test
    public void deveLancarExcecaoQuandoValorForNegativo(){
        BigDecimal valorNegativo = new BigDecimal("-100.00");

        assertThrows(IllegalArgumentException.class, () -> {
           new Money(valorNegativo);
        });
    }

    @Test
    public void deveArredondarEConfigurarEscalaCorretamente(){

        BigDecimal valorBruto = new BigDecimal("10.56789");
        Money money = new Money(valorBruto);

        assertEquals(0, new BigDecimal("10.5679").compareTo(money.amount()));
    }

}
