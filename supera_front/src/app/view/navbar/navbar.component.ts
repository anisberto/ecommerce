import { CarrinhoService } from './../../controller/carrinho.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'sup-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css'],
  providers: [CarrinhoService]
})
export class NavbarComponent implements OnInit {

  constructor(public carrinhoService: CarrinhoService) { }
  qtItens: any;
  ngOnInit(): void {
    this.qtItens = this.carrinhoService.itens.length;
  }

}
