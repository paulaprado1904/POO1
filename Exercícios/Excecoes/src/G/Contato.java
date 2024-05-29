package G;

import java.io.Serializable;

public class Contato implements Serializable {
    private String nome;
    private int idade;
    private String sexo;
    private String profissao;
    private String telefone;
    private String email;

    public Contato(String nome, int idade, String sexo, String profissao, String telefone, String email) {
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.profissao = profissao;
        this.telefone = telefone;
        this.email = email;
    }

    @Override
    public String toString() {
        return nome + "," + idade + " anos, sexo " + sexo + "," + profissao + ", telefone n.º " + telefone + ", e-mail: " + email;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }
}
