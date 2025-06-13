package estabelecimento;

import java.util.ArrayList;
import java.util.List;

import cardapio.ItemCardapio;
import cliente.Pessoa;

public class Estabelecimento {
    private String nome;
    private List<ItemCardapio> cardapio;
    private List<Pedido> pedidos = new ArrayList<Pedido>();
    private int numero_de_pedidos = 0;

    public Estabelecimento(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<ItemCardapio> getCardapio() {
        return cardapio;
    }

    public void setCardapio(List<ItemCardapio> cardapio) {
        this.cardapio = cardapio;
    }

    public int gerarPedido(Pessoa cliente, List<ItemPedido> itens) {
        Pedido novo_pedido = new Pedido((numero_de_pedidos + 1), itens, cliente);

        this.pedidos.add(novo_pedido);

        return novo_pedido.getId();
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }
}
