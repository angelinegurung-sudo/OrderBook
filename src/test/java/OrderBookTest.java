import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrderBookTest {

@Test
    public void matchingOrdersRemovedFromBook() {
       Order buyOrder = new Order("Buy", "12345", 50.00, 2, OrderType.LIMIT);
       Order sellOrder = new Order("Sell", "23456", 50.00, 2, OrderType.LIMIT);

       OrderBook orderBook = new OrderBook();
       orderBook.addOrder(buyOrder);
       orderBook.addOrder(sellOrder);

       orderBook.matchOrders();
       assertFalse(orderBook.hasOrder("12345"));
       assertFalse(orderBook.hasOrder("23456"));


    }

    @Test
    public void earliestArrivalTradesFirst() {
        OrderBook orderBook = new OrderBook();
        Order buyOrderA = new Order("Buy","13456", 50.00, 1, OrderType.LIMIT );
        Order buyOrderB = new Order("Buy","14567", 50.00, 1, OrderType.LIMIT );
        Order buyOrderC = new Order("Buy","15678", 50.00, 1, OrderType.LIMIT  );

        orderBook.addOrder(buyOrderA);
        orderBook.addOrder(buyOrderB);
        orderBook.addOrder(buyOrderC);

        Order sellOrder = new Order("Sell", "34567", 50.00, 2, OrderType.LIMIT );
        orderBook.addOrder(sellOrder);

        orderBook.matchOrders();
        assertFalse(orderBook.hasOrder("13456"));
        assertFalse(orderBook.hasOrder("14567"));
        assertTrue(orderBook.hasOrder("15678"));



    }

}
