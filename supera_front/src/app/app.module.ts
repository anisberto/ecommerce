import { CarrinhoService } from './controller/carrinho.service';
import { LOCALE_ID, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { HomeComponent } from './view/home/home.component';
import { ProductComponent } from './view/products/product.component';
import { OrderComponent } from './view/order/order.component';
import { HttpClientModule } from "@angular/common/http";
import { NavbarComponent } from './view/navbar/navbar.component';
import { ClienteComponent } from './view/cliente/cliente.component';
import { OrdersComponent } from './view/order/orders/orders.component';
import { ProductDetailComponent } from './view/products/product-detail/product-detail.component';
import { ProductUpdateComponent } from './view/products/product-update/product-update.component';
import { ClienteUpdateComponent } from './view/cliente/cliente-update/cliente-update.component';
import { NotfoundComponent } from './view/notfound/notfound.component';
import { CarrinhoComponent } from './view/order/carrinho/carrinho.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ProductComponent,
    OrderComponent,
    NavbarComponent,
    ClienteComponent,
    OrdersComponent,
    ProductDetailComponent,
    ProductUpdateComponent,
    ClienteUpdateComponent,
    NotfoundComponent,
    CarrinhoComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [CarrinhoService, { provide: LOCALE_ID, useValue: 'pt-Br' }],
  bootstrap: [AppComponent]
})
export class AppModule { }
