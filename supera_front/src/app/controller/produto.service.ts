import { Product } from './../model/product';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ProdutoService {

  constructor(private http: HttpClient) { }

  getAllProduct(): Observable<Product[]> {
    return this.http.get<Product[]>(`${environment.url}/produto`);
  }
  getProductById(id: any): Observable<Product> {
    return this.http.get<Product>(`${environment.url}/produto/${id}`);
  }
  calcularFrete(order: any): Observable<any> {
    return this.http.post<any>(`${environment.url}/produto/frete`, order)
  }
  saveProduct(product: any): Observable<any> {
    return this.http.post<any>(`${environment.url}/produto`, product)
  }
}
