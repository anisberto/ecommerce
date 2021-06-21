package br.com.supera.ecommerce.utilities;

import br.com.supera.ecommerce.entities.Order;

public class CalculoDeFrete {

    public static Double calcularFrete(Order order) {
        Double total = 0.0;
        Double preco = 0.0;
        for (int i = 0; i < order.getProducts().size(); i++) {
            total += 10;
        }
        return order.getTotal() >= 250 ? 0.0 : total;
    }
}
