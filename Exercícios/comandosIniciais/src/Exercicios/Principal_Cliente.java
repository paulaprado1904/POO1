package Exercicios;
import java.util.Scanner;
public class Principal_Cliente {

    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        Scanner s = new Scanner(System.in);
        String nome, cpf, telefone;
        int idade;

        System.out.println("Insira o nome:");
        nome = s.nextLine();
        System.out.println("Insira o CPF:");
        cpf = s.nextLine();
        System.out.println("Insira a idade:");
        idade = s.nextInt();
        s.nextLine();
        System.out.println("Insira o telefone:");
        telefone = s.nextLine();

        cliente.cadastrarCliente(nome, cpf, idade, telefone);
        cliente.mostrarDadosCliente();
    }
}
