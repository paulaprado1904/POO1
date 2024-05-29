package B;

public class Midia {
    private String nome;
    private String tipo;
    private String genero;
    private float preco;
    private boolean disponvel;

    public Midia(String nome, String tipo, String genero, float preco, boolean disponvel){
        this.nome = nome;
        this.tipo = tipo;
        this.genero = genero;
        this.preco = preco;
        this.disponvel = disponvel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public boolean verificaDisponibilidade(){
        if (disponvel)
            return true;
        else
            return false;
    }
}
