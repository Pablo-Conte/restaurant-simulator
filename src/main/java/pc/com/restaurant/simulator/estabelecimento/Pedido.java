package pc.com.restaurant.simulator.estabelecimento;

import java.util.List;

import java.time.LocalDateTime;
import pc.com.restaurant.simulator.cliente.Pessoa;

public class Pedido {
    int id;
    List<ItemPedido> itens;
    Pessoa cliente;
    StatusPedido status;
    LocalDateTime  horaPedido;

    public Pedido(int id, List<ItemPedido> itens, Pessoa cliente) {
        this.id = id;
        this.itens = itens;
        this.status = StatusPedido.em_preparo;
        this.cliente = cliente;
        this.horaPedido = LocalDateTime.now();
    }

    public LocalDateTime getHoraPedido() {
        return horaPedido;
    }

    public void setHoraPedido(LocalDateTime horaPedido) {
        this.horaPedido = horaPedido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }

    public Pessoa getCliente() {
        return cliente;
    }

    public void setCliente(Pessoa client) {
        this.cliente = client;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }
    
    public double calcularTotal() {
        double total = 0.0;
        for (ItemPedido itemPedido : itens) {
            total += itemPedido.getQuantidade() * itemPedido.getItemCardapio().getPreco();
        }
        System.out.println(total);
        return total;
    }
}
