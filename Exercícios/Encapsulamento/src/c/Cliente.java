package c;
import java.util.Scanner;
import javax.lang.model.type.NullType;
import java.text.DecimalFormat;
public class Cliente {
    private String nome, CPF, telefone, usuario, senha;
    private int idade;
    private Conta conta;
    public void cadastraCliente(String nomecad, String CPFcad, String telefonecad,
                     int idadecad, Conta contacad, String usuariocad, String senhacad){

    nome = nomecad;
    CPF = CPFcad;
    telefone = telefonecad;
    idade = idadecad;
    conta = contacad;
    usuario = usuariocad;
    senha = senhacad;
    }

    public void extrato(){
        System.out.println("Numero conta:"+conta.getNumero());
        System.out.println("Nome do Cliente:"+nome);
        System.out.println("Saldo:"+conta.getSaldo());
    }

    public void negativado(){
        if (conta.getSaldo() < 0)
            extrato();
    }

    private int intervalo_a, intervalo_b;
    public void idades(int intervalo_a, int intervalo_b){
        if ((idade >= intervalo_a) && (idade <= intervalo_b))
            extrato();
    }
}
