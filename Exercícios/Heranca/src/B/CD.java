package B;

public class CD extends Midia{
    private String cantor;
    private int nFaixas;

    public CD(String nome, String tipo, String genero, float preco, boolean disponivel, String cantor, int nFaixas){
        super(nome,tipo,genero,preco,disponivel);
        this.cantor = cantor;
        this.nFaixas = nFaixas;
    }

    public String getCantor() {
        return cantor;
    }

    public void setCantor(String cantor) {
        this.cantor = cantor;
    }

    public int getnFaixas() {
        return nFaixas;
    }

    public void setnFaixas(int nFaixas) {
        this.nFaixas = nFaixas;
    }
}
