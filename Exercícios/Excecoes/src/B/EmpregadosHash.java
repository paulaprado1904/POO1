package B;
import java.util.*;

public class EmpregadosHash implements Comparable<EmpregadosHash> {
    private String CPF;
    private int idade;
    private double salario;

    // Construtor
    public EmpregadosHash(String CPF, int idade, double salario) {
        this.CPF = CPF;
        this.idade = idade;
        this.salario = salario;
    }

    // Getters
    public String getCPF() {
        return CPF;
    }

    public int getIdade() {
        return idade;
    }

    public double getSalario() {
        return salario;
    }

    // Implementação do Comparable
    @Override
    public int compareTo(EmpregadosHash outro) {
        return Integer.compare(this.idade, outro.idade);
    }
}
