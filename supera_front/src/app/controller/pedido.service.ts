import { environment } from './../../environments/environment';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class PedidoService {

  constructor(private http: HttpClient) { }

  saveOrder(order: any): Observable<any> {
    return this.http.post(`${environment.url}/pedido`, order);
  }

  getAllOrders(): Observable<any[]>{
    return this.http.get<any[]>(`${environment.url}/pedido`);
  }
}
