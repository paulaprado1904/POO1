package A;

public class Vendedor extends Funcionario{

    double comissao;
    public Vendedor(String nome, String matricula, double salario_base, double comissao){
        super(nome, matricula, salario_base);
        this.comissao = comissao;
    }

    @Override
    public double calculaSalario() {
        return getSalario_base() + comissao;
    }
}
