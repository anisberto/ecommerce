package br.com.supera.ecommerce.dto;

import br.com.supera.ecommerce.entities.Order;
import br.com.supera.ecommerce.enumerations.OrderStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class OrderDTO {
    private static final long serialVersionUID = 1L;

    private long id;
    private String address;
    private Instant moment;
    private OrderStatus status;
    private Double total;
    private Double shipping;
    private List<ProductDTO> products = new ArrayList<>();

    public OrderDTO(long id, String address, Instant moment, double shipping, OrderStatus status, Double total) {
        this.id = id;
        this.address = address;
        this.moment = moment;
        this.status = status;
        this.total = total;
        this.shipping = shipping;
    }

    public OrderDTO(){}

    public OrderDTO(Order order) {
        this.id = order.getId();
        this.address = order.getAddress();
        this.moment = order.getMoment();
        this.status = order.getStatus();
        this.total = order.getTotal();
        this.shipping = order.getShipping();
        products = order.getProducts().stream().map(productsOnList -> new ProductDTO(productsOnList))
                .collect(Collectors.toList());
    }
}
