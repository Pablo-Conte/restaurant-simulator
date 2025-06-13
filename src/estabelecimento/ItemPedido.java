package estabelecimento;

import cardapio.ItemCardapio;

public class ItemPedido {
    private ItemCardapio itemCardapio;
    private int quantidade;

    public ItemPedido(ItemCardapio itemCardapio, int quantidade) {
        this.itemCardapio = itemCardapio;
        this.quantidade = quantidade;
    }

    public ItemCardapio getItemCardapio() {
        return itemCardapio;
    }

    public void setItemCardapio(ItemCardapio itemCardapio) {
        this.itemCardapio = itemCardapio;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

}
