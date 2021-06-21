import { Order } from './../../../model/order';
import { PedidoService } from './../../../controller/pedido.service';
import { ProdutoService } from './../../../controller/produto.service';
import { Product } from './../../../model/product';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'sup-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})
export class OrdersComponent implements OnInit {

  products!: Product[]
  selectedContact: any;
  order!: Order[];
  modalRef: any;
  message: any;
  constructor(private productService: ProdutoService, private pedidos: PedidoService) { }

  ngOnInit(): void {
    this.getAllProducts();
  }

  getAllProducts() {
    this.pedidos.getAllOrders().subscribe((result) => {
      this.order = result;
    })
  }
  selectContact(contact: any){
    this.selectedContact = contact;
  }
 
  decline(): void {
    this.modalRef.hide();
  }

}
