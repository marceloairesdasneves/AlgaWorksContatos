package core.domain.vo;

// @author Marcelo Neves

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class TickerTest {

    @Test
    public void validarSymbolEmBranco(){
        assertThrows(IllegalArgumentException.class, () ->
                new Ticker(" "));
    }

    @Test
    public void validarSymbolNull(){
        assertThrows(NullPointerException.class, () ->
                new Ticker(null));
    }

    @Test
    public void deveConverterSymbolParaCaixaAlta(){
        Ticker ticker = new Ticker("petr4");
        assertEquals("PETR4", ticker.symbol());
    }

}
