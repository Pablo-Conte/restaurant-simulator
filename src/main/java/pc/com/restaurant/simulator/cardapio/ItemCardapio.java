package pc.com.restaurant.simulator.cardapio;

public abstract class ItemCardapio {
    private String nome;
    private double preco;

    public ItemCardapio(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return getNome();
    }
    
    
}
