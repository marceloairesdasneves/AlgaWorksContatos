package core.domain;

import core.domain.enums.OrderType;
import java.util.Comparator;
import java.util.PriorityQueue;

public class OrderBook {
    private final PriorityQueue<Order> buyQueue = new PriorityQueue<>(
            Comparator.comparing(o -> o.money().amount(), Comparator.reverseOrder())
    );
    final PriorityQueue<Order> sellQueue = new PriorityQueue<>(
            Comparator.comparing(o -> o.money().amount())
    );

    public void add(Order order) {
        if (order.orderType() == OrderType.BUY) {
            buyQueue.add(order);
        } else {
            sellQueue.add(order);
        }
    }

    public boolean isBuyQueueEmpty() {
        return buyQueue.isEmpty();
    }

    public Order peekBuy() {
        return buyQueue.peek();
    }

    public Order peekSell() {
        return sellQueue.peek();
    }

    public void match() {
        if (!buyQueue.isEmpty() && !sellQueue.isEmpty()) {
            Order bestBuy = buyQueue.peek();
            Order bestSell = sellQueue.peek();

            if (bestBuy.money().amount().compareTo(bestSell.money().amount()) >= 0) {
                buyQueue.poll();
                sellQueue.poll();
            }
        }
    }

    public boolean isSellQueueEmpty() {
        return sellQueue.isEmpty();
    }
}