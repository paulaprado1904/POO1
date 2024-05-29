package A;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;

public class Funcionarios {

    private String nome;
    private String rg;
    private float salariobase;
    private LocalDate dataEntrada;

    public Funcionarios(String nome, String rg, float salariobase, LocalDate dataEntrada) {
        this.nome = nome;
        this.rg = rg;
        this.salariobase = salariobase;
        this.dataEntrada = dataEntrada;
    }

    public int anosNaEmpresa() {
        LocalDate hoje = LocalDate.now();
        Period periodo = Period.between(dataEntrada, hoje);
        return periodo.getYears(); // Retorna o número de anos
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public float getSalariobase() {
        return salariobase;
    }

    public void setSalariobase(float salariobase) {
        this.salariobase = salariobase;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }
}
