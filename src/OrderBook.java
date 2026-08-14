import java.util.HashMap;
import java.util.PriorityQueue;

public class OrderBook {
   private HashMap<String, Order> orders;
   private PriorityQueue<Order> asks;
   private PriorityQueue<Order> bids;

   public OrderBook() {
       this.orders = new HashMap<>();
       this.asks = new PriorityQueue<>((o1, o2) -> Double.compare(o1.price, o2.price));
       this.bids = new PriorityQueue<>((o1, o2) -> Double.compare(o2.price, o1.price));

   }

   public void addOrder (Order order) {

       orders.put(order.orderId, order);

       if (order.side.equalsIgnoreCase("BUY")) {
           bids.add(order);
       } else {
           asks.add(order);
       }
   }


       public void matchOrders() {
           while (!bids.isEmpty() && !asks.isEmpty() && bids.peek().price >= asks.peek().price) {
               Order bestBid = bids.peek();
               Order bestAsk = asks.peek();

              int tradedQty = Math.min(bestBid.quantity, bestAsk.quantity);
              bestBid.quantity -= tradedQty;
              bestAsk.quantity -= tradedQty;

              if (bestBid.quantity == 0) {
                  bids.poll();
                  orders.remove(bestBid.orderId);
              } if (bestAsk.quantity == 0) {
                  asks.poll();
                  orders.remove(bestAsk.orderId);

              }


               System.out.println("MATCH: Traded " + tradedQty + "shares at price: " + bestAsk.price);
           }
           System.out.println("NO MATCH AT THE MOMENT");

   }
   }

