
public class Order {

    String side;
    String orderId;
    Double price;
    int quantity;
    long arrivalOrder;
    OrderType orderType;

    public Order(String side, String orderId, Double price, int quantity, OrderType orderType) {
        this.side = side;
        this.orderId = orderId;
        this.price = price;
        this.quantity = quantity;
        this.orderType = orderType;

    }
}
