import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class OrderBookTest {

@Test
    public void matchingOrdersRemovedFromBook() {
       Order buyOrder = new Order("Buy", "12345", 50.00, 2);
       Order sellOrder = new Order("Sell", "23456", 50.00, 2);

       OrderBook orderBook = new OrderBook();
       orderBook.addOrder(buyOrder);
       orderBook.addOrder(sellOrder);

       orderBook.matchOrders();
       assertFalse(orderBook.hasOrder("12345"));
       assertFalse(orderBook.hasOrder("23456"));
    }

}
