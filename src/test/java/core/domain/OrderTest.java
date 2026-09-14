package core.domain;

// @author Marcelo Neves

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class OrderTest {
    @Test
    public void validarTodosParaNaoPassarNulo(){
        assertThrows(NullPointerException.class, () ->
                new Order(null, null, null, null, null, null));

    }
}
