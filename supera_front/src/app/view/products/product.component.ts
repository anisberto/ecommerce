import { Product } from './../../model/product';
import { ProdutoService } from './../../controller/produto.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'sup-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {
  products!: Product[]
  product: Product={
    id: '',
    name: '',
    price: '',
    score: '',
    imageUri: ''
  };
  productSaved!: Product;

  existeProduct: boolean = true;

  constructor(private productService: ProdutoService) { }

  ngOnInit(): void {
    this.getAllProducts();
    if (this.products.length == 0) {
      this.existeProduct = false;
    }
  }

  getAllProducts() {
    this.productService.getAllProduct().subscribe((result) => {
      this.products = result;
    })
  }

  saveProduct() {
    if (this.product !== null || this.product !== undefined) {
      this.productService.saveProduct(this.product).subscribe((result) => {
        this.productSaved = result
        alert("Produto: " + this.productSaved.name + "! Salvo com Sucesso")
      })
    }
  }
}
