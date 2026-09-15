package core.domain.vo;

import core.domain.BuyOrder;

public sealed interface TradingOrder permits BuyOrder, SellOrder {
    Quantity quantity();
    Money price();
}