import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @Test
    public void earliestArrivalTradesFirst() {
        OrderBook orderBook = new OrderBook();
        Order buyOrderA = new Order("Buy","13456", 50.00, 1 );
        Order buyOrderB = new Order("Buy","14567", 50.00, 1 );
        Order buyOrderC = new Order("Buy","15678", 50.00, 1 );

        orderBook.addOrder(buyOrderA);
        orderBook.addOrder(buyOrderB);
        orderBook.addOrder(buyOrderC);

        Order sellOrder = new Order("Sell", "34567", 50.00, 2);
        orderBook.addOrder(sellOrder);

        orderBook.matchOrders();
        assertFalse(orderBook.hasOrder("13456"));
        assertFalse(orderBook.hasOrder("14567"));
        assertTrue(orderBook.hasOrder("15678"));



    }

}
