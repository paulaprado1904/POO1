package D;

class Conta {
    private String nome;
    private double saldo;
    private int numero;

    public Conta(String nome, double saldo, int numero) {
        this.nome = nome;
        this.saldo = saldo;
        this.numero = numero;
    }

    public void sacar(double valor) throws SaldoInsuficienteException {
        if (valor > saldo) {
            throw new SaldoInsuficienteException("Saldo insuficiente para saque.");
        } else {
            saldo -= valor;
        }
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public double getSaldo() {
        return saldo;
    }

    public int getNumero() {
        return numero;
    }

    public void visualizarSaldo() {
        System.out.println("Saldo da Conta " + numero + ": R$" + saldo);
    }
}

class SaldoInsuficienteException extends Exception {
    public SaldoInsuficienteException(String mensagem) {
        super(mensagem);
    }
}
