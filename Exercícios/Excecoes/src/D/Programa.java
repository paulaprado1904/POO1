package D;

public class Programa {
    public static void main(String[] args) {
        Conta[] contas = new Conta[5];

        contas[0] = new Conta("João", 1000.0, 1);
        contas[1] = new Conta("Maria", 2000.0, 2);
        contas[2] = new Conta("Pedro", 1500.0, 3);
        contas[3] = new Conta("Lucia", 3000.0, 4);
        contas[4] = new Conta("Carlos", 2500.0, 5);

        try {
            contas[0].visualizarSaldo();
            contas[0].sacar(500.0);
            contas[0].visualizarSaldo();
            contas[0].depositar(200.0);
            contas[0].visualizarSaldo();

            // Tenta sacar um valor maior que o saldo disponível
            contas[1].visualizarSaldo();
            contas[1].sacar(3000.0); // lança uma exceção
        } catch (SaldoInsuficienteException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}


