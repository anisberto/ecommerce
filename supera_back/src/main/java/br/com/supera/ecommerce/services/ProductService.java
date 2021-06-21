package br.com.supera.ecommerce.services;

import br.com.supera.ecommerce.dto.ProductDTO;
import br.com.supera.ecommerce.entities.Product;
import br.com.supera.ecommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public List<ProductDTO> getAllProducts() {
        List<Product> listProduct = productRepository.findAll();
        return listProduct
                .stream().map(productDTO -> new ProductDTO(productDTO))
                .collect(Collectors
                        .toList());
    }

    @Transactional
    public ProductDTO getProductById(Long id) {
        Product product = productRepository.findById(id).get();
        return new ProductDTO(product);
    }

    @Transactional
    public Product save(Product product) {
        return productRepository.save(product);
    }
}
