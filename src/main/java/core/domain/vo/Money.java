package core.domain.vo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public record Money(BigDecimal amount) {

    public Money(BigDecimal amount){
        Objects.requireNonNull(amount, "Nao e permitido valores nulos.");

        if (amount.compareTo(BigDecimal.ZERO) < 0){
            throw new IllegalArgumentException("Nao e permitido valores negativos.");
        }
        this.amount = amount.setScale(4, RoundingMode.HALF_EVEN);
    }

}
