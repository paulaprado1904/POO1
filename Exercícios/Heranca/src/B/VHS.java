package B;

public class VHS extends Midia{
    private boolean rebobinada;

    public VHS(String nome, String tipo, String genero, float preco, boolean disponivel, boolean rebobinada){
        super(nome, tipo, genero, preco, disponivel);
        this.rebobinada = rebobinada;
    }

    public boolean isRebobinada() {
        return rebobinada;
    }

    public void setRebobinada(boolean rebobinada) {
        this.rebobinada = rebobinada;
    }
}
