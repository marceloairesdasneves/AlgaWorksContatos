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
        var accountId = new AccountId(UUID.randomUUID());
        var ticker = new Ticker("PETR4");

        var baixa = new Order(UUID.randomUUID(), accountId, ticker, new Money(BigDecimal.valueOf(10.0)), OrderType.BUY, new Quantity(100));
        var alta  = new Order(UUID.randomUUID(), accountId, ticker, new Money(BigDecimal.valueOf(12.5)), OrderType.BUY, new Quantity(100));
        book.add(baixa);
        book.add(alta);

        assertEquals(alta.id(), book.peekBuy().id());
    }

    @Test
    void devePriorizarMenorPrecoNaVenda() {
        OrderBook book = new OrderBook();
        var accountId = new AccountId(java.util.UUID.randomUUID());
        var ticker = new Ticker("PETR4");

        var cara   = new Order(java.util.UUID.randomUUID(), accountId, ticker, new Money(BigDecimal.valueOf(15.0)), OrderType.SELL, new Quantity(100));
        var barata = new Order(java.util.UUID.randomUUID(), accountId, ticker, new Money(BigDecimal.valueOf(12.0)), OrderType.SELL, new Quantity(100));

        book.add(cara);
        book.add(barata);

        assertEquals(barata.id(), book.peekSell().id());
    }

    @Test
    void deveRealizarMatchQuandoPrecoCompraMaiorOuIgualVenda() {
        OrderBook book = new OrderBook();
        var accountId = new AccountId(java.util.UUID.randomUUID());
        var ticker = new Ticker("PETR4");

        var compra = new Order(java.util.UUID.randomUUID(), accountId, ticker, new Money(BigDecimal.valueOf(15.0)), OrderType.BUY, new Quantity(100));
        var venda  = new Order(java.util.UUID.randomUUID(), accountId, ticker, new Money(BigDecimal.valueOf(12.0)), OrderType.SELL, new Quantity(100));

        book.add(compra);
        book.add(venda);

        book.match();

        org.junit.jupiter.api.Assertions.assertTrue(book.isBuyQueueEmpty());
        org.junit.jupiter.api.Assertions.assertTrue(book.isSellQueueEmpty());
   }

}