package br.com.supera.ecommerce.dto;

import br.com.supera.ecommerce.entities.Product;
import lombok.Data;

@Data
public class ProductDTO {

    private static final long serialVersionUID = 1L;
    private long id;
    private String name;
    private double price;
    private String score;
    private String imageUri;

    public ProductDTO() {
    }

    public ProductDTO(long id, String name, double price, String score, String imageUri) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.score = score;
        this.imageUri = imageUri;
    }

    public ProductDTO(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
        this.score = product.getScore();
        this.imageUri = product.getImageUrl();
    }
}
