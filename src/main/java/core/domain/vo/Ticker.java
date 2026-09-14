package core.domain.vo;

import java.util.Objects;

public record Ticker( String symbol){

    public Ticker (String symbol){
        Objects.requireNonNull(symbol, "Valor nao pode ser nulo.");
        if (symbol.isBlank()) {
            throw new IllegalArgumentException("O símbolo do ticker não pode estar vazio.");
        }
        this.symbol = symbol.toUpperCase();
        }

}
