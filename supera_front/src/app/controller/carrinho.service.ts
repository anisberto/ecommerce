import { Product } from './../model/product';
import { Injectable } from '@angular/core';
import { ItemCarrinho } from '../model/ItemCarrinho';

@Injectable({
  providedIn: 'root'
})
export class CarrinhoService {
  public itens: ItemCarrinho[] = []

  public exibirItens(): ItemCarrinho[] {
    return this.itens
  }

  public incluirItem(oferta: Product): void {
    let itemCarrinho: ItemCarrinho = new ItemCarrinho(
      oferta.id,
      oferta.imageUri,
      oferta.name,
      oferta.score,
      oferta.price,
      1
    )

    let itemCarrinhoEncontrado = this.itens.find((item: ItemCarrinho) => item.id === itemCarrinho.id)
    if (itemCarrinhoEncontrado) {
      itemCarrinhoEncontrado.quantidade += 1
    } else {
      this.itens.push(itemCarrinho)
    }

  }
  public totalCarrinhoCompras(): number {
    let total: number = 0
    this.itens.map((item: ItemCarrinho) => {
      total = total + (item.valor * item.quantidade)
    })
    return total
  }
  public adicionarQuantidade(itemCarrinho: ItemCarrinho): void {
    let itemCarrinhoEncontrado = this.itens.find((item: ItemCarrinho) => item.id === itemCarrinho.id)
    if (itemCarrinhoEncontrado) {
      itemCarrinhoEncontrado.quantidade += 1
    }
  }

  public diminuirQuantidade(itemCarrinho: ItemCarrinho): void {
    let itemCarrinhoEncontrado = this.itens.find((item: ItemCarrinho) => item.id === itemCarrinho.id)
    if (itemCarrinhoEncontrado) {
      itemCarrinhoEncontrado.quantidade -= 1

      if (itemCarrinhoEncontrado.quantidade === 0) {
        this.itens.splice(this.itens.indexOf(itemCarrinhoEncontrado), 1)
      }
    }
  }

  public limparCarrinho(): void {
    this.itens = []
  }

}
