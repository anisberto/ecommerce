import { CarrinhoService } from './../../../controller/carrinho.service';
import { Product } from './../../../model/product';
import { ProdutoService } from './../../../controller/produto.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'sup-product-detail',
  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.css']
})
export class ProductDetailComponent implements OnInit {

  constructor(private activateRouter: ActivatedRoute, private produtoService: ProdutoService, private carrinhosService: CarrinhoService) { }
  product!: Product;

  ngOnInit(): void {
    const id = this.activateRouter.snapshot.paramMap.get('id');
    this.produtoService.getProductById(id).subscribe((result: any) => {
      this.product = result;
    })
  }

  public adicionarItemCarrinho(): void {
    this.carrinhosService.incluirItem(this.product)
    alert(this.product.name + " Foi adicionado ao carrinho")
  }

}
