package c;

public class Conta {
    private int numero;
    private float saldo;
    private String tipo;

    public int getNumero() {
        return numero;
    }

    public float getSaldo() {
        return saldo;
    }

    public String getTipo() {
        return tipo;
    }

    public void cadastraConta(int numerocad, float saldocad, String tipocad){
        numero = numerocad;
        if(saldocad >= 100) saldo = saldocad;
        else saldo = 100;
        tipo = tipocad;
    }

    public boolean sacar(float valorsaque){
        if(valorsaque <= (saldo + 100)){
            saldo -= valorsaque;
            return true;
        }else
            return false;
    }

    public void retornaSaldo(){
        System.out.println("O saldo da conta "+numero+"eh: "+saldo);
    }
    public void depositar(float valordeposito){
        saldo += valordeposito;
    }

    public boolean transferencia(Conta conta_orig, Conta conta_dest, float valor_transf){
        if(conta_orig.sacar(valor_transf)) {
            conta_dest.depositar(valor_transf);
            return true;
        }else
            return false;
    }
}
