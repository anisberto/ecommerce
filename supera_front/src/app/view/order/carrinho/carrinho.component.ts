import { ProdutoService } from './../../../controller/produto.service';
import { Order, OrderDTO } from './../../../model/order';
import { PedidoService } from './../../../controller/pedido.service';
import { CarrinhoService } from './../../../controller/carrinho.service';
import { Component, OnInit } from '@angular/core';
import { ItemCarrinho } from 'src/app/model/ItemCarrinho';

@Component({
  selector: 'sup-carrinho',
  templateUrl: './carrinho.component.html',
  styleUrls: ['./carrinho.component.css']
})
export class CarrinhoComponent implements OnInit {

  public itensCarrinho: any[] = []

  public idPedidoCompra!: number
  total: any
  order: Order = {
    id: 0,
    moment: '', shipping: '', status: 1,
    address: '', products: [], total: ''
  };

  endereco: any;
  numero: any;
  complemento: any;
  returnOrder!: Order;
  totalFrete: any;

  constructor(
    public carrinho: CarrinhoService,
    public pedido: PedidoService,
    public produt: ProdutoService
  ) { }
  ngOnInit() {
    this.itensCarrinho = this.carrinho.itens;
  }

  public adicionar(item: ItemCarrinho): void {
    this.carrinho.adicionarQuantidade(item)
  }
  public diminuir(item: ItemCarrinho): void {
    this.carrinho.diminuirQuantidade(item)
  }

  public saveOrder() {
    this.order.address = this.endereco + ", " + this.numero + ", " + this.complemento;
    this.order.products = this.itensCarrinho
    this.order.total = this.carrinho.totalCarrinhoCompras()
    this.pedido.saveOrder(this.order).subscribe((result) => {
      this.returnOrder;
    })

  }
}
