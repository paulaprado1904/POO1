package B;

import org.w3c.dom.DOMStringList;

import java.util.List;

public class DVD extends Midia{
    private List<String> atores;
    private String diretor;
    private int duracao;

    public DVD(String nome, String tipo, String genero, float preco, boolean disponivel, List<String> atores, String diretor, int duracao){
        super(nome, tipo, genero, preco, disponivel);
        this.atores = atores;
        this.diretor = diretor;
        this.duracao = duracao;
    }

    public int calcularNumeroAtores() {
        int numeroAtores = 0;
        for (String ator : atores) {
            numeroAtores++;
        }
        return numeroAtores;
    }

    public List<String> getAtores() {
        return atores;
    }

    public void setAtores(List<String> atores) {
        this.atores = atores;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }
}
