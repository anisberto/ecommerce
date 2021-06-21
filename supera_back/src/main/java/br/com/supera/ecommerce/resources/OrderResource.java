package br.com.supera.ecommerce.resources;

import br.com.supera.ecommerce.dto.OrderDTO;
import br.com.supera.ecommerce.entities.Order;
import br.com.supera.ecommerce.services.OrderService;
import br.com.supera.ecommerce.utilities.CalculoDeFrete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/pedido")
public class OrderResource {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderDTO>> findAll() {
        if (orderService.findAll().isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok().body(orderService.findAll());
    }

    @PostMapping
    public ResponseEntity<Order> insert(@RequestBody Order order) {
        order.setShipping(CalculoDeFrete.calcularFrete(order));
        order = orderService.insert(order);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(order.getId()).toUri();
        return ResponseEntity.created(uri).body(order);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderDTO> put(@PathVariable Long id) {
        return ResponseEntity.ok().body(orderService.setDelivered(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(orderService.findById(id));
    }
}
