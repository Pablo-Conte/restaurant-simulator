package pc.com.restaurant.simulator;

import pc.com.restaurant.simulator.ui.MainFrame;
import java.util.ArrayList;
import pc.com.restaurant.simulator.cardapio.Bebida;
import pc.com.restaurant.simulator.cardapio.ItemCardapio;
import pc.com.restaurant.simulator.cardapio.Lanche;
import pc.com.restaurant.simulator.cliente.Pessoa;

import pc.com.restaurant.simulator.estabelecimento.Estabelecimento;

public class RestaurantSimulator {
    public static void main(String[] args) throws Exception {
        Estabelecimento tiririca = new Estabelecimento("Tiririca Lanches");

        ArrayList<ItemCardapio> cardapio = new ArrayList<>();

        // Bebidas
        cardapio.add(new Bebida("Coca-cola", 10.00));
        cardapio.add(new Bebida("Guaraná", 9.00));
        cardapio.add(new Bebida("Suco de Laranja", 8.50));
        cardapio.add(new Bebida("Água sem gás", 4.00));
        cardapio.add(new Bebida("Água com gás", 4.50));
        cardapio.add(new Bebida("Chá Gelado", 7.00));

        // Lanches
        cardapio.add(new Lanche("Pastel", 20.50));
        cardapio.add(new Lanche("X-Salada", 22.00));
        cardapio.add(new Lanche("X-Bacon", 25.00));
        cardapio.add(new Lanche("Misto Quente", 12.00));
        cardapio.add(new Lanche("Coxinha", 7.00));
        cardapio.add(new Lanche("Empada", 6.50));

        tiririca.setCardapio(cardapio);
        
        Pessoa cliente = new Pessoa("Pablo");
        
        MainFrame frame = new MainFrame(tiririca, cliente);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}