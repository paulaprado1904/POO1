package A;

public abstract class Funcionario {
        private String nome;
        private String  matriucla;
        private double salario_base;

        public Funcionario(String nome, String matriucla, double salario_base){
            this.nome = nome;
            this.matriucla = matriucla;
            this.salario_base = salario_base;
        }

    public String getNome() {
        return nome;
    }

    public String getMatriucla() {
        return matriucla;
    }

    public double getSalario_base() {
        return salario_base;
    }

    public abstract double calculaSalario();
}
