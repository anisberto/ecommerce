package br.com.supera.ecommerce.entities;

import br.com.supera.ecommerce.enumerations.OrderStatus;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "pedido")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    private String address;
    private Instant moment;
    private OrderStatus status;
    private double total;
    private Double shipping;

    @ManyToMany()
    @JoinTable(name = "tb_order_product",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Set<Product> products = new HashSet<>();

    public Order(Long id, String address, double shipping, Instant moment, OrderStatus status) {
        this.id = id;
        this.address = address;
        this.moment = moment;
        this.status = status;
        this.shipping = shipping;
    }
    public Order(){}

}
