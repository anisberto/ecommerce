package br.com.supera.ecommerce.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@Entity
@Table(name = "produto")
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private Double price;
    @NotBlank
    private String score;
    @NotBlank
    @Column(name = "image")
    private String imageUrl;

}
