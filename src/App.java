import java.util.ArrayList;
import java.util.List;

import cardapio.Bebida;
import cardapio.ItemCardapio;
import cardapio.Lanche;
import cliente.Pessoa;
import estabelecimento.Estabelecimento;
import estabelecimento.ItemPedido;
import estabelecimento.Pedido;

public class App {
    public static void main(String[] args) throws Exception {
        Estabelecimento tirica = new Estabelecimento("Tirica");

        ItemCardapio cocaCola = new Bebida("Coca-cola", 10.00);
        ItemCardapio pastel = new Lanche("Pastel", 20.5);

        List<ItemPedido> itensDoPedido = new ArrayList<>();

        ItemPedido itemCocaCola = new ItemPedido(cocaCola, 1);
        ItemPedido itemPastel = new ItemPedido(pastel, 2);

        itensDoPedido.add(itemCocaCola);
        itensDoPedido.add(itemPastel);

        Pessoa pablo = new Pessoa("Pablo");

        tirica.gerarPedido(pablo, itensDoPedido);

        System.out.println("Pedido gerado com sucesso!");
        List<Pedido> pedidos = tirica.getPedidos();

        for (Pedido pedido : pedidos) {
            System.out.println("Pedido ID: " + pedido.getId());
            System.out.println("Cliente: " + pedido.getCliente().getNome());
            System.out.println("Itens do Pedido:");
            for (ItemPedido item : pedido.getItens()) {
                System.out.println("- " + item.getItemCardapio().getNome() + " x" + item.getQuantidade());
            }
            System.out.println("Status do Pedido: " + pedido.getStatus());
            System.out.println();
        }
    }
}
