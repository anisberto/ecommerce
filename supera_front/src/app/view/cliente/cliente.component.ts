import { ProdutoService } from './../../controller/produto.service';
import { Product } from './../../model/product';
import { Component, OnInit, TemplateRef } from '@angular/core';

@Component({
  selector: 'sup-cliente',
  templateUrl: './cliente.component.html',
  styleUrls: ['./cliente.component.css']
})
export class ClienteComponent implements OnInit {

  products!: Product[]
  selectedContact: any;
  modalRef: any;
  message: any;
  constructor(private productService: ProdutoService) { }

  ngOnInit(): void {
    this.getAllProducts();
  }

  getAllProducts() {
    this.productService.getAllProduct().subscribe((result) => {
      this.products = result;
    })
  }
  selectContact(contact: any){
    this.selectedContact = contact;
  }
 
  decline(): void {
    this.modalRef.hide();
  }
}
