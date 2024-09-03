package MODEL;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Order implements Serializable {
    private final int OrderId;
    private final int ClientId;
    private final LocalDateTime orderDate;
    private static int i=0;

    public Order(int clientId, LocalDateTime orderDate) {
        i++;
        OrderId = i;
        ClientId = clientId;
        this.orderDate = orderDate;
    }

    public int getOrderId() {
        return OrderId;
    }

    public int getClientId() {
        return ClientId;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    @Override
    public String toString() {
        return "Order :" + OrderId +
                " for Client " + ClientId +
                " " + orderDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
    }
}
