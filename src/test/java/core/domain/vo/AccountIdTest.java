package core.domain.vo;

// @author Marcelo Neves

import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class AccountIdTest {
    @Test
    public void validarSeIdENulo(){
        assertThrows(NullPointerException.class, () ->
                new AccountId(null));
    }

    @Test
    public void deveCriarAccountIdComSucesso(){
        UUID uuid = UUID.randomUUID();
        AccountId accountId = new AccountId(uuid);
        assertEquals(uuid, accountId.id());
    }

}
