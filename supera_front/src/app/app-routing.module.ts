import { ProductDetailComponent } from './view/products/product-detail/product-detail.component';
import { CarrinhoComponent } from './view/order/carrinho/carrinho.component';
import { NotfoundComponent } from './view/notfound/notfound.component';
import { OrdersComponent } from './view/order/orders/orders.component';
import { ClienteComponent } from './view/cliente/cliente.component';
import { ProductComponent } from './view/products/product.component';
import { HomeComponent } from './view/home/home.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'cliente', component: ClienteComponent },
  { path: 'orders', component: OrdersComponent },
  { path: 'product', component: ProductComponent },
  { path: 'product/:id', component: ProductDetailComponent },
  { path: 'carrinho', component: CarrinhoComponent },
  { path: '**', component: NotfoundComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
