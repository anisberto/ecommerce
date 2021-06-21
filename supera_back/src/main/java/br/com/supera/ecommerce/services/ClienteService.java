package br.com.supera.ecommerce.services;

import br.com.supera.ecommerce.entities.Cliente;
import br.com.supera.ecommerce.repositories.ClienteRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRespository clienteRespository;

    @GetMapping
    public List<Cliente> getAllCliente(){
        return clienteRespository.findAll();
    }
    @PostMapping
    public Cliente saveCliente(@RequestBody Cliente cliente){
        return clienteRespository.save(cliente);
    }
}
