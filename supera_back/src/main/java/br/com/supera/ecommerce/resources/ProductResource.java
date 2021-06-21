package br.com.supera.ecommerce.resources;

import br.com.supera.ecommerce.dto.ProductDTO;
import br.com.supera.ecommerce.entities.Order;
import br.com.supera.ecommerce.entities.Product;
import br.com.supera.ecommerce.services.ProductService;
import br.com.supera.ecommerce.utilities.CalculoDeFrete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProductResource {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<?> findAll() {
        List<ProductDTO> allProducts = productService.getAllProducts();
        if (allProducts.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok().body(allProducts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable Long id) {
        ProductDTO productDTO = productService.getProductById(id);
        return ResponseEntity.ok().body(productDTO);
    }

    @PostMapping
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        product.setPrice(Double.parseDouble(product.getPrice().toString()));
        return ResponseEntity.ok().body(productService.save(product));
    }
}
