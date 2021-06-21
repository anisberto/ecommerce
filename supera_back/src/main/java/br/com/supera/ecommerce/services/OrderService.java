package br.com.supera.ecommerce.services;

import br.com.supera.ecommerce.dto.OrderDTO;
import br.com.supera.ecommerce.dto.ProductDTO;
import br.com.supera.ecommerce.entities.Order;
import br.com.supera.ecommerce.enumerations.OrderStatus;
import br.com.supera.ecommerce.repositories.OrderRepository;
import br.com.supera.ecommerce.repositories.ProductRepository;
import br.com.supera.ecommerce.utilities.CalculoDeFrete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public List<OrderDTO> findAll() {
        List<Order> list = orderRepository.findOrderWithProducts();
        return list.stream().map(orderIntListDTO -> new OrderDTO(orderIntListDTO)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public OrderDTO findById(Long id) {
        return new OrderDTO(orderRepository.getOne(id));
    }

    @Transactional
    public Order insert(Order order) {
        order.setMoment(Instant.now());
        order.setStatus(OrderStatus.PENDING);
         order = orderRepository.save(order);
        return order;
    }

    @Transactional
    public OrderDTO setDelivered(Long id) {
        Order order = orderRepository.getOne(id);
        order.setStatus(OrderStatus.DELIVERED);
        order = orderRepository.save(order);
        return new OrderDTO(order);
    }

}
