package br.com.supera.ecommerce.repositories;

import br.com.supera.ecommerce.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("SELECT DISTINCT obj FROM Order obj JOIN FETCH obj.products " +
            "WHERE obj.status = 0 ORDER BY obj.moment ASC")
    List<Order> findOrderWithProducts();

}
