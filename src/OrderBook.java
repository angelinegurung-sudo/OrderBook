import java.util.HashMap;
import java.util.PriorityQueue;

public class OrderBook {
   private HashMap<String, Order> orders;
   private PriorityQueue<Order> asks;
   private PriorityQueue<Order> bids;

   public OrderBook() {
       this.orders = new HashMap<>();
       this.asks = new PriorityQueue<Order> asks = new PriorityQueue<>((o1, o2) -> Double.compare(o1.price, o2.price));
       this.bids = new PriorityQueue<Order> bids = new PriorityQueue<>((o1, o2) -> Double.compare(o2.price, o1.price));

   }

   public void addOrder (Order order) {

       orders.put(Order.orderId, order);

       if (order.side.equalsIgnoreCase("BUY")) {
           bids.add(order);
       } else {
           asks.add(order);
       }
   }


       public void matchOrders() {


           while (!bids.isEmpty() && !asks.isEmpty() && bids.peek().price >= agit sks.peek().price) {
               Order bestBid = bids.peek();
               Order bestAsk = asks.peek();

               system.out.println("MATCH");
           }
           system.out.println("NO MATCH");

   }
   }

