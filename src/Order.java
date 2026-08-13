public class Order {

    String side;
    String orderId;
    Double price;
    int quantity;

    public Order(String side, String orderId, Double price, int quantity) {
        this.side = side;
        this.orderId = orderId;
        this.price = price;
        this.quantity = quantity;
    }
}
