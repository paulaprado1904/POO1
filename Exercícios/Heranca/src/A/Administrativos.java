package A;

import java.time.LocalDate;

public class Administrativos extends Funcionarios{
    float horasExtras;
    float salarioFinal;

    public Administrativos(String nome, String rg, float salariobase, LocalDate dataEntrada, float horasExtras) {
        super(nome, rg, salariobase, dataEntrada);
        this.horasExtras = horasExtras;
        this.salarioFinal = (getSalariobase() * horasExtras) + getSalariobase();
    }

    public float getHorasExtras() {
        return horasExtras;
    }

    public void setHorasExtras(float horasExtras) {
        this.horasExtras = horasExtras;
    }

    public float getSalarioFinal() {
        return salarioFinal;
    }

    public void setSalarioFinal(float salarioFinal) {
        this.salarioFinal = salarioFinal;
    }
}
