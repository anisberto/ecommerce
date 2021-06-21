package br.com.supera.ecommerce.resources;

import br.com.supera.ecommerce.entities.Cliente;
import br.com.supera.ecommerce.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteResource {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> getAllCliente(){
        return ResponseEntity.ok().body(clienteService.getAllCliente());
    }
    @PostMapping
    public ResponseEntity<Cliente> saveCliente(@RequestBody Cliente cliente){
        return ResponseEntity.ok().body(clienteService.saveCliente(cliente));
    }
}
