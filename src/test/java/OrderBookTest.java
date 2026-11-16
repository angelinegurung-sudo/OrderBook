import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
        Order buyOrderA = new Order("Buy", "13456", 50.00, 1, OrderType.LIMIT);
        Order buyOrderB = new Order("Buy", "14567", 50.00, 1, OrderType.LIMIT);
        Order buyOrderC = new Order("Buy", "15678", 50.00, 1, OrderType.LIMIT);

        orderBook.addOrder(buyOrderA);
        orderBook.addOrder(buyOrderB);
        orderBook.addOrder(buyOrderC);

        Order sellOrder = new Order("Sell", "34567", 50.00, 2, OrderType.LIMIT);
        orderBook.addOrder(sellOrder);

        orderBook.matchOrders();
        assertFalse(orderBook.hasOrder("13456"));
        assertFalse(orderBook.hasOrder("14567"));
        assertTrue(orderBook.hasOrder("15678"));

    }

  @Test
  public void marketBuyTakesCheapestSellsFirst() {

      OrderBook orderBook = new OrderBook();

      Double[] prices = {24.00,26.00,40.00,28.00,30.00,32.00,34.00,36.00,38.00,22.00};
      for ( Double price : prices ) {
          orderBook.addOrder(new Order("Sell", "orderId" + price, price, 2, OrderType.LIMIT));
      }

      Order marketBuy = new Order("BUY", "buy0000", 0.0, 18, OrderType.MARKET);

      orderBook.addOrder(marketBuy);

      assertTrue(orderBook.hasOrder("orderId40.0")); //note to self the double 40.00 turns to 40.0 into strings/text
      assertFalse(orderBook.hasOrder("orderId26.0"));
      assertFalse(orderBook.hasOrder("orderId22.0"));
      assertEquals(0, marketBuy.quantity);


  }

}
