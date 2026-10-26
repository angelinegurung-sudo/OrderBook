
import java.util.HashMap;
import java.util.PriorityQueue;

public class OrderBook {
   private HashMap<String, Order> orders;
   private PriorityQueue<Order> asks;
   private PriorityQueue<Order> bids;
   private long counter;

   public OrderBook() {
       this.orders = new HashMap<>();
       this.asks = new PriorityQueue<>((o1, o2) -> {
           int result = Double.compare(o1.price, o2.price);
           if (result != 0) {
               return result;
           } else {
               return Long.compare(o1.arrivalOrder, o2.arrivalOrder);
           }
       });
       this.bids = new PriorityQueue<>((o1, o2) -> {
           int result = Double.compare(o2.price, o1.price);
           if ( result != 0 ) {
               return result;
           } else {
               return Long.compare(o1.arrivalOrder, o2.arrivalOrder);
           }
       });
   }

   public void addOrder (Order order) {

       orders.put(order.orderId, order);

       order.arrivalOrder = counter;
       counter++;

       if (order.side.equalsIgnoreCase("BUY")) {
           bids.add(order);
       } else {
           asks.add(order);
       }
   }

   public boolean hasOrder(String orderId) {

       return orders.containsKey(orderId);
   }


       public void matchOrders() {

           boolean tradeHappened = false;

           while (!bids.isEmpty() && !asks.isEmpty() && bids.peek().price >= asks.peek().price) {

               tradeHappened = true;
               Order bestBid = bids.peek();
               Order bestAsk = asks.peek();

               int tradedQty = Math.min(bestBid.quantity, bestAsk.quantity);
               bestBid.quantity -= tradedQty;
               bestAsk.quantity -= tradedQty;

               if (bestBid.quantity == 0) {
                   bids.poll();
                   orders.remove(bestBid.orderId);
               }
               if (bestAsk.quantity == 0) {
                   asks.poll();
                   orders.remove(bestAsk.orderId);

               }


               System.out.println("MATCH: Traded " + tradedQty + "shares at price: " + bestAsk.price);
           }
           if (!tradeHappened) {
               System.out.println("NO MATCH AT THE MOMENT");
       }
   }


   }

