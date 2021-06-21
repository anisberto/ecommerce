package br.com.supera.ecommerce.repositories;

import br.com.supera.ecommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository  extends JpaRepository<Product, Long> {
    @Query("SELECT p FROM Product p where p.name = :name")
    List<Product> findByName(@Param("name") String name);

    @Query("SELECT p FROM Product p where p.name LIKE CONCAT('%',:name,'%')")
    List<Product> findByNameContaining(@Param("name") String name);

}
