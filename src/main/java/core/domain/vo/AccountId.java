package core.domain.vo;


import java.util.Objects;
import java.util.UUID;

public record AccountId(UUID id) {
    public AccountId{
        Objects.requireNonNull(id, "O identificador da conta não pode ser nulo.");
    }

    public static AccountId novo(){
        return new AccountId(UUID.randomUUID());
    }
}
