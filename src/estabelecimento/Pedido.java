package estabelecimento;

import java.util.List;

import cliente.Pessoa;

public class Pedido {
    int id;
    List<ItemPedido> itens;
    Pessoa cliente;
    StatusPedido status;

    public Pedido(int id, List<ItemPedido> itens, Pessoa cliente) {
        this.id = id;
        this.itens = itens;
        this.status = StatusPedido.em_progresso;
        this.cliente = cliente;
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
}
