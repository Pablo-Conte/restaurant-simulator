package pc.com.restaurant.simulator.estabelecimento;

import cardapio.Bebida;
import cardapio.ItemCardapio;
import cardapio.Lanche;
import cliente.Pessoa;
import java.util.ArrayList;
import java.util.List;

public class Estabelecimento {
    private String nome;
    private List<ItemCardapio> cardapio;
    private List<Pedido> pedidos = new ArrayList<>();
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
        List<ItemPedido> itensCopiados = new ArrayList<>(itens);
        
        Pedido novo_pedido = new Pedido((numero_de_pedidos + 1), itensCopiados, cliente);

        this.numero_de_pedidos = this.numero_de_pedidos + 1;
        
        this.pedidos.add(novo_pedido);

        return novo_pedido.getId();
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }
    
    public ItemCardapio getItemCardapioFromCardapio(String nome) {
        for (ItemCardapio IC : cardapio) {
            if (IC.getNome().equals(nome)) {
                if (IC instanceof Bebida) {
                    return new Bebida(IC.getNome(), IC.getPreco());
                } else if (IC instanceof Lanche) {
                    return new Lanche(IC.getNome(), IC.getPreco());
                } else {
                    throw new RuntimeException("Tipo desconhecido de ItemCardapio: " + IC.getClass());
                }
            }
        }

        throw new RuntimeException("Item não encontrado no cardápio: " + nome);
    }
    
    public Pedido getPedidoById(int id) {
        for (Pedido pedido : pedidos) {
            if (pedido.getId() == id) {
                return pedido;
            }
        }
        return null;
    }
    
    public boolean removerPedidoById(int id) {
        for (Pedido pedido : pedidos) {
            if (pedido.getId() == id) {
                pedidos.remove(pedido);
                return true;
            }
        }
        return false;
    }
}
