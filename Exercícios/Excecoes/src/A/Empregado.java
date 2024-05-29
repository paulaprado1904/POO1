package A;

import java.io.Serializable;
public class Empregado implements Comparable<Empregado>, Serializable {
    // Atributos
    private String CPF;
    private int idade;
    private double salario;

    // Construtor
    public Empregado(final String CPF, final int idade, final double salario) {
        this.CPF = CPF;
        this.idade = idade;
        this.salario = salario;
    }

    // Métodos de acesso (Getters e Setters)
    public String getCPF() {
        return CPF;
    }

    public void setCPF(final String CPF) {
        this.CPF = CPF;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(final int idade) {
        this.idade = idade;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(final double salario) {
        this.salario = salario;
    }

    public void retornaDados(){
        System.out.println("CPF:" + this.getCPF());
        System.out.println("Idade: " + this.getIdade());
        System.out.println("Salario: " + this.getSalario());
    }
    @Override
    public int compareTo(Empregado o) {
        if (this.idade < (o.getIdade()))
            return -1;
        if (this.idade == (o.getIdade()))
            return 0;

        return 1;
    }
}
