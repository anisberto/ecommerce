package br.com.supera.ecommerce.repositories;

import br.com.supera.ecommerce.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRespository extends JpaRepository<Cliente, Long> {
}
