package core.domain.vo;

// @author Marcelo Neves

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class QuantityTest {
    @Test
    public void validarExcecoesDeValoresNegativos(){
        assertThrows(IllegalArgumentException.class, () ->
                new Quantity(-1));
    }

    @Test
    public void validarExcecoesDeValorIgualAZero(){
        assertThrows(IllegalArgumentException.class, () ->
                new Quantity(0));

    }

    @Test
    public void validaValorPositivo(){
        Quantity quantity = new Quantity(100);
        assertEquals(100, quantity.ativos());
    }
}
