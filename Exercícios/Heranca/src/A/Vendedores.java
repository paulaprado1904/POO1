package A;

import java.time.LocalDate;

public class Vendedores extends Funcionarios{
    float totalVendas;
    float salariofinal;

    public Vendedores(String nome, String rg, float salariobase, LocalDate dataEntrada, float totalVendas) {
        super(nome, rg, salariobase, dataEntrada);
        this.totalVendas = totalVendas;
        this.salariofinal = (totalVendas * 5/100) + getSalariobase();
    }

    public float getTotalVendas() {
        return totalVendas;
    }

    public void setTotalVendas(float totalVendas) {
        this.totalVendas = totalVendas;
    }

    public float getSalariofinal() {
        return salariofinal;
    }

    public void setSalariofinal(float salariofinal) {
        this.salariofinal = salariofinal;
    }
}
