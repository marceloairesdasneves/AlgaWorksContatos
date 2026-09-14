package core.domain;

import core.domain.enums.OrderType;
import core.domain.vo.*;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderBookTest {
    @Test
    public void devePriorizarMaiorPrecoNaCompra() {
        OrderBook book = new OrderBook();
        var baixa = createOrder(BigDecimal.valueOf(10.0), OrderType.BUY, 100);
        var alta  = createOrder(BigDecimal.valueOf(12.5), OrderType.BUY, 100);

        book.add(baixa);
        book.add(alta);

        assertEquals(alta.id(), book.peekBuy().id());
    }

    @Test
    void devePriorizarMenorPrecoNaVenda() {
        OrderBook book = new OrderBook();
        var cara   = createOrder(BigDecimal.valueOf(15.0), OrderType.SELL, 100);
        var barata = createOrder(BigDecimal.valueOf(12.0), OrderType.SELL, 100);

        book.add(cara);
        book.add(barata);

        assertEquals(barata.id(), book.peekSell().id());
    }
    private Order createOrder(BigDecimal price, OrderType type, int quantity) {
        return new Order(
                java.util.UUID.randomUUID(),
                new AccountId(java.util.UUID.randomUUID()),
                new Ticker("PETR4"),
                new Money(BigDecimal.valueOf(price.doubleValue())),
                type,
                new Quantity(quantity)
        );
    }

    @Test
    void deveRealizarMatchQuandoPrecoCompraMaiorOuIgualVenda() {
        OrderBook book = new OrderBook();
        var compra = createOrder(BigDecimal.valueOf(15.0), OrderType.BUY, 100);
        var venda  = createOrder(BigDecimal.valueOf(12.0), OrderType.SELL, 100);

        book.add(compra);
        book.add(venda);

        book.match();

        org.junit.jupiter.api.Assertions.assertTrue(book.isBuyQueueEmpty());
        org.junit.jupiter.api.Assertions.assertTrue(book.isSellQueueEmpty());
    }
}