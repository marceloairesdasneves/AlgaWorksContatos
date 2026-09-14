package core.domain;

import core.domain.enums.OrderType;
import core.domain.vo.AccountId;
import core.domain.vo.Money;
import core.domain.vo.Quantity;
import core.domain.vo.Ticker;

import java.util.Objects;
import java.util.UUID;

public record Order(UUID id, AccountId accountId, Ticker ticker, Money money, OrderType orderType, Quantity quantity) {
    public Order {
        Objects.requireNonNull(id, "ID não pode ser nulo.");
        Objects.requireNonNull(accountId, "AccountId não pode ser nulo.");
        Objects.requireNonNull(ticker, "Ticker não pode ser nulo.");
        Objects.requireNonNull(money, "Money não pode ser nulo.");
        Objects.requireNonNull(orderType, "OrderType não pode ser nulo.");
        Objects.requireNonNull(quantity, "Quantity não pode ser nulo.");
    }
}
